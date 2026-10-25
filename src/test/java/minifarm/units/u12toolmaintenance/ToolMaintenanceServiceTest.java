package minifarm.units.u12toolmaintenance;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.fixtures.FakeTool;
import minifarm.fixtures.FakeWalletPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U12")
@Tag("unit")
class ToolMaintenanceServiceTest {

    private ToolMaintenanceService maintenanceService;
    private FakeWalletPort walletPort;
    private FakeTool tool;

    @BeforeEach
    void setUp() {
        maintenanceService = new ToolMaintenanceService();
        walletPort = new FakeWalletPort(500L);
        tool = new FakeTool("hoe", "Hoe", 30);
    }

    @Test
    @DisplayName("Repair mengembalikan durability alat sampai batas maksimum dan mendebit koin")
    void repairTool_whenDamaged_restoresDurabilityAndDebitsWallet() {
        tool.use();
        tool.use();
        assertEquals(28, tool.getDurability());

        OperationResult<Void> result = maintenanceService.repairTool(tool, walletPort);

        assertTrue(result.isSuccess());
        assertEquals(30, tool.getDurability(), "Durability harus kembali ke 30 (maksimal)");
        assertEquals(480L, walletPort.getBalance(), "Saldo berkurang 20 koin");
    }

    @Test
    @DisplayName("Upgrade menaikkan level alat satu tingkat dan mendebit koin sesuai rumus level")
    void upgradeTool_increasesLevel() {
        assertEquals(1, tool.getLevel());

        OperationResult<Void> result = maintenanceService.upgradeTool(tool, walletPort); // Biaya: 50 * 1 = 50

        assertTrue(result.isSuccess());
        assertEquals(2, tool.getLevel(), "Level harus naik jadi 2");
        assertEquals(450L, walletPort.getBalance(), "Saldo berkurang 50 koin");
    }

    @Test
    @DisplayName("Repair pada alat yang masih utuh (durability penuh) ditolak")
    void repairTool_whenFullDurability_fails() {
        assertEquals(30, tool.getDurability());

        OperationResult<Void> result = maintenanceService.repairTool(tool, walletPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.ALREADY_COMPLETED, result.getCode());
        assertEquals(500L, walletPort.getBalance(), "Saldo tidak boleh berkurang saat gagal");
    }

    @Test
    @DisplayName("Saldo koin tidak cukup menolak perbaikan atau upgrade secara atomik")
    void maintenance_whenLowBalance_failsAtomically() {
        tool.use();
        FakeWalletPort poorWallet = new FakeWalletPort(5L); // Butuh 10 koin

        OperationResult<Void> result = maintenanceService.repairTool(tool, poorWallet);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_FUNDS, result.getCode());
        assertEquals(29, tool.getDurability(), "Durability tidak berubah saat gagal");
        assertEquals(5L, poorWallet.getBalance(), "Saldo tidak boleh berkurang");
    }
}

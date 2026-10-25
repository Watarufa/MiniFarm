package minifarm.units.u33upgrade;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.events.EventBus;
import minifarm.core.events.FarmUpgradePurchased;
import minifarm.fixtures.FakeCropSlotPort;
import minifarm.fixtures.FakeWalletPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U33")
@Tag("unit")
class FarmUpgradeServiceTest {

    private FarmUpgradeService upgradeService;
    private FakeCropSlotPort plotPort;
    private FakeWalletPort walletPort;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        upgradeService = new FarmUpgradeService(eventBus);
        plotPort = new FakeCropSlotPort(4, 8);
        walletPort = new FakeWalletPort(500L);

        upgradeService.registerUpgrade(new PlotExpansionUpgrade(plotPort));
    }

    @Test
    @DisplayName("Upgrade ekspansi petak mendebit koin dan menambah jumlah petak lahan secara atomik")
    void purchaseUpgrade_whenValid_expandsPlotsAndDebitsWallet() {
        AtomicInteger eventCount = new AtomicInteger(0);
        eventBus.subscribe(FarmUpgradePurchased.class, e -> eventCount.incrementAndGet());

        assertEquals(4, plotPort.getCurrentPlots());

        // Upgrade 1: biaya 100 * (0 + 1) = 100
        OperationResult<Void> result = upgradeService.purchaseUpgrade("upgrade_plot_expansion", 1, walletPort);

        assertTrue(result.isSuccess());
        assertEquals(5, plotPort.getCurrentPlots(), "Petak bertambah jadi 5");
        assertEquals(400L, walletPort.getBalance(), "Saldo berkurang 100 jadi 400");
        assertEquals(1, eventCount.get(), "Event FarmUpgradePurchased harus dipublikasikan");
    }

    @Test
    @DisplayName("Upgrade ditolak jika saldo koin tidak mencukupi (Atomisitas)")
    void purchaseUpgrade_whenLowBalance_failsAtomically() {
        FakeWalletPort poorWallet = new FakeWalletPort(50L); // Butuh 100 koin

        OperationResult<Void> result = upgradeService.purchaseUpgrade("upgrade_plot_expansion", 1, poorWallet);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_FUNDS, result.getCode());
        assertEquals(4, plotPort.getCurrentPlots(), "Petak tidak boleh bertambah");
        assertEquals(50L, poorWallet.getBalance(), "Saldo tidak boleh berkurang saat gagal");
    }

    @Test
    @DisplayName("Upgrade ditolak jika kapasitas sudah mencapai batas maksimum (Max Level)")
    void purchaseUpgrade_whenMaxLevel_fails() {
        plotPort.setPlotCount(8); // Sudah mencapai batas maksimal 8

        OperationResult<Void> result = upgradeService.purchaseUpgrade("upgrade_plot_expansion", 1, walletPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.CAPACITY_EXCEEDED, result.getCode());
        assertEquals(500L, walletPort.getBalance(), "Saldo tidak berkurang");
    }
}

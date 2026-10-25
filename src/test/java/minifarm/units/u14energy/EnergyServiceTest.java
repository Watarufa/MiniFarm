package minifarm.units.u14energy;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U14")
@Tag("unit")
class EnergyServiceTest {

    private EnergyService energyService;

    @BeforeEach
    void setUp() {
        energyService = new EnergyService(100, 100, new FixedCostPolicy());
    }

    @Test
    @DisplayName("Konsumsi energi yang valid mengurangi energi saat ini dengan tepat")
    void consumeEnergy_whenSufficient_reducesEnergy() {
        OperationResult<Void> result = energyService.consumeEnergy(20);

        assertTrue(result.isSuccess());
        assertEquals(80, energyService.getCurrentEnergy());
    }

    @Test
    @DisplayName("Konsumsi melebihi energi yang ada ditolak secara atomik tanpa memotong energi")
    void consumeEnergy_whenInsufficient_failsAtomically() {
        OperationResult<Void> result = energyService.consumeEnergy(120);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ENERGY, result.getCode());
        assertEquals(100, energyService.getCurrentEnergy(), "Energi tidak boleh berkurang saat gagal");
    }

    @Test
    @DisplayName("Pemulihan energi (restore) tidak melebihi batas maksimum")
    void restoreEnergy_clampsToMaxEnergy() {
        energyService.consumeEnergy(30);
        assertEquals(70, energyService.getCurrentEnergy());

        energyService.restoreEnergy(50);
        assertEquals(100, energyService.getCurrentEnergy(), "Energi mentok di 100");
    }

    @Test
    @DisplayName("Bukti Polymorphism: Policy yang berbeda menghitung biaya energi secara berbeda")
    void polymorphicCostPolicies_differInCalculations() {
        AbstractEnergyCostPolicy fixed = new FixedCostPolicy();
        AbstractEnergyCostPolicy toolAdj = new ToolAdjustedCostPolicy(2);
        AbstractEnergyCostPolicy profAdj = new ProfessionAdjustedCostPolicy(0.8);

        assertEquals(10, fixed.calculateCost(10, "plant"));
        assertEquals(9, toolAdj.calculateCost(10, "plant"));
        assertEquals(8, profAdj.calculateCost(10, "plant"));
    }
}


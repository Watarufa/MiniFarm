package minifarm.units.u04watering;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.fixtures.FakeEnergyPort;
import minifarm.fixtures.FakeToolEffectPort;
import minifarm.fixtures.FakeWaterablePlotPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U04")
@Tag("unit")
class WateringServiceTest {

    private WateringService wateringService;
    private FakeWaterablePlotPort plotPort;
    private FakeEnergyPort energyPort;
    private FakeToolEffectPort toolPort;

    @BeforeEach
    void setUp() {
        wateringService = new WateringService(new SinglePlotWatering());
        plotPort = new FakeWaterablePlotPort(4);
        energyPort = new FakeEnergyPort(100, 100);
        toolPort = new FakeToolEffectPort();
    }

    @Test
    @DisplayName("Penyiraman valid membuat petak lembap dan memotong energi serta durability")
    void waterPlot_whenValid_setsMoistAndConsumesEnergy() {
        OperationResult<Void> result = wateringService.waterPlot(0, plotPort, energyPort, toolPort);

        assertTrue(result.isSuccess());
        assertTrue(plotPort.isPlotMoist(0), "Petak harus berstatus lembap");
        assertEquals(95, energyPort.getCurrentEnergy(), "Energi harus berkurang 5");
        assertEquals(29, toolPort.getDurability("watering_can"), "Durability alat harus berkurang 1");
    }

    @Test
    @DisplayName("Petak yang sudah disiram menolak penyiraman ulang dan tidak memotong energi lagi")
    void waterPlot_whenAlreadyWatered_failsWithoutDeductingEnergy() {
        wateringService.waterPlot(0, plotPort, energyPort, toolPort);
        assertEquals(95, energyPort.getCurrentEnergy());

        // Siram ulang petak yang sama
        OperationResult<Void> secondWatering = wateringService.waterPlot(0, plotPort, energyPort, toolPort);

        assertTrue(secondWatering.isFailure());
        assertEquals(ResultCode.ALREADY_COMPLETED, secondWatering.getCode());
        assertEquals(95, energyPort.getCurrentEnergy(), "Energi tidak boleh berkurang pada aksi gagal");
    }

    @Test
    @DisplayName("Energi tidak mencukupi menolak penyiraman secara atomik")
    void waterPlot_whenInsufficientEnergy_failsAtomically() {
        FakeEnergyPort lowEnergy = new FakeEnergyPort(2, 100); // butuh 5
        OperationResult<Void> result = wateringService.waterPlot(1, plotPort, lowEnergy, toolPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ENERGY, result.getCode());
        assertFalse(plotPort.isPlotMoist(1), "Petak tidak boleh lembap jika energi gagal");
        assertEquals(2, lowEnergy.getCurrentEnergy(), "Energi tidak boleh berubah");
    }

    @Test
    @DisplayName("Bukti Polymorphism: SinglePlotWatering dan AreaWatering memiliki biaya dan efek berbeda")
    void polymorphicWateringMethods_differInEnergyAndBehavior() {
        WateringMethod single = new SinglePlotWatering();
        WateringMethod area = new AreaWatering();

        assertEquals(5, single.getEnergyCost());
        assertEquals(12, area.getEnergyCost());
        assertNotEquals(single.getMethodName(), area.getMethodName());
    }
}


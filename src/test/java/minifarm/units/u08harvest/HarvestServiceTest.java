package minifarm.units.u08harvest;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.events.CropHarvested;
import minifarm.core.events.EventBus;
import minifarm.fixtures.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U08")
@Tag("unit")
class HarvestServiceTest {

    private HarvestService harvestService;
    private EventBus eventBus;
    private FakeCropSlotPort slotPort;
    private FakeSoilPort soilPort;
    private FakeInventoryPort inventoryPort;
    private FakeEnergyPort energyPort;
    private FakeToolEffectPort toolPort;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        harvestService = new HarvestService(eventBus);
        slotPort = new FakeCropSlotPort(4);
        soilPort = new FakeSoilPort();
        inventoryPort = new FakeInventoryPort(20);
        energyPort = new FakeEnergyPort(100, 100);
        toolPort = new FakeToolEffectPort();
    }

    @Test
    @DisplayName("Pemanenan berhasil menambah hasil panen ke inventaris dan mengosongkan petak")
    void harvest_whenCropMature_succeedsAndClearsPlot() {
        // Taruh tanaman matang di petak 0
        slotPort.placeCrop(0, "wheat");

        AtomicInteger harvestEvents = new AtomicInteger(0);
        eventBus.subscribe(CropHarvested.class, e -> harvestEvents.incrementAndGet());

        OperationResult<Integer> result = harvestService.harvest(0, 1, slotPort, soilPort, inventoryPort, energyPort, toolPort);

        assertTrue(result.isSuccess());
        assertTrue(result.getOrNull() >= 2);
        assertTrue(slotPort.isPlotEmpty(0), "Petak harus kosong setelah panen");
        assertTrue(inventoryPort.hasItem("wheat", 2), "Hasil panen harus masuk ke inventaris");
        assertEquals(95, energyPort.getCurrentEnergy(), "Energi harus berkurang 5");
        assertEquals(1, harvestEvents.get(), "Event CropHarvested harus dipublikasikan");
    }

    @Test
    @DisplayName("Pemanenan tanaman yang belum ada atau petak kosong ditolak")
    void harvest_whenPlotEmpty_fails() {
        OperationResult<Integer> result = harvestService.harvest(3, 1, slotPort, soilPort, inventoryPort, energyPort, toolPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.NOT_FOUND, result.getCode());
        assertEquals(100, energyPort.getCurrentEnergy(), "Energi tidak boleh berkurang saat gagal");
    }

    @Test
    @DisplayName("Energi tidak mencukupi menolak panen tanpa mengubah inventaris atau petak (Atomisitas)")
    void harvest_whenLowEnergy_failsAtomically() {
        slotPort.placeCrop(0, "wheat");
        FakeEnergyPort lowEnergy = new FakeEnergyPort(2, 100);

        OperationResult<Integer> result = harvestService.harvest(0, 1, slotPort, soilPort, inventoryPort, lowEnergy, toolPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ENERGY, result.getCode());
        assertFalse(slotPort.isPlotEmpty(0), "Petak harus tetap terisi tanaman");
        assertFalse(inventoryPort.hasItem("wheat", 1), "Inventaris tidak boleh bertambah");
    }

    @Test
    @DisplayName("Bukti Polymorphism: ManualHarvestStrategy vs ToolAssistedHarvestStrategy memiliki aturan berbeda")
    void polymorphicStrategies_differInRequirementsAndYield() {
        AbstractHarvestStrategy manual = new ManualHarvestStrategy();
        AbstractHarvestStrategy tool = new ToolAssistedHarvestStrategy();

        assertEquals(5, manual.getEnergyCost());
        assertEquals(3, tool.getEnergyCost());
        assertNotEquals(manual.getStrategyName(), tool.getStrategyName());
    }
}


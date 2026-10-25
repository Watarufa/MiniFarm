package minifarm.units.u05soil;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import minifarm.fixtures.FakeInventoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U05")
@Tag("unit")
class SoilServiceTest {

    private SoilService soilService;
    private FakeInventoryPort inventoryPort;

    @BeforeEach
    void setUp() {
        soilService = new SoilService(4);
        inventoryPort = new FakeInventoryPort(20);
    }

    @Test
    @DisplayName("Kesuburan awal default adalah 50 dan tidak melebihi 100")
    void fertility_isClampedToMax100() {
        assertEquals(50, soilService.getSoilSnapshot(0).getFertility());

        soilService.applyFertilizer(0, 40); // 50 + 40 = 90
        assertEquals(90, soilService.getSoilSnapshot(0).getFertility());

        soilService.applyFertilizer(0, 30); // 90 + 30 -> max 100
        assertEquals(100, soilService.getSoilSnapshot(0).getFertility());
    }

    @Test
    @DisplayName("Pemberian pupuk dari inventaris mengonsumsi tepat 1 unit pupuk")
    void applyFertilizerFromInventory_consumesOneItem() {
        inventoryPort.addItem(GameConfig.ITEM_FERTILIZER, 2);

        OperationResult<Void> result = soilService.applyFertilizerFromInventory(0, inventoryPort);
        assertTrue(result.isSuccess());
        assertEquals(1, inventoryPort.getItemQuantity(GameConfig.ITEM_FERTILIZER), "Stok pupuk harus berkurang 1");
        assertEquals(70, soilService.getSoilSnapshot(0).getFertility(), "Default Loamy naik 20 poin");
    }

    @Test
    @DisplayName("Gagal memberi pupuk (stok habis) tidak mengubah kesuburan tanah")
    void applyFertilizerFromInventory_whenOutOfStock_failsWithoutMutatingSoil() {
        // Inventaris tidak memiliki pupuk
        OperationResult<Void> result = soilService.applyFertilizerFromInventory(0, inventoryPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ITEMS, result.getCode());
        assertEquals(50, soilService.getSoilSnapshot(0).getFertility(), "Kesuburan tidak boleh berubah");
    }

    @Test
    @DisplayName("Bukti Polymorphism: Sandy, Loamy, dan Clay memiliki nilai decay dan efek pupuk berbeda")
    void polymorphicSoilProfiles_haveDifferentProperties() {
        AbstractSoilProfile sandy = new SandySoilProfile(50);
        AbstractSoilProfile loamy = new LoamySoilProfile(50);
        AbstractSoilProfile clay = new ClaySoilProfile(50);

        assertEquals(8, sandy.getDecayRate());
        assertEquals(5, loamy.getDecayRate());
        assertEquals(3, clay.getDecayRate());

        assertEquals(15, sandy.getFertilizerEffect());
        assertEquals(20, loamy.getFertilizerEffect());
        assertEquals(18, clay.getFertilizerEffect());
    }

    @Test
    @DisplayName("Kesuburan di atas 80 memenuhi syarat bonus panen")
    void highFertility_qualifiesForBonusYield() {
        assertFalse(soilService.qualifiesForYieldBonus(0)); // 50 < 80

        soilService.applyFertilizer(0, 35); // 50 + 35 = 85 >= 80
        assertTrue(soilService.qualifiesForYieldBonus(0));
    }
}


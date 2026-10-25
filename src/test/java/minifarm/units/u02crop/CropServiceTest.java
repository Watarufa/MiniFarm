package minifarm.units.u02crop;

import minifarm.core.api.CropSnapshot;
import minifarm.core.config.GameConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U02")
@Tag("unit")
class CropServiceTest {

    private CropService cropService;

    @BeforeEach
    void setUp() {
        cropService = new CropService();
    }

    @Test
    @DisplayName("Tanaman tidak tumbuh jika kondisi tanah tidak lembap")
    void processCropGrowth_whenNotMoist_doesNotAdvanceGrowthDay() {
        AbstractCrop wheat = cropService.createCrop(GameConfig.CROP_WHEAT);
        assertEquals(0, wheat.getGrowthDay());

        cropService.processCropGrowth(wheat, false);
        assertEquals(0, wheat.getGrowthDay(), "Growth day tidak boleh bertambah jika kering");
        assertFalse(wheat.isMature());
    }

    @Test
    @DisplayName("Tanaman bertambah hari tumbuh jika kondisi lembap terpenuhi")
    void processCropGrowth_whenMoist_advancesGrowthDay() {
        AbstractCrop wheat = cropService.createCrop(GameConfig.CROP_WHEAT);
        cropService.processCropGrowth(wheat, true);

        assertEquals(1, wheat.getGrowthDay());
        assertFalse(wheat.isMature());
    }

    @Test
    @DisplayName("Tanaman mencapai status matang tepat pada ambang daysToMature")
    void crop_becomesMature_exactlyAtThreshold() {
        AbstractCrop wheat = cropService.createCrop(GameConfig.CROP_WHEAT); // butuh 2 hari
        cropService.processCropGrowth(wheat, true); // Hari 1
        assertFalse(wheat.isMature());

        cropService.processCropGrowth(wheat, true); // Hari 2
        assertTrue(wheat.isMature(), "Wheat harus matang setelah 2 hari tumbuh");

        // Tanaman matang tidak terus menambah hari
        cropService.processCropGrowth(wheat, true);
        assertEquals(2, wheat.getGrowthDay());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tiap tanaman memiliki daysToMature dan yield yang berbeda")
    void polymorphicCropBehavior_differentCropsHaveDifferentProperties() {
        AbstractCrop wheat = cropService.createCrop(GameConfig.CROP_WHEAT);
        AbstractCrop corn = cropService.createCrop(GameConfig.CROP_CORN);
        AbstractCrop tomato = cropService.createCrop(GameConfig.CROP_TOMATO);

        assertEquals(2, wheat.daysToMature());
        assertEquals(3, corn.daysToMature());
        assertEquals(2, tomato.daysToMature());

        assertEquals(2, wheat.baseYield());
        assertEquals(3, corn.baseYield());
        assertEquals(2, tomato.baseYield());
    }

    @Test
    @DisplayName("Tanaman mati (health 0) tidak dapat tumbuh")
    void deadCrop_doesNotGrow() {
        AbstractCrop wheat = cropService.createCrop(GameConfig.CROP_WHEAT);
        wheat.damage(100);
        assertTrue(wheat.isDead());

        cropService.processCropGrowth(wheat, true);
        assertEquals(0, wheat.getGrowthDay(), "Tanaman mati tidak boleh bertambah hari tumbuh");
    }
}


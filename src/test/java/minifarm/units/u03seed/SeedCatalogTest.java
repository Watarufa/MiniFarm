package minifarm.units.u03seed;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U03")
@Tag("unit")
class SeedCatalogTest {

    private SeedCatalog catalog;

    @BeforeEach
    void setUp() {
        catalog = new SeedCatalog();
    }

    @Test
    @DisplayName("Katalog awal harus memuat 3 benih standar (wheat, corn, tomato)")
    void initialCatalog_containsThreeSeeds() {
        List<PlantableSeed> seeds = catalog.getAllSeeds();
        assertEquals(3, seeds.size(), "Harus ada 3 benih di katalog awal");
        assertTrue(catalog.containsSeed(GameConfig.SEED_WHEAT));
        assertTrue(catalog.containsSeed(GameConfig.SEED_CORN));
        assertTrue(catalog.containsSeed(GameConfig.SEED_TOMATO));
    }

    @Test
    @DisplayName("Lookup benih valid mengembalikan data benih yang sesuai")
    void findSeed_withValidId_returnsCorrectMetadata() {
        OperationResult<PlantableSeed> result = catalog.findSeed(GameConfig.SEED_WHEAT);
        assertTrue(result.isSuccess());
        assertEquals(ResultCode.SUCCESS, result.getCode());
        assertNotNull(result.getOrNull());

        PlantableSeed seed = result.getOrNull();
        assertEquals(GameConfig.SEED_WHEAT, seed.getSeedId());
        assertEquals(GameConfig.CROP_WHEAT, seed.getCropType());
        assertEquals(GameConfig.WHEAT_SEED_PRICE, seed.getPrice());
    }

    @Test
    @DisplayName("Lookup benih tidak dikenal mengembalikan NOT_FOUND")
    void findSeed_withUnknownId_returnsNotFound() {
        OperationResult<PlantableSeed> result = catalog.findSeed("unknown_seed_id");
        assertTrue(result.isFailure());
        assertEquals(ResultCode.NOT_FOUND, result.getCode());
        assertNull(result.getOrNull());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tiap turunan AbstractSeedItem memiliki hari matang dan hasil berbeda")
    void polymorphicBehavior_differentSeedsHaveDifferentCharacteristics() {
        PlantableSeed wheat = catalog.getSeed(GameConfig.SEED_WHEAT).orElseThrow();
        PlantableSeed corn = catalog.getSeed(GameConfig.SEED_CORN).orElseThrow();
        PlantableSeed tomato = catalog.getSeed(GameConfig.SEED_TOMATO).orElseThrow();

        // Verifikasi perbedaan hari matang
        assertEquals(GameConfig.WHEAT_GROWTH_DAYS, wheat.getDaysToMature());
        assertEquals(GameConfig.CORN_GROWTH_DAYS, corn.getDaysToMature());
        assertEquals(GameConfig.TOMATO_GROWTH_DAYS, tomato.getDaysToMature());

        // Verifikasi perbedaan hasil panen dasar
        assertEquals(GameConfig.WHEAT_BASE_YIELD, wheat.getBaseYield());
        assertEquals(GameConfig.CORN_BASE_YIELD, corn.getBaseYield());
        assertEquals(GameConfig.TOMATO_BASE_YIELD, tomato.getBaseYield());
    }

    @Test
    @DisplayName("Daftar benih tidak membocorkan koleksi mutable internal")
    void getAllSeeds_returnsUnmodifiableList() {
        List<PlantableSeed> seeds = catalog.getAllSeeds();
        assertThrows(UnsupportedOperationException.class, () -> seeds.add(new WheatSeed()));
    }
}


package minifarm.units.u20shop;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U20")
@Tag("unit")
class ShopCatalogServiceTest {

    private ShopCatalogService shop;

    @BeforeEach
    void setUp() {
        shop = new ShopCatalogService();
    }

    @Test
    @DisplayName("Barang yang dijual di toko dapat ditemukan dengan harga integer non-negatif")
    void getItemPrice_whenAvailable_returnsPrice() {
        OperationResult<Long> priceRes = shop.getItemPrice(GameConfig.SEED_WHEAT);

        assertTrue(priceRes.isSuccess());
        assertEquals(GameConfig.WHEAT_SEED_PRICE, priceRes.getOrNull());
    }

    @Test
    @DisplayName("Lookup barang yang tidak dijual di toko menghasilkan NOT_FOUND")
    void getItemPrice_whenNotForSale_returnsNotFound() {
        OperationResult<Long> priceRes = shop.getItemPrice("dragon_egg");

        assertTrue(priceRes.isFailure());
        assertEquals(ResultCode.NOT_FOUND, priceRes.getCode());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Seksi toko yang berbeda memfilter kategori yang berbeda")
    void polymorphicSections_acceptDifferentCategories() {
        SeedShopSection seedSec = new SeedShopSection();
        ToolShopSection toolSec = new ToolShopSection();

        assertTrue(seedSec.acceptsCategory("seed"));
        assertFalse(seedSec.acceptsCategory("tool"));

        assertFalse(toolSec.acceptsCategory("seed"));
        assertTrue(toolSec.acceptsCategory("tool"));
    }
}


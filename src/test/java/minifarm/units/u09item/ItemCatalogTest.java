package minifarm.units.u09item;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U09")
@Tag("unit")
class ItemCatalogTest {

    private ItemCatalog catalog;

    @BeforeEach
    void setUp() {
        catalog = new ItemCatalog();
    }

    @Test
    @DisplayName("Item terdaftar dapat ditemukan dengan data kategori dan harga yang konsisten")
    void findItem_whenValid_returnsItem() {
        OperationResult<FarmItem> result = catalog.findItem(GameConfig.CROP_WHEAT);

        assertTrue(result.isSuccess());
        FarmItem item = result.getOrNull();
        assertNotNull(item);
        assertEquals("Wheat", item.getDisplayName());
        assertEquals("Produce", item.getCategory());
        assertEquals(GameConfig.WHEAT_SELL_PRICE, item.getBasePrice());
    }

    @Test
    @DisplayName("Lookup item yang tidak dikenal menghasilkan NOT_FOUND")
    void findItem_whenUnknown_returnsNotFound() {
        OperationResult<FarmItem> result = catalog.findItem("alien_seed");

        assertTrue(result.isFailure());
        assertEquals(ResultCode.NOT_FOUND, result.getCode());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tipe item yang berbeda memberikan perilaku canSell dan canConsume yang berbeda")
    void polymorphicItemBehavior_differentiatesSellAndConsume() {
        FarmItem produce = catalog.getItem(GameConfig.CROP_WHEAT).orElseThrow();
        FarmItem consumable = catalog.getItem(GameConfig.ITEM_ANIMAL_FEED).orElseThrow();
        FarmItem tool = catalog.getItem(GameConfig.TOOL_HOE).orElseThrow();

        assertTrue(produce.canSell(), "Produce dapat dijual");
        assertFalse(produce.canConsume(), "Produce tidak dikonsumsi langsung");

        assertFalse(consumable.canSell(), "Pakan hewan default non-sellable");
        assertTrue(consumable.canConsume(), "Pakan hewan dapat dikonsumsi");

        assertFalse(tool.canSell(), "Alat tidak dapat dijual");
        assertFalse(tool.canConsume(), "Alat tidak dapat dikonsumsi");
    }
}


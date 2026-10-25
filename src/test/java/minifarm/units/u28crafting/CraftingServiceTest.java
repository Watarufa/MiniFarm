package minifarm.units.u28crafting;

import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import minifarm.core.events.EventBus;
import minifarm.core.events.ItemCrafted;
import minifarm.fixtures.FakeEnergyPort;
import minifarm.fixtures.FakeInventoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U28")
@Tag("unit")
class CraftingServiceTest {

    private CraftingService craftingService;
    private FakeInventoryPort inventoryPort;
    private FakeEnergyPort energyPort;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        craftingService = new CraftingService(eventBus);
        inventoryPort = new FakeInventoryPort(20);
        energyPort = new FakeEnergyPort(100, 100);

        inventoryPort.addItem(GameConfig.CROP_WHEAT, 5);
    }

    @Test
    @DisplayName("Crafting valid mengonsumsi bahan, memotong energi, dan menambah output ke inventaris")
    void craft_whenValid_consumesIngredientsAndAddsOutput() {
        AtomicInteger eventCount = new AtomicInteger(0);
        eventBus.subscribe(ItemCrafted.class, e -> eventCount.incrementAndGet());

        // Resep pakan butuh 2 wheat -> 1 animal_feed
        OperationResult<ItemStack> result = craftingService.craft("recipe_feed", 1, inventoryPort, energyPort);

        assertTrue(result.isSuccess());
        assertEquals(1, result.getOrNull().getQuantity());
        assertEquals(3, inventoryPort.getItemQuantity(GameConfig.CROP_WHEAT), "Wheat berkurang 2 dari 5 jadi 3");
        assertEquals(1, inventoryPort.getItemQuantity(GameConfig.ITEM_ANIMAL_FEED), "Feed bertambah 1");
        assertEquals(98, energyPort.getCurrentEnergy(), "Energi berkurang 2");
        assertEquals(1, eventCount.get(), "Event ItemCrafted harus dipublikasikan");
    }

    @Test
    @DisplayName("Bahan kurang menolak proses crafting tanpa mengubah stok atau energi (Atomisitas)")
    void craft_whenInsufficientIngredients_failsAtomically() {
        FakeInventoryPort emptyBag = new FakeInventoryPort(20);

        OperationResult<ItemStack> result = craftingService.craft("recipe_feed", 1, emptyBag, energyPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ITEMS, result.getCode());
        assertEquals(100, energyPort.getCurrentEnergy(), "Energi tidak boleh berkurang saat gagal");
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tiap resep memiliki bahan dan output yang berbeda")
    void polymorphicRecipes_haveDifferentInputsAndOutputs() {
        AbstractCraftingRecipe feedRecipe = craftingService.getRecipe("recipe_feed").orElseThrow();
        AbstractCraftingRecipe fertRecipe = craftingService.getRecipe("recipe_fertilizer").orElseThrow();

        assertNotEquals(feedRecipe.getOutputItem().getItemId(), fertRecipe.getOutputItem().getItemId());
        assertNotEquals(feedRecipe.getRequiredIngredients().get(0).getItemId(), fertRecipe.getRequiredIngredients().get(0).getItemId());
    }
}


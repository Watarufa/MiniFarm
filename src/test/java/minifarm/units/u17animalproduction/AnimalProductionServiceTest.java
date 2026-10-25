package minifarm.units.u17animalproduction;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import minifarm.core.events.AnimalProductCollected;
import minifarm.core.events.EventBus;
import minifarm.fixtures.FakeFarmAnimalPort;
import minifarm.fixtures.FakeInventoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U17")
@Tag("unit")
class AnimalProductionServiceTest {

    private AnimalProductionService productionService;
    private EventBus eventBus;
    private FakeFarmAnimalPort animalPort;
    private FakeInventoryPort inventoryPort;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        productionService = new AnimalProductionService(eventBus);
        animalPort = new FakeFarmAnimalPort();
        inventoryPort = new FakeInventoryPort(20);
    }

    @Test
    @DisplayName("Ayam yang diberi makan dan sehat menghasilkan telur saat pemrosesan harian")
    void processDailyProduction_whenFedAndHealthy_producesEgg() {
        // Beri pakan ayam 1
        animalPort.feedAnimal("chicken_1", GameConfig.ITEM_ANIMAL_FEED);

        AtomicInteger eventCount = new AtomicInteger(0);
        eventBus.subscribe(AnimalProductCollected.class, e -> eventCount.incrementAndGet());

        productionService.processDailyProduction(1, animalPort, inventoryPort);

        assertEquals(1, inventoryPort.getItemQuantity(GameConfig.ITEM_EGG), "Harus ada 1 telur di inventaris");
        assertEquals(1, eventCount.get());
    }

    @Test
    @DisplayName("Ayam yang belum diberi makan tidak menghasilkan telur")
    void processDailyProduction_whenUnfed_producesNothing() {
        productionService.processDailyProduction(1, animalPort, inventoryPort);

        assertEquals(0, inventoryPort.getItemQuantity(GameConfig.ITEM_EGG));
        assertEquals(0, productionService.getPendingOutputs().size());
    }

    @Test
    @DisplayName("Produk hewan tidak hilang jika inventaris penuh, melainkan masuk ke pending output")
    void processDailyProduction_whenInventoryFull_storesInPendingOutputs() {
        FakeInventoryPort fullInventory = new FakeInventoryPort(0); // 0 slot tersedia
        animalPort.feedAnimal("chicken_1", GameConfig.ITEM_ANIMAL_FEED);

        productionService.processDailyProduction(1, animalPort, fullInventory);

        assertEquals(0, fullInventory.getItemQuantity(GameConfig.ITEM_EGG));
        assertEquals(1, productionService.getPendingOutputs().size(), "Harus tertampung di pendingOutputs");
        assertEquals(GameConfig.ITEM_EGG, productionService.getPendingOutputs().get(0).getItemId());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tiap aturan spesies menghasilkan produk yang berbeda")
    void polymorphicRules_produceDifferentItems() {
        EggProductionRule eggRule = new EggProductionRule();
        MilkProductionRule milkRule = new MilkProductionRule();

        AnimalSnapshot chicken = new AnimalSnapshot("c", "chicken", "C", 100, true, true);
        AnimalSnapshot cow = new AnimalSnapshot("w", "cow", "W", 100, true, true);

        assertEquals("egg", eggRule.calculateDailyProduction(chicken).orElseThrow().getItemId());
        assertEquals("milk", milkRule.calculateDailyProduction(cow).orElseThrow().getItemId());
    }
}


package minifarm.units.u16animalcare;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import minifarm.core.events.AnimalFed;
import minifarm.core.events.EventBus;
import minifarm.fixtures.FakeEnergyPort;
import minifarm.fixtures.FakeFarmAnimalPort;
import minifarm.fixtures.FakeInventoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U16")
@Tag("unit")
class AnimalCareServiceTest {

    private AnimalCareService careService;
    private EventBus eventBus;
    private FakeFarmAnimalPort animalPort;
    private FakeInventoryPort inventoryPort;
    private FakeEnergyPort energyPort;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        careService = new AnimalCareService(eventBus);
        animalPort = new FakeFarmAnimalPort();
        inventoryPort = new FakeInventoryPort(20);
        energyPort = new FakeEnergyPort(100, 100);

        inventoryPort.addItem(GameConfig.ITEM_ANIMAL_FEED, 2);
    }

    @Test
    @DisplayName("Memberi pakan mengurangi stok pakan 1 unit, memotong energi, dan menerbitkan event")
    void feedAnimal_whenValid_reducesFeedAndEnergyAndPublishesEvent() {
        AtomicInteger fedEvents = new AtomicInteger(0);
        eventBus.subscribe(AnimalFed.class, e -> fedEvents.incrementAndGet());

        OperationResult<Void> result = careService.feedAnimal("chicken_1", GameConfig.ITEM_ANIMAL_FEED, 1, animalPort, inventoryPort, energyPort);

        assertTrue(result.isSuccess());
        assertEquals(1, inventoryPort.getItemQuantity(GameConfig.ITEM_ANIMAL_FEED), "Stok pakan berkurang 1");
        assertEquals(97, energyPort.getCurrentEnergy(), "Energi berkurang 3");
        assertEquals(1, fedEvents.get(), "Event AnimalFed harus dipublikasikan");
    }

    @Test
    @DisplayName("Energi kurang menolak pemberian pakan tanpa memotong stok pakan (Atomisitas)")
    void feedAnimal_whenLowEnergy_failsAtomically() {
        FakeEnergyPort lowEnergy = new FakeEnergyPort(1, 100);

        OperationResult<Void> result = careService.feedAnimal("chicken_1", GameConfig.ITEM_ANIMAL_FEED, 1, animalPort, inventoryPort, lowEnergy);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ENERGY, result.getCode());
        assertEquals(2, inventoryPort.getItemQuantity(GameConfig.ITEM_ANIMAL_FEED), "Stok pakan tidak boleh terpotong");
    }

    @Test
    @DisplayName("Bukti Polymorphism: FeedAction, CleanAction, dan GroomAction memiliki nama aksi berbeda")
    void polymorphicActions_differInName() {
        AbstractAnimalCareAction feed = new FeedAction();
        AbstractAnimalCareAction clean = new CleanAction();
        AbstractAnimalCareAction groom = new GroomAction();

        assertNotEquals(feed.getActionName(), clean.getActionName());
        assertNotEquals(clean.getActionName(), groom.getActionName());
    }
}


package minifarm.units.u29order;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import minifarm.core.events.EventBus;
import minifarm.core.events.OrderCompleted;
import minifarm.fixtures.FakeInventoryPort;
import minifarm.fixtures.FakeWalletPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U29")
@Tag("unit")
class DeliveryOrderServiceTest {

    private DeliveryOrderService orderService;
    private FakeInventoryPort inventoryPort;
    private FakeWalletPort walletPort;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        orderService = new DeliveryOrderService(eventBus);
        inventoryPort = new FakeInventoryPort(20);
        walletPort = new FakeWalletPort(100L);

        inventoryPort.addItem(GameConfig.CROP_WHEAT, 5);
    }

    @Test
    @DisplayName("Pemenuhan pesanan valid memotong item yang diminta, mengkredit wallet, dan memancarkan event")
    void fulfillOrder_whenValid_consumesItemsAndCreditsWallet() {
        AtomicInteger eventCount = new AtomicInteger(0);
        eventBus.subscribe(OrderCompleted.class, e -> eventCount.incrementAndGet());

        // Order crop_1 butuh 3 wheat -> hadiah 40 koin
        OperationResult<Void> result = orderService.fulfillOrder("order_crop_1", 1, inventoryPort, walletPort);

        assertTrue(result.isSuccess());
        assertEquals(2, inventoryPort.getItemQuantity(GameConfig.CROP_WHEAT), "Wheat berkurang dari 5 jadi 2");
        assertEquals(140L, walletPort.getBalance(), "Saldo bertambah 40 koin dari 100 jadi 140");
        assertTrue(orderService.getOrder("order_crop_1").orElseThrow().isCompleted());
        assertEquals(1, eventCount.get(), "Event OrderCompleted harus dipublikasikan");
    }

    @Test
    @DisplayName("Pesanan yang sudah selesai tidak dapat dipenuhi dua kali (Idempotent)")
    void fulfillOrder_cannotBeFulfilledTwice() {
        orderService.fulfillOrder("order_crop_1", 1, inventoryPort, walletPort);

        OperationResult<Void> secondFulfill = orderService.fulfillOrder("order_crop_1", 1, inventoryPort, walletPort);

        assertTrue(secondFulfill.isFailure());
        assertEquals(ResultCode.ALREADY_COMPLETED, secondFulfill.getCode());
        assertEquals(140L, walletPort.getBalance(), "Saldo tidak boleh bertambah lagi");
    }

    @Test
    @DisplayName("Barang kurang menolak pemenuhan pesanan tanpa mengubah inventaris atau wallet (Atomisitas)")
    void fulfillOrder_whenInsufficientItems_failsAtomically() {
        FakeInventoryPort emptyBag = new FakeInventoryPort(20);

        OperationResult<Void> result = orderService.fulfillOrder("order_crop_1", 1, emptyBag, walletPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ITEMS, result.getCode());
        assertEquals(100L, walletPort.getBalance(), "Saldo tidak boleh berubah");
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tiap jenis pesanan meminta kombinasi item yang berbeda")
    void polymorphicOrders_requireDifferentItems() {
        AbstractDeliveryOrder cropOrder = orderService.getOrder("order_crop_1").orElseThrow();
        AbstractDeliveryOrder animalOrder = orderService.getOrder("order_animal_1").orElseThrow();
        AbstractDeliveryOrder mixedOrder = orderService.getOrder("order_mixed_1").orElseThrow();

        assertEquals(1, cropOrder.getRequiredItems().size());
        assertEquals(1, animalOrder.getRequiredItems().size());
        assertEquals(2, mixedOrder.getRequiredItems().size(), "Mixed order membutuhkan 2 jenis komoditas");
    }
}


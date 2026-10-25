package minifarm.units.u21purchase;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import minifarm.core.events.EventBus;
import minifarm.core.events.ItemPurchased;
import minifarm.fixtures.FakeInventoryPort;
import minifarm.fixtures.FakeShopCatalog;
import minifarm.fixtures.FakeWalletPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U21")
@Tag("unit")
class PurchaseServiceTest {

    private PurchaseService purchaseService;
    private FakeShopCatalog shop;
    private FakeWalletPort walletPort;
    private FakeInventoryPort inventoryPort;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        purchaseService = new PurchaseService(eventBus);
        shop = new FakeShopCatalog();
        walletPort = new FakeWalletPort(500L);
        inventoryPort = new FakeInventoryPort(20);
    }

    @Test
    @DisplayName("Pembelian valid mendebit wallet dan menambah item ke inventaris secara atomik")
    void purchase_whenValid_debitsWalletAndAddsItem() {
        AtomicInteger eventCount = new AtomicInteger(0);
        eventBus.subscribe(ItemPurchased.class, e -> eventCount.incrementAndGet());

        // Beli 2 wheat seed (harga 5 * 2 = 10)
        OperationResult<Void> result = purchaseService.purchase(GameConfig.SEED_WHEAT, 2, 1, shop, walletPort, inventoryPort);

        assertTrue(result.isSuccess());
        assertEquals(490L, walletPort.getBalance(), "Saldo berkurang 10 koin");
        assertEquals(2, inventoryPort.getItemQuantity(GameConfig.SEED_WHEAT), "Inventaris bertambah 2 seed");
        assertEquals(1, eventCount.get(), "Event ItemPurchased harus dipublikasikan");
    }

    @Test
    @DisplayName("Pembelian ditolak jika saldo tidak cukup tanpa mengubah inventaris (Atomisitas)")
    void purchase_whenLowBalance_failsAtomically() {
        FakeWalletPort poorWallet = new FakeWalletPort(5L); // Butuh 10 koin untuk 2 wheat seed

        OperationResult<Void> result = purchaseService.purchase(GameConfig.SEED_WHEAT, 2, 1, shop, poorWallet, inventoryPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_FUNDS, result.getCode());
        assertEquals(5L, poorWallet.getBalance(), "Saldo tidak boleh berubah");
        assertFalse(inventoryPort.hasItem(GameConfig.SEED_WHEAT, 1), "Item tidak boleh masuk ke tas");
    }

    @Test
    @DisplayName("Pembelian ditolak jika slot tas penuh tanpa memotong saldo koin (Atomisitas)")
    void purchase_whenInventoryFull_failsAtomically() {
        FakeInventoryPort fullInventory = new FakeInventoryPort(0);

        OperationResult<Void> result = purchaseService.purchase(GameConfig.SEED_WHEAT, 1, 1, shop, walletPort, fullInventory);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.CAPACITY_EXCEEDED, result.getCode());
        assertEquals(500L, walletPort.getBalance(), "Saldo tidak boleh terpotong saat tas penuh");
    }
}

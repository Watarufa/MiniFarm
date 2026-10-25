package minifarm.units.u23sale;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import minifarm.core.events.EventBus;
import minifarm.core.events.ItemSold;
import minifarm.fixtures.FakeInventoryPort;
import minifarm.fixtures.FakeItemCatalog;
import minifarm.fixtures.FakePricingService;
import minifarm.fixtures.FakeWalletPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U23")
@Tag("unit")
class SellingServiceTest {

    private SellingService sellingService;
    private FakeItemCatalog catalog;
    private FakePricingService pricingService;
    private FakeInventoryPort inventoryPort;
    private FakeWalletPort walletPort;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        sellingService = new SellingService(eventBus);
        catalog = new FakeItemCatalog();
        pricingService = new FakePricingService();
        inventoryPort = new FakeInventoryPort(20);
        walletPort = new FakeWalletPort(100L);

        inventoryPort.addItem(GameConfig.CROP_WHEAT, 10);
    }

    @Test
    @DisplayName("Penjualan berhasil mengurangi stok di inventaris dan menambah saldo wallet")
    void sellItem_whenValid_reducesInventoryAndCreditsWallet() {
        AtomicInteger sellEvents = new AtomicInteger(0);
        eventBus.subscribe(ItemSold.class, e -> sellEvents.incrementAndGet());

        // Jual 3 wheat (10 koin * 3 = 30)
        OperationResult<Long> result = sellingService.sellItem(
                GameConfig.CROP_WHEAT, 3, 1, catalog, pricingService, inventoryPort, walletPort
        );

        assertTrue(result.isSuccess());
        assertEquals(30L, result.getOrNull());
        assertEquals(7, inventoryPort.getItemQuantity(GameConfig.CROP_WHEAT), "Stok tersisa 7");
        assertEquals(130L, walletPort.getBalance(), "Saldo bertambah 30 jadi 130");
        assertEquals(1, sellEvents.get(), "Event ItemSold harus dipublikasikan");
    }

    @Test
    @DisplayName("Penjualan ditolak jika stok barang di tas tidak mencukupi (Atomisitas)")
    void sellItem_whenInsufficientStock_failsAtomically() {
        // Coba jual 15 wheat (hanya ada 10)
        OperationResult<Long> result = sellingService.sellItem(
                GameConfig.CROP_WHEAT, 15, 1, catalog, pricingService, inventoryPort, walletPort
        );

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ITEMS, result.getCode());
        assertEquals(10, inventoryPort.getItemQuantity(GameConfig.CROP_WHEAT), "Stok tas tidak berubah");
        assertEquals(100L, walletPort.getBalance(), "Saldo koin tidak boleh bertambah");
    }

    @Test
    @DisplayName("Bukti Polymorphism: SingleSalePolicy vs BatchSalePolicy menghitung validasi berbeda")
    void polymorphicSalePolicies_behaveDifferently() {
        AbstractSalePolicy single = new SingleSalePolicy();
        AbstractSalePolicy batch = new BatchSalePolicy();

        assertTrue(single.validateSale("wheat", 1, true).isSuccess());
        assertTrue(single.validateSale("wheat", 20, true).isSuccess());

        assertTrue(batch.validateSale("wheat", 5, true).isSuccess());
        assertTrue(batch.validateSale("wheat", 1, true).isFailure(), "Batch policy menolak jumlah di bawah batas minimum (5)");
    }
}

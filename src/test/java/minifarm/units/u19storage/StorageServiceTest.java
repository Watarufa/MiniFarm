package minifarm.units.u19storage;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.fixtures.FakeInventoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U19")
@Tag("unit")
class StorageServiceTest {

    private StorageService storageService;
    private FakeInventoryPort inventoryPort;

    @BeforeEach
    void setUp() {
        storageService = new StorageService();
        inventoryPort = new FakeInventoryPort(20);
        inventoryPort.addItem("wheat", 10);
    }

    @Test
    @DisplayName("Transfer ke storage berhasil mengurangi inventaris dan menambah storage")
    void transferToStorage_whenValid_transfersAtomically() {
        OperationResult<Void> result = storageService.transferToStorage("barn_storage", "wheat", 4, inventoryPort);

        assertTrue(result.isSuccess());
        assertEquals(6, inventoryPort.getItemQuantity("wheat"));
        assertEquals(4, storageService.getStorage("barn_storage").getItemQuantity("wheat"));
    }

    @Test
    @DisplayName("Transfer gagal jika item di inventaris tidak mencukupi (Atomisitas)")
    void transferToStorage_whenInsufficientItem_failsAtomically() {
        OperationResult<Void> result = storageService.transferToStorage("barn_storage", "wheat", 20, inventoryPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ITEMS, result.getCode());
        assertEquals(10, inventoryPort.getItemQuantity("wheat"), "Inventaris tidak berubah");
        assertEquals(0, storageService.getStorage("barn_storage").getItemQuantity("wheat"));
    }

    @Test
    @DisplayName("Bukti Polymorphism: Silo menolak item yang bukan pakan/biji/hasil panen")
    void polymorphicStorage_siloFiltersItems() {
        inventoryPort.addItem("hoe", 1);

        OperationResult<Void> result = storageService.transferToStorage("silo_storage", "hoe", 1, inventoryPort);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.NOT_ALLOWED, result.getCode());
        assertEquals(1, inventoryPort.getItemQuantity("hoe"), "Item tidak boleh berkurang saat ditolak");
    }
}


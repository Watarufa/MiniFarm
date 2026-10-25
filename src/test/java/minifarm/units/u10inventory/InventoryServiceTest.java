package minifarm.units.u10inventory;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U10")
@Tag("unit")
class InventoryServiceTest {

    private InventoryService inventory;

    @BeforeEach
    void setUp() {
        inventory = new InventoryService(3, new SlotCapacityPolicy()); // Batas 3 slot untuk kemudahan testing
    }

    @Test
    @DisplayName("Menambahkan item yang sama menambah jumlah tumpukan (stacking)")
    void addItem_whenItemExists_increasesQuantityInSameSlot() {
        inventory.addItem("wheat", 5);
        inventory.addItem("wheat", 3);

        assertEquals(8, inventory.getItemQuantity("wheat"));
        assertEquals(2, inventory.getAvailableSlots(), "Hanya menggunakan 1 slot dari 3");
    }

    @Test
    @DisplayName("Item baru ditolak jika seluruh slot inventaris telah terisi")
    void addItem_whenSlotsFull_rejectsNewItem() {
        inventory.addItem("wheat", 1);
        inventory.addItem("corn", 1);
        inventory.addItem("tomato", 1);
        assertEquals(0, inventory.getAvailableSlots());

        // Coba masukkan item ke-4
        OperationResult<Void> result = inventory.addItem("egg", 1);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.CAPACITY_EXCEEDED, result.getCode());
        assertFalse(inventory.hasItem("egg", 1));
    }

    @Test
    @DisplayName("Pengurangan melebihi stok ditolak secara atomik tanpa mengubah isi inventaris")
    void removeItem_whenInsufficient_failsAtomically() {
        inventory.addItem("wheat", 5);

        OperationResult<Void> result = inventory.removeItem("wheat", 10);

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_ITEMS, result.getCode());
        assertEquals(5, inventory.getItemQuantity("wheat"), "Stok harus tetap 5");
    }

    @Test
    @DisplayName("Bukti Polymorphism: CategoryRestrictedPolicy menolak item yang tidak sesuai prefix")
    void polymorphicPolicy_rejectsUnallowedCategory() {
        InventoryService seedOnlyBag = new InventoryService(5, new CategoryRestrictedPolicy(Set.of("seed_")));

        OperationResult<Void> seedAdd = seedOnlyBag.addItem("seed_wheat", 2);
        assertTrue(seedAdd.isSuccess());

        OperationResult<Void> toolAdd = seedOnlyBag.addItem("hoe", 1);
        assertTrue(toolAdd.isFailure());
        assertEquals(ResultCode.NOT_ALLOWED, toolAdd.getCode());
    }
}


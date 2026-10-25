package minifarm.core.api;

import java.util.List;

/**
 * Port integrasi domain untuk manajemen inventaris item pemain.
 */
public interface InventoryPort {
    boolean hasItem(String itemId, int quantity);
    int getItemQuantity(String itemId);
    OperationResult<Void> addItem(String itemId, int quantity);
    OperationResult<Void> removeItem(String itemId, int quantity);
    int getAvailableSlots();
    int getTotalCapacity();
    List<ItemStack> getItems();
}


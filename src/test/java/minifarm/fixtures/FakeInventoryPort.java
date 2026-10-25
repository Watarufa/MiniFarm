package minifarm.fixtures;

import minifarm.core.api.InventoryPort;
import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;

import java.util.*;

/**
 * In-memory test double untuk InventoryPort.
 * Mempermudah peserta melakukan unit test yang membutuhkan interaksi inventaris
 * tanpa harus bergantung pada implementasi U10 yang sedang dikerjakan peserta lain.
 */
public class FakeInventoryPort implements InventoryPort {
    private final int totalCapacity;
    private final Map<String, Integer> items = new HashMap<>();

    public FakeInventoryPort(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public FakeInventoryPort() {
        this(20);
    }

    @Override
    public boolean hasItem(String itemId, int quantity) {
        if (itemId == null || quantity <= 0) return false;
        return items.getOrDefault(itemId.toLowerCase(), 0) >= quantity;
    }

    @Override
    public int getItemQuantity(String itemId) {
        if (itemId == null) return 0;
        return items.getOrDefault(itemId.toLowerCase(), 0);
    }

    @Override
    public OperationResult<Void> addItem(String itemId, int quantity) {
        if (itemId == null || itemId.trim().isEmpty() || quantity <= 0) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item atau kuantitas tidak valid");
        }
        String id = itemId.toLowerCase();
        if (!items.containsKey(id) && items.size() >= totalCapacity) {
            return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Slot inventaris penuh");
        }
        items.put(id, items.getOrDefault(id, 0) + quantity);
        return OperationResult.ok();
    }

    @Override
    public OperationResult<Void> removeItem(String itemId, int quantity) {
        if (itemId == null || quantity <= 0) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item atau kuantitas tidak valid");
        }
        String id = itemId.toLowerCase();
        int current = items.getOrDefault(id, 0);
        if (current < quantity) {
            return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Jumlah item tidak mencukupi");
        }
        if (current == quantity) {
            items.remove(id);
        } else {
            items.put(id, current - quantity);
        }
        return OperationResult.ok();
    }

    @Override
    public int getAvailableSlots() {
        return Math.max(0, totalCapacity - items.size());
    }

    @Override
    public int getTotalCapacity() {
        return totalCapacity;
    }

    @Override
    public List<ItemStack> getItems() {
        List<ItemStack> list = new ArrayList<>();
        items.forEach((k, v) -> list.add(new ItemStack(k, v)));
        return Collections.unmodifiableList(list);
    }
}


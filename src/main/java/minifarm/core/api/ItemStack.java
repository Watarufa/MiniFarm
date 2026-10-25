package minifarm.core.api;

import java.util.Objects;

/**
 * Objek nilai (value object) immutable yang merepresentasikan tumpukan item.
 */
public final class ItemStack {
    private final String itemId;
    private final int quantity;

    public ItemStack(String itemId, int quantity) {
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("itemId tidak boleh kosong");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity tidak boleh negatif: " + quantity);
        }
        this.itemId = itemId.trim().toLowerCase();
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemStack withQuantity(int newQuantity) {
        return new ItemStack(this.itemId, newQuantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemStack that)) return false;
        return quantity == that.quantity && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, quantity);
    }

    @Override
    public String toString() {
        return itemId + " x" + quantity;
    }
}


package minifarm.core.events;

public final class ItemPurchased implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final String itemId;
    private final int quantity;
    private final long totalPrice;

    public ItemPurchased(int day, String itemId, int quantity, long totalPrice) {
        this.day = day;
        this.itemId = itemId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "ItemPurchased"; }
    public String getItemId() { return itemId; }
    public int getQuantity() { return quantity; }
    public long getTotalPrice() { return totalPrice; }
}


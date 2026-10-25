package minifarm.core.events;

public final class AnimalProductCollected implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final String animalId;
    private final String productId;
    private final int quantity;

    public AnimalProductCollected(int day, String animalId, String productId, int quantity) {
        this.day = day;
        this.animalId = animalId;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "AnimalProductCollected"; }
    public String getAnimalId() { return animalId; }
    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}


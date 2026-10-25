package minifarm.core.events;

public final class ItemCrafted implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final String recipeId;
    private final String outputItemId;
    private final int outputQuantity;

    public ItemCrafted(int day, String recipeId, String outputItemId, int outputQuantity) {
        this.day = day;
        this.recipeId = recipeId;
        this.outputItemId = outputItemId;
        this.outputQuantity = outputQuantity;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "ItemCrafted"; }
    public String getRecipeId() { return recipeId; }
    public String getOutputItemId() { return outputItemId; }
    public int getOutputQuantity() { return outputQuantity; }
}


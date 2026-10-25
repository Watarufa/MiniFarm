package minifarm.core.events;

public final class CropHarvested implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final int plotIndex;
    private final String cropType;
    private final int quantity;

    public CropHarvested(int day, int plotIndex, String cropType, int quantity) {
        this.day = day;
        this.plotIndex = plotIndex;
        this.cropType = cropType;
        this.quantity = quantity;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "CropHarvested"; }
    public int getPlotIndex() { return plotIndex; }
    public String getCropType() { return cropType; }
    public int getQuantity() { return quantity; }
}


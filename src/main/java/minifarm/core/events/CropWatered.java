package minifarm.core.events;

public final class CropWatered implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final int plotIndex;

    public CropWatered(int day, int plotIndex) {
        this.day = day;
        this.plotIndex = plotIndex;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "CropWatered"; }
    public int getPlotIndex() { return plotIndex; }
}


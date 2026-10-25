package minifarm.core.events;

public final class CropDestroyed implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final int plotIndex;
    private final String reason;

    public CropDestroyed(int day, int plotIndex, String reason) {
        this.day = day;
        this.plotIndex = plotIndex;
        this.reason = reason;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "CropDestroyed"; }
    public int getPlotIndex() { return plotIndex; }
    public String getReason() { return reason; }
}


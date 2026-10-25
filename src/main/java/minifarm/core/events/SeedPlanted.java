package minifarm.core.events;

public final class SeedPlanted implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final int plotIndex;
    private final String seedId;

    public SeedPlanted(int day, int plotIndex, String seedId) {
        this.day = day;
        this.plotIndex = plotIndex;
        this.seedId = seedId;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "SeedPlanted"; }
    public int getPlotIndex() { return plotIndex; }
    public String getSeedId() { return seedId; }
}


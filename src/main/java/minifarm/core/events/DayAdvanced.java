package minifarm.core.events;

public final class DayAdvanced implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int newDay;
    private final String weatherType;

    public DayAdvanced(int newDay, String weatherType) {
        this.newDay = newDay;
        this.weatherType = weatherType;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return newDay; }
    @Override public String getEventType() { return "DayAdvanced"; }
    public int getNewDay() { return newDay; }
    public String getWeatherType() { return weatherType; }
}


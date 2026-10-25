package minifarm.core.events;

public final class AnimalFed implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final String animalId;
    private final String feedItemId;

    public AnimalFed(int day, String animalId, String feedItemId) {
        this.day = day;
        this.animalId = animalId;
        this.feedItemId = feedItemId;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "AnimalFed"; }
    public String getAnimalId() { return animalId; }
    public String getFeedItemId() { return feedItemId; }
}


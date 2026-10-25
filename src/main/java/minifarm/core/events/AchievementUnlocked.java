package minifarm.core.events;

public final class AchievementUnlocked implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final String achievementId;
    private final String achievementName;

    public AchievementUnlocked(int day, String achievementId, String achievementName) {
        this.day = day;
        this.achievementId = achievementId;
        this.achievementName = achievementName;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "AchievementUnlocked"; }
    public String getAchievementId() { return achievementId; }
    public String getAchievementName() { return achievementName; }
}


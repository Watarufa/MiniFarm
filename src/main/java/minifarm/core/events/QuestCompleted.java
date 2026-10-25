package minifarm.core.events;

public final class QuestCompleted implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final String questId;
    private final String questName;

    public QuestCompleted(int day, String questId, String questName) {
        this.day = day;
        this.questId = questId;
        this.questName = questName;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "QuestCompleted"; }
    public String getQuestId() { return questId; }
    public String getQuestName() { return questName; }
}


package minifarm.core.events;

public final class FarmUpgradePurchased implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final String upgradeId;
    private final long cost;

    public FarmUpgradePurchased(int day, String upgradeId, long cost) {
        this.day = day;
        this.upgradeId = upgradeId;
        this.cost = cost;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "FarmUpgradePurchased"; }
    public String getUpgradeId() { return upgradeId; }
    public long getCost() { return cost; }
}


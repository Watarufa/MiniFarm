package minifarm.core.events;

public final class OrderCompleted implements DomainEvent {
    private final long timestamp = System.currentTimeMillis();
    private final int day;
    private final String orderId;
    private final long rewardCoins;

    public OrderCompleted(int day, String orderId, long rewardCoins) {
        this.day = day;
        this.orderId = orderId;
        this.rewardCoins = rewardCoins;
    }

    @Override public long getTimestamp() { return timestamp; }
    @Override public int getDay() { return day; }
    @Override public String getEventType() { return "OrderCompleted"; }
    public String getOrderId() { return orderId; }
    public long getRewardCoins() { return rewardCoins; }
}


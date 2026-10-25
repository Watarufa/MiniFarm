package minifarm.core.events;

/**
 * Interface dasar untuk semua domain event immutable di MiniFarm.
 */
public interface DomainEvent {
    long getTimestamp();
    int getDay();
    String getEventType();
}


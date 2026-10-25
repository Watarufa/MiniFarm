package minifarm.core.events;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * Event bus in-memory sinkron untuk MiniFarm.
 * Memungkinkan komunikasi decoupled antar-unit melalui domain event.
 */
public class EventBus {
    private final Map<Class<? extends DomainEvent>, List<Consumer<? extends DomainEvent>>> subscribers = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T extends DomainEvent> void subscribe(Class<T> eventType, Consumer<T> listener) {
        Objects.requireNonNull(eventType, "eventType tidak boleh null");
        Objects.requireNonNull(listener, "listener tidak boleh null");
        subscribers.computeIfAbsent(eventType, k -> new CopyOnWriteArrayList<>())
                .add((Consumer<? extends DomainEvent>) listener);
    }

    @SuppressWarnings("unchecked")
    public void publish(DomainEvent event) {
        Objects.requireNonNull(event, "event tidak boleh null");
        
        // Panggil subscriber untuk tipe event spesifik
        List<Consumer<? extends DomainEvent>> specificListeners = subscribers.get(event.getClass());
        if (specificListeners != null) {
            for (Consumer<? extends DomainEvent> listener : specificListeners) {
                ((Consumer<DomainEvent>) listener).accept(event);
            }
        }

        // Panggil juga jika ada yang subscribe ke DomainEvent.class umum
        List<Consumer<? extends DomainEvent>> generalListeners = subscribers.get(DomainEvent.class);
        if (generalListeners != null) {
            for (Consumer<? extends DomainEvent> listener : generalListeners) {
                ((Consumer<DomainEvent>) listener).accept(event);
            }
        }
    }

    public void clear() {
        subscribers.clear();
    }
}


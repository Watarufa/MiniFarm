package minifarm.core.api;

/**
 * Kontrak untuk modul atau unit yang berpartisipasi dalam pemrosesan pergantian hari.
 */
public interface DailyTickParticipant {
    String getParticipantName();
    int getExecutionOrder();
    void onDayAdvance(DayContext context);
}


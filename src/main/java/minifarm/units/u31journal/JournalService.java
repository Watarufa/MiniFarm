package minifarm.units.u31journal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import minifarm.core.events.DayAdvanced;
import minifarm.core.events.DomainEvent;
import minifarm.core.events.EventBus;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): JournalService
 * ================================================================================================
 * Modul Unit: U31JOURNAL
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U31: Notifikasi dan Jurnal Aktivitas.
 * Mencatat peristiwa penting game secara deterministik tanpa mencetak langsung ke System.out.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class JournalService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public static final int MAX_ENTRIES = 50;
 * 2. private final List<AbstractFarmNotification> entries = new LinkedList<>();
 * 3. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public JournalService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 *      if (eventBus != null) {
 *          eventBus.subscribe(DomainEvent.class, this::onEvent);
 *      }
 * 
 * 2. Constructor: public JournalService()
 *    Logika Implementasi:
 *      this(null);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public synchronized void record(AbstractFarmNotification notification)
 *    Logika Implementasi:
 *      // TODO U31: Catat notifikasi. Jaga batas kapasitas maksimal 50 record (FIFO).
 *      if (notification == null) return;
 *      if (entries.size() >= MAX_ENTRIES) {
 *          entries.remove(0); // Hapus entri tertua jika melebihi 50
 *      }
 *      entries.add(notification);
 * 
 * 2. public void onEvent(DomainEvent event)
 *    Logika Implementasi:
 *      if (event instanceof DayAdvanced dayAdv) {
 *          record(new InfoNotification(dayAdv.getDay(), "Memasuki Hari " + dayAdv.getNewDay() + " dengan cuaca " + dayAdv.getWeatherType()));
 *      } else {
 *          record(new InfoNotification(event.getDay(), "Peristiwa: " + event.getEventType()));
 *      }
 * 
 * 3. public synchronized List<AbstractFarmNotification> getRecentEntries(int limit)
 *    Logika Implementasi:
 *      int count = Math.min(entries.size(), limit > 0 ? limit : entries.size());
 *      List<AbstractFarmNotification> sub = entries.subList(entries.size() - count, entries.size());
 *      return Collections.unmodifiableList(new ArrayList<>(sub));
 * 
 * 4. public synchronized List<AbstractFarmNotification> getAllEntries()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(new ArrayList<>(entries));
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */
public class JournalService {

    public static final int MAX_ENTRIES = 50;

    private final List<AbstractFarmNotification> entries = new LinkedList<>();
    private final EventBus eventBus;

    public JournalService(EventBus eventBus) {
        this.eventBus = eventBus;

        if (eventBus != null) {
            eventBus.subscribe(DomainEvent.class, this::onEvent);
        }
    }

    public JournalService() {
        this(null);
    }

    public synchronized void record(AbstractFarmNotification notification) {
        if (notification == null) return;

        if (entries.size() >= MAX_ENTRIES) {
            entries.remove(0);
        }

        entries.add(notification);
    }

    public void onEvent(DomainEvent event) {
        if (event instanceof DayAdvanced dayAdv) {
            record(new InfoNotification(
                dayAdv.getDay(),
                "Memasuki Hari " + dayAdv.getNewDay()
                + " dengan cuaca " + dayAdv.getWeatherType()
            ));
        } else {
            record(new InfoNotification(
                event.getDay(),
                "Peristiwa: " + event.getEventType()
            ));
        }
    }

    public synchronized List<AbstractFarmNotification> getRecentEntries(int limit) {
        int count = Math.min(
            entries.size(),
            limit > 0 ? limit : entries.size()
        );

        List<AbstractFarmNotification> sub = entries.subList(
            entries.size() - count,
            entries.size()
        );

        return Collections.unmodifiableList(new ArrayList<>(sub));
    }

    public synchronized List<AbstractFarmNotification> getAllEntries() {
        return Collections.unmodifiableList(new ArrayList<>(entries));
    }
}
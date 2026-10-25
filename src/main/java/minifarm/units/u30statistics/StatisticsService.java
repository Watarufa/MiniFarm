package minifarm.units.u30statistics;

import minifarm.core.events.DomainEvent;
import minifarm.core.events.EventBus;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): StatisticsService
 * ================================================================================================
 * Modul Unit: U30STATISTICS
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U30: Statistik Pertanian.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class StatisticsService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final List<AbstractFarmStatistic> statistics = new ArrayList<>();
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public StatisticsService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 *      statistics.add(new ProductionStatistic());
 *      statistics.add(new FinanceStatistic());
 *      statistics.add(new AnimalStatistic());
 *      
 *      if (eventBus != null) {
 *          eventBus.subscribe(DomainEvent.class, this::onEvent);
 *      }
 * 
 * 2. Constructor: public StatisticsService()
 *    Logika Implementasi:
 *      this(null);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void onEvent(DomainEvent event)
 *    Logika Implementasi:
 *      // TODO U30: Teruskan event secara polimorfik ke setiap metrik statistik
 *      for (AbstractFarmStatistic stat : statistics) {
 *          stat.onEvent(event);
 *      }
 * 
 * 2. public List<AbstractFarmStatistic> getAllStatistics()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(statistics);
 * 
 * 3. public List<String> getSummaryLines()
 *    Logika Implementasi:
 *      List<String> lines = new ArrayList<>();
 *      for (AbstractFarmStatistic stat : statistics) {
 *          lines.add(stat.getMetricName() + " -> " + stat.getFormattedSummary());
 *      }
 *      return Collections.unmodifiableList(lines);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u30statistics;

import minifarm.core.events.AnimalFed;
import minifarm.core.events.DomainEvent;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AnimalStatistic
 * ================================================================================================
 * Modul Unit: U30STATISTICS
 * 
 * Deskripsi Kelas:
 * Statistik perawatan dan pakan hewan.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AnimalStatistic
 * - Superclass (Pewarisan) : extends AbstractFarmStatistic
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private int totalFeedings = 0;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AnimalStatistic()
 *    Logika Implementasi:
 *      super("Statistik Hewan");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public int getTotalFeedings()
 *    Logika Implementasi:
 *      return totalFeedings;
 * 
 * 2. @Override public void onEvent(DomainEvent event)
 *    Logika Implementasi:
 *      if (event instanceof AnimalFed) {
 *          totalFeedings++;
 *      }
 * 
 * 3. @Override public String getFormattedSummary()
 *    Logika Implementasi:
 *      return "Total Pakan Diberikan: " + totalFeedings + " kali";
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

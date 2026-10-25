package minifarm.units.u26achievement;

import minifarm.core.events.AnimalProductCollected;
import minifarm.core.events.DomainEvent;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AnimalProductCondition
 * ================================================================================================
 * Modul Unit: U26ACHIEVEMENT
 * 
 * Deskripsi Kelas:
 * Syarat achievement: pengumpulan produk peternakan.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AnimalProductCondition
 * - Superclass (Pewarisan) : extends AbstractAchievementCondition
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AnimalProductCondition()
 *    Logika Implementasi:
 *      super("Mengumpulkan produk hewani");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean isMetBy(DomainEvent event)
 *    Logika Implementasi:
 *      return event instanceof AnimalProductCollected;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

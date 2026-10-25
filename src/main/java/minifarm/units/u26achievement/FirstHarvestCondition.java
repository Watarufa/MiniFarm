package minifarm.units.u26achievement;

import minifarm.core.events.CropHarvested;
import minifarm.core.events.DomainEvent;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): FirstHarvestCondition
 * ================================================================================================
 * Modul Unit: U26ACHIEVEMENT
 * 
 * Deskripsi Kelas:
 * Syarat achievement: panen pertama kali.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class FirstHarvestCondition
 * - Superclass (Pewarisan) : extends AbstractAchievementCondition
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public FirstHarvestCondition()
 *    Logika Implementasi:
 *      super("Panen tanaman pertama kali");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean isMetBy(DomainEvent event)
 *    Logika Implementasi:
 *      return event instanceof CropHarvested;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u27skill;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AnimalSkill
 * ================================================================================================
 * Modul Unit: U27SKILL
 * 
 * Deskripsi Kelas:
 * Keahlian Beternak (Animal Skill).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AnimalSkill
 * - Superclass (Pewarisan) : extends AbstractFarmSkill
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AnimalSkill()
 *    Logika Implementasi:
 *      super("animal", "Animal Husbandry");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getThresholdForNextLevel(int currentLevel)
 *    Logika Implementasi:
 *      if (currentLevel == 1) return 20;
 *      if (currentLevel == 2) return 50;
 *      return 90 + (currentLevel - 3) * 45;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

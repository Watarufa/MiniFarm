package minifarm.units.u27skill;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CropSkill
 * ================================================================================================
 * Modul Unit: U27SKILL
 * 
 * Deskripsi Kelas:
 * Keahlian Bercocok Tanam (Crop Skill).
 * Ambang batas: Lv 2 pada 25 XP, Lv 3 pada 60 XP.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CropSkill
 * - Superclass (Pewarisan) : extends AbstractFarmSkill
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public CropSkill()
 *    Logika Implementasi:
 *      super("crop", "Farming & Crops");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getThresholdForNextLevel(int currentLevel)
 *    Logika Implementasi:
 *      if (currentLevel == 1) return 25;
 *      if (currentLevel == 2) return 60;
 *      return 100 + (currentLevel - 3) * 50;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

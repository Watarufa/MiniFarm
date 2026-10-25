package minifarm.units.u27skill;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): TradingSkill
 * ================================================================================================
 * Modul Unit: U27SKILL
 * 
 * Deskripsi Kelas:
 * Keahlian Berdagang (Trading Skill).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class TradingSkill
 * - Superclass (Pewarisan) : extends AbstractFarmSkill
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public TradingSkill()
 *    Logika Implementasi:
 *      super("trade", "Commerce & Trading");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getThresholdForNextLevel(int currentLevel)
 *    Logika Implementasi:
 *      if (currentLevel == 1) return 30;
 *      if (currentLevel == 2) return 70;
 *      return 120 + (currentLevel - 3) * 60;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

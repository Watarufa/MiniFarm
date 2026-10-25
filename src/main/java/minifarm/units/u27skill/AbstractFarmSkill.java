package minifarm.units.u27skill;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractFarmSkill
 * ================================================================================================
 * Modul Unit: U27SKILL
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar keahlian bertani (Skill & XP).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractFarmSkill
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String category;
 * 2. private final String displayName;
 * 3. private int level;
 * 4. private int currentXp;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractFarmSkill(String category, String displayName)
 *    Logika Implementasi:
 *      this.category = category.toLowerCase();
 *      this.displayName = displayName;
 *      this.level = 1;
 *      this.currentXp = 0;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getCategory()
 *    Logika Implementasi:
 *      return category;
 * 
 * 2. public String getDisplayName()
 *    Logika Implementasi:
 *      return displayName;
 * 
 * 3. public int getLevel()
 *    Logika Implementasi:
 *      return level;
 * 
 * 4. public int getCurrentXp()
 *    Logika Implementasi:
 *      return currentXp;
 * 
 * 5. public boolean addXp(int amount)
 *    Logika Implementasi:
 *      if (amount <= 0) return false;
 *      this.currentXp += amount;
 *      boolean leveledUp = false;
 *      while (currentXp >= getThresholdForNextLevel(level)) {
 *          level++;
 *          leveledUp = true;
 *      }
 *      return leveledUp;
 * 
 * 6. public abstract int getThresholdForNextLevel(int currentLevel)
 *    Keterangan / Tujuan: Ambang batas XP untuk naik ke level berikutnya (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 7. @Override public String toString()
 *    Logika Implementasi:
 *      return displayName + " (Lv. " + level + ", " + currentXp + "/" + getThresholdForNextLevel(level) + " XP)";
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

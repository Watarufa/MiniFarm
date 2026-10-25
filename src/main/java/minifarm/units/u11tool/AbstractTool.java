package minifarm.units.u11tool;

import minifarm.core.api.MaintainableTool;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractTool
 * ================================================================================================
 * Modul Unit: U11TOOL
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar model peralatan (Tool).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractTool implements MaintainableTool
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String toolId;
 * 2. private final String toolName;
 * 3. private int durability;
 * 4. private final int maxDurability;
 * 5. private int level;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractTool(String toolId, String toolName, int initialDurability, int maxDurability, int level)
 *    Logika Implementasi:
 *      if (initialDurability < 0 || maxDurability <= 0) {
 *          throw new IllegalArgumentException("Durability tidak valid");
 *      }
 *      this.toolId = toolId;
 *      this.toolName = toolName;
 *      this.durability = initialDurability;
 *      this.maxDurability = maxDurability;
 *      this.level = Math.max(1, level);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getToolId()
 *    Logika Implementasi:
 *      return toolId;
 * 
 * 2. public String getToolName()
 *    Logika Implementasi:
 *      return toolName;
 * 
 * 3. public int getDurability()
 *    Logika Implementasi:
 *      return durability;
 * 
 * 4. public int getMaxDurability()
 *    Logika Implementasi:
 *      return maxDurability;
 * 
 * 5. public int getLevel()
 *    Logika Implementasi:
 *      return level;
 * 
 * 6. public void setLevel(int level)
 *    Logika Implementasi:
 *      this.level = level;
 * 
 * 7. public boolean isUsable()
 *    Logika Implementasi:
 *      return durability > 0;
 * 
 * 8. public boolean use()
 *    Logika Implementasi:
 *      if (!isUsable()) return false;
 *      durability--;
 *      return true;
 * 
 * 9. public void repair()
 *    Logika Implementasi:
 *      this.durability = maxDurability;
 * 
 * 10. public abstract double getEffectMultiplier()
 *    Keterangan / Tujuan: Efisiensi atau bonus efek alat (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

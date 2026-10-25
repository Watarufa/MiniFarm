package minifarm.units.u14energy;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ToolAdjustedCostPolicy
 * ================================================================================================
 * Modul Unit: U14ENERGY
 * 
 * Deskripsi Kelas:
 * Kebijakan biaya disesuaikan efisiensi alat: jika alat level 2+ hemat 1 energi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ToolAdjustedCostPolicy
 * - Superclass (Pewarisan) : extends AbstractEnergyCostPolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final int toolLevel;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ToolAdjustedCostPolicy(int toolLevel)
 *    Logika Implementasi:
 *      super("ToolAdjustedCostPolicy");
 *      this.toolLevel = toolLevel;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int calculateCost(int baseCost, String actionType)
 *    Logika Implementasi:
 *      int discount = toolLevel >= 2 ? 1 : 0;
 *      return Math.max(1, baseCost - discount);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

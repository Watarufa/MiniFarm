package minifarm.units.u14energy;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ProfessionAdjustedCostPolicy
 * ================================================================================================
 * Modul Unit: U14ENERGY
 * 
 * Deskripsi Kelas:
 * Kebijakan biaya disesuaikan modifier spesialisasi petani.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ProfessionAdjustedCostPolicy
 * - Superclass (Pewarisan) : extends AbstractEnergyCostPolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final double modifier;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ProfessionAdjustedCostPolicy(double modifier)
 *    Logika Implementasi:
 *      super("ProfessionAdjustedCostPolicy");
 *      this.modifier = modifier > 0 ? modifier : 1.0;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int calculateCost(int baseCost, String actionType)
 *    Logika Implementasi:
 *      return (int) Math.round(baseCost * modifier);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

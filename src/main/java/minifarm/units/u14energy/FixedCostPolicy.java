package minifarm.units.u14energy;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): FixedCostPolicy
 * ================================================================================================
 * Modul Unit: U14ENERGY
 * 
 * Deskripsi Kelas:
 * Kebijakan biaya tetap (Fixed Cost): biaya aksi sama persis dengan baseCost.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class FixedCostPolicy
 * - Superclass (Pewarisan) : extends AbstractEnergyCostPolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public FixedCostPolicy()
 *    Logika Implementasi:
 *      super("FixedCostPolicy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int calculateCost(int baseCost, String actionType)
 *    Logika Implementasi:
 *      return Math.max(0, baseCost);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

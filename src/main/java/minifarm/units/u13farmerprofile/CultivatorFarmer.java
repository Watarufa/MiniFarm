package minifarm.units.u13farmerprofile;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CultivatorFarmer
 * ================================================================================================
 * Modul Unit: U13FARMERPROFILE
 * 
 * Deskripsi Kelas:
 * Petani Spesialis Tanaman (Cultivator): hemat energi saat tanam/siram/panen (0.8x).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CultivatorFarmer
 * - Superclass (Pewarisan) : extends AbstractFarmerProfile
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public CultivatorFarmer(String name)
 *    Logika Implementasi:
 *      super(name, "Cultivator");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public double getEnergyCostModifier(String actionType)
 *    Logika Implementasi:
 *      if ("plant".equalsIgnoreCase(actionType) || "water".equalsIgnoreCase(actionType) || "harvest".equalsIgnoreCase(actionType)) {
 *          return 0.8;
 *      }
 *      return 1.0;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u13farmerprofile;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): RancherFarmer
 * ================================================================================================
 * Modul Unit: U13FARMERPROFILE
 * 
 * Deskripsi Kelas:
 * Petani Spesialis Peternakan (Rancher): hemat energi saat merawat hewan (0.7x).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class RancherFarmer
 * - Superclass (Pewarisan) : extends AbstractFarmerProfile
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public RancherFarmer(String name)
 *    Logika Implementasi:
 *      super(name, "Rancher");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public double getEnergyCostModifier(String actionType)
 *    Logika Implementasi:
 *      if ("animal_care".equalsIgnoreCase(actionType) || "feed".equalsIgnoreCase(actionType)) {
 *          return 0.7;
 *      }
 *      return 1.0;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

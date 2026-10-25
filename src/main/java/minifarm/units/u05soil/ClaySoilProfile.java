package minifarm.units.u05soil;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ClaySoilProfile
 * ================================================================================================
 * Modul Unit: U05SOIL
 * 
 * Deskripsi Kelas:
 * Tanah liat padat (Clay Soil): retensi tinggi, decay rendah (3), efek pupuk 18.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ClaySoilProfile
 * - Superclass (Pewarisan) : extends AbstractSoilProfile
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ClaySoilProfile(int initialFertility)
 *    Logika Implementasi:
 *      super("Clay Soil", initialFertility);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getDecayRate()
 *    Logika Implementasi:
 *      return 3;
 * 
 * 2. @Override public int getFertilizerEffect()
 *    Logika Implementasi:
 *      return 18;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

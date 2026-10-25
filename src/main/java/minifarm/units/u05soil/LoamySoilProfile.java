package minifarm.units.u05soil;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): LoamySoilProfile
 * ================================================================================================
 * Modul Unit: U05SOIL
 * 
 * Deskripsi Kelas:
 * Tanah lempung subur (Loamy Soil - Default): decay sedang (5), efek pupuk 20.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class LoamySoilProfile
 * - Superclass (Pewarisan) : extends AbstractSoilProfile
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public LoamySoilProfile(int initialFertility)
 *    Logika Implementasi:
 *      super("Loamy Soil", initialFertility);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getDecayRate()
 *    Logika Implementasi:
 *      return 5;
 * 
 * 2. @Override public int getFertilizerEffect()
 *    Logika Implementasi:
 *      return 20;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

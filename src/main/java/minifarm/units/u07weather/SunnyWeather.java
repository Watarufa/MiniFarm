package minifarm.units.u07weather;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SunnyWeather
 * ================================================================================================
 * Modul Unit: U07WEATHER
 * 
 * Deskripsi Kelas:
 * Cuaca Cerah (SUNNY): tidak ada hujan, modifier normal 1.0.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SunnyWeather
 * - Superclass (Pewarisan) : extends AbstractWeatherState
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SunnyWeather()
 *    Logika Implementasi:
 *      super("SUNNY");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean providesRain()
 *    Logika Implementasi:
 *      return false;
 * 
 * 2. @Override public double getGrowthModifier()
 *    Logika Implementasi:
 *      return 1.0;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

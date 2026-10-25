package minifarm.units.u07weather;

import minifarm.core.api.WeatherSnapshot;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractWeatherState
 * ================================================================================================
 * Modul Unit: U07WEATHER
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar yang merepresentasikan kondisi cuaca harian.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractWeatherState
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String weatherName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractWeatherState(String weatherName)
 *    Logika Implementasi:
 *      this.weatherName = weatherName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getWeatherName()
 *    Logika Implementasi:
 *      return weatherName;
 * 
 * 2. public abstract boolean providesRain()
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 3. public abstract double getGrowthModifier()
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 4. public WeatherSnapshot toSnapshot()
 *    Logika Implementasi:
 *      return new WeatherSnapshot(weatherName, providesRain(), getGrowthModifier());
 * 
 * 5. @Override public String toString()
 *    Logika Implementasi:
 *      return weatherName;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

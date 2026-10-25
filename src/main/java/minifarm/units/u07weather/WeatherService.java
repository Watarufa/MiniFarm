package minifarm.units.u07weather;

import minifarm.core.api.WeatherSnapshot;
import java.util.List;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): WeatherService
 * ================================================================================================
 * Modul Unit: U07WEATHER
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U07: Cuaca Deterministik.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class WeatherService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final List<AbstractWeatherState> cycle;
 * 2. private int currentIndex;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public WeatherService(List<AbstractWeatherState> customCycle)
 *    Logika Implementasi:
 *      if (customCycle == null || customCycle.isEmpty()) {
 *          this.cycle = List.of(new SunnyWeather(), new CloudyWeather(), new RainyWeather());
 *      } else {
 *          this.cycle = List.copyOf(customCycle);
 *      }
 *      this.currentIndex = 0;
 * 
 * 2. Constructor: public WeatherService()
 *    Logika Implementasi:
 *      this(List.of(new SunnyWeather(), new CloudyWeather(), new RainyWeather()));
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public WeatherSnapshot getCurrentWeather()
 *    Logika Implementasi:
 *      return cycle.get(currentIndex).toSnapshot();
 * 
 * 2. public WeatherSnapshot advanceToNextWeather()
 *    Keterangan / Tujuan: Memajukan siklus cuaca ke hari berikutnya secara deterministik.
 *    Logika Implementasi:
 *      // TODO U07: Geser currentIndex ke indeks berikutnya secara berulang (modulo cycle.size())
 *      currentIndex = (currentIndex + 1) % cycle.size();
 *      return getCurrentWeather();
 * 
 * 3. public void reset()
 *    Logika Implementasi:
 *      this.currentIndex = 0;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

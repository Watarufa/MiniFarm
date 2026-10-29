package minifarm.units.u01plot;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): OutdoorCropPlot
 * ================================================================================================
 * Modul Unit: U01PLOT
 * 
 * Deskripsi Kelas:
 * Petak lahan luar ruang (Outdoor).
 * Petak ini langsung terkena hujan alami saat cuaca RAINY.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class OutdoorCropPlot
 * - Superclass (Pewarisan) : extends AbstractFarmPlot
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public OutdoorCropPlot(int index)
 *    Logika Implementasi:
 *      super(index);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean receivesRain()
 *    Logika Implementasi:
 *      return true;
 * 
 * 2. @Override public void applyWeather(boolean isRaining)
 *    Logika Implementasi:
 *      // TODO U01: Jika isRaining bernilai true, ubah status kelembapan petak (setMoist) menjadi true
 *      if (isRaining) {
 *          setMoist(true);
 *      }
 * 
 * 3. @Override public String toString()
 *    Logika Implementasi:
 *      return "OutdoorPlot #" + getIndex() + (isOccupied() ? " [Terisi]" : " [Kosong]") + (isMoist() ? " [Lembap]" : "");
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

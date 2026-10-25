package minifarm.units.u01plot;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ProtectedCropPlot
 * ================================================================================================
 * Modul Unit: U01PLOT
 * 
 * Deskripsi Kelas:
 * Petak lahan berpelindung / rumah kaca (Protected Plot).
 * Petak ini terlindung dari cuaca luar dan TIDAK menerima hujan otomatis.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ProtectedCropPlot
 * - Superclass (Pewarisan) : extends AbstractFarmPlot
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ProtectedCropPlot(int index)
 *    Logika Implementasi:
 *      super(index);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean receivesRain()
 *    Logika Implementasi:
 *      return false;
 * 
 * 2. @Override public void applyWeather(boolean isRaining)
 *    Logika Implementasi:
 *      // Protected plot terlindung dari air hujan, tidak otomatis lembap saat hujan
 * 
 * 3. @Override public String toString()
 *    Logika Implementasi:
 *      return "ProtectedPlot #" + getIndex() + (isOccupied() ? " [Terisi]" : " [Kosong]") + (isMoist() ? " [Lembap]" : "");
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

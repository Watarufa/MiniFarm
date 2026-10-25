package minifarm.units.u01plot;

import minifarm.core.api.CropSnapshot;
import java.util.Optional;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractFarmPlot
 * ================================================================================================
 * Modul Unit: U01PLOT
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar yang merepresentasikan satu petak lahan pertanian (Farm Plot).
 * Mendemonstrasikan Enkapsulasi dan Abstraksi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractFarmPlot
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final int index;
 * 2. private Object crop;
 * 3. private boolean moist;
 *    Keterangan: Objek tanaman yang menempati petak (null jika kosong)
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractFarmPlot(int index)
 *    Keterangan: Status kelembapan harian
 *    Logika Implementasi:
 *      if (index < 0) {
 *          throw new IllegalArgumentException("Index petak tidak boleh negatif");
 *      }
 *      this.index = index;
 *      this.crop = null;
 *      this.moist = false;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public int getIndex()
 *    Logika Implementasi:
 *      return index;
 * 
 * 2. public boolean isOccupied()
 *    Logika Implementasi:
 *      return crop != null;
 * 
 * 3. public boolean isMoist()
 *    Logika Implementasi:
 *      return moist;
 * 
 * 4. public void setMoist(boolean moist)
 *    Logika Implementasi:
 *      this.moist = moist;
 * 
 * 5. public Object getCrop()
 *    Logika Implementasi:
 *      return crop;
 * 
 * 6. public void placeCrop(Object crop)
 *    Logika Implementasi:
 *      if (isOccupied()) {
 *          throw new IllegalStateException("Petak sudah terisi tanaman");
 *      }
 *      if (crop == null) {
 *          throw new IllegalArgumentException("Tanaman tidak boleh null");
 *      }
 *      this.crop = crop;
 * 
 * 7. public Object removeCrop()
 *    Logika Implementasi:
 *      if (!isOccupied()) {
 *          throw new IllegalStateException("Petak sedang kosong");
 *      }
 *      Object removed = this.crop;
 *      this.crop = null;
 *      return removed;
 * 
 * 8. public void clear()
 *    Logika Implementasi:
 *      this.crop = null;
 * 
 * 9. public abstract boolean receivesRain()
 *    Keterangan / Tujuan: Perilaku polimorfik: menentukan apakah petak ini terpengaruh oleh air hujan alami.
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 10. public abstract void applyWeather(boolean isRaining)
 *    Keterangan / Tujuan: Menerapkan efek cuaca pada petak.
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 11. public Optional<CropSnapshot> getCropSnapshot()
 *    Keterangan / Tujuan: Mengambil snapshot tanaman (jika ada).
 *    Logika Implementasi:
 *      if (crop == null) return Optional.empty();
 *      if (crop instanceof minifarm.core.api.CropSnapshotProvider csp) {
 *          return Optional.of(csp.toSnapshot());
 *      }
 *      return Optional.of(new CropSnapshot("crop_" + index, crop.toString(), 0, 2, 100, false));
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

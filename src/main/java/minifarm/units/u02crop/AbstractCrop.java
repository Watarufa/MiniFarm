package minifarm.units.u02crop;

import minifarm.core.api.CropSnapshot;
import minifarm.core.api.CropSnapshotProvider;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractCrop
 * ================================================================================================
 * Modul Unit: U02CROP
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar untuk semua jenis tanaman di MiniFarm.
 * Mendemonstrasikan Enkapsulasi, Abstraksi, dan Polimorfisme.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractCrop implements CropSnapshotProvider
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String cropId;
 * 2. private final String cropType;
 * 3. private int growthDay;
 * 4. private int health;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractCrop(String cropId, String cropType)
 *    Keterangan: Rentang 0 - 100
 *    Logika Implementasi:
 *      if (cropId == null || cropId.trim().isEmpty()) {
 *          throw new IllegalArgumentException("cropId tidak boleh kosong");
 *      }
 *      if (cropType == null || cropType.trim().isEmpty()) {
 *          throw new IllegalArgumentException("cropType tidak boleh kosong");
 *      }
 *      this.cropId = cropId.trim();
 *      this.cropType = cropType.trim().toLowerCase();
 *      this.growthDay = 0;
 *      this.health = 100;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getCropId()
 *    Logika Implementasi:
 *      return cropId;
 * 
 * 2. public String getCropType()
 *    Logika Implementasi:
 *      return cropType;
 * 
 * 3. public int getGrowthDay()
 *    Logika Implementasi:
 *      return growthDay;
 * 
 * 4. public int getHealth()
 *    Logika Implementasi:
 *      return health;
 * 
 * 5. public boolean isMature()
 *    Logika Implementasi:
 *      return growthDay >= daysToMature();
 * 
 * 6. public boolean isDead()
 *    Logika Implementasi:
 *      return health <= 0;
 * 
 * 7. public void grow()
 *    Keterangan / Tujuan: Menambah satu hari pertumbuhan jika tanaman masih hidup dan belum matang.
 *    Logika Implementasi:
 *      // TODO U02: Jika tanaman masih hidup (!isDead()) dan belum matang (!isMature()), tambahkan growthDay sebesar 1
 *      if (!isDead() && !isMature()) {
 *          this.growthDay++;
 *      }
 * 
 * 8. public void damage(int amount)
 *    Logika Implementasi:
 *      if (amount > 0) {
 *          this.health = Math.max(0, this.health - amount);
 *      }
 * 
 * 9. public void heal(int amount)
 *    Logika Implementasi:
 *      if (amount > 0 && !isDead()) {
 *          this.health = Math.min(100, this.health + amount);
 *      }
 * 
 * 10. public CropSnapshot toSnapshot()
 *    Logika Implementasi:
 *      return new CropSnapshot(cropId, cropType, growthDay, daysToMature(), health, isMature());
 * 
 * 11. public abstract int daysToMature()
 *    Keterangan / Tujuan: Jumlah hari tumbuh yang dibutuhkan hingga tanaman siap panen (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 12. public abstract int baseYield()
 *    Keterangan / Tujuan: Jumlah panen dasar yang dihasilkan saat matang (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 13. @Override public String toString()
 *    Logika Implementasi:
 *      return cropType + " (Hari " + growthDay + "/" + daysToMature() + ", HP: " + health + ")";
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

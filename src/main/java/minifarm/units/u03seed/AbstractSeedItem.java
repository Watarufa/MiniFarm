package minifarm.units.u03seed;

import java.util.Objects;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractSeedItem
 * ================================================================================================
 * Modul Unit: U03SEED
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar untuk semua jenis benih tanaman.
 * Mendemonstrasikan enkapsulasi (field privat dengan validasi) dan abstraksi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractSeedItem
 * - Interface yang Diimplementasikan: implements PlantableSeed
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String seedId;
 * 2. private final String displayName;
 * 3. private final long price;
 * 4. private final String cropType;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractSeedItem(String seedId, String displayName, long price, String cropType)
 *    Logika Implementasi:
 *      if (seedId == null || seedId.trim().isEmpty()) {
 *          throw new IllegalArgumentException("seedId tidak boleh null atau kosong");
 *      }
 *      if (displayName == null || displayName.trim().isEmpty()) {
 *          throw new IllegalArgumentException("displayName tidak boleh null atau kosong");
 *      }
 *      if (price < 0) {
 *          throw new IllegalArgumentException("Harga tidak boleh negatif: " + price);
 *      }
 *      if (cropType == null || cropType.trim().isEmpty()) {
 *          throw new IllegalArgumentException("cropType tidak boleh null atau kosong");
 *      }
 *      
 *      this.seedId = seedId.trim().toLowerCase();
 *      this.displayName = displayName.trim();
 *      this.price = price;
 *      this.cropType = cropType.trim().toLowerCase();
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public String getSeedId()
 *    Logika Implementasi:
 *      return seedId;
 * 
 * 2. @Override public String getDisplayName()
 *    Logika Implementasi:
 *      return displayName;
 * 
 * 3. @Override public long getPrice()
 *    Logika Implementasi:
 *      return price;
 * 
 * 4. @Override public String getCropType()
 *    Logika Implementasi:
 *      return cropType;
 * 
 * 5. @Override public String toString()
 *    Logika Implementasi:
 *      return displayName + " (" + seedId + ", " + price + " G)";
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u09item;

import java.util.Objects;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractFarmItem
 * ================================================================================================
 * Modul Unit: U09ITEM
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar untuk item pertanian dengan enkapsulasi field yang ketat.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractFarmItem
 * - Interface yang Diimplementasikan: implements FarmItem
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String itemId;
 * 2. private final String displayName;
 * 3. private final String category;
 * 4. private final long basePrice;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractFarmItem(String itemId, String displayName, String category, long basePrice)
 *    Logika Implementasi:
 *      if (itemId == null || itemId.trim().isEmpty()) {
 *          throw new IllegalArgumentException("itemId tidak boleh kosong");
 *      }
 *      if (displayName == null || displayName.trim().isEmpty()) {
 *          throw new IllegalArgumentException("displayName tidak boleh kosong");
 *      }
 *      if (category == null || category.trim().isEmpty()) {
 *          throw new IllegalArgumentException("category tidak boleh kosong");
 *      }
 *      if (basePrice < 0) {
 *          throw new IllegalArgumentException("basePrice tidak boleh negatif: " + basePrice);
 *      }
 *      
 *      this.itemId = itemId.trim().toLowerCase();
 *      this.displayName = displayName.trim();
 *      this.category = category.trim();
 *      this.basePrice = basePrice;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public String getItemId()
 *    Logika Implementasi:
 *      return itemId;
 * 
 * 2. @Override public String getDisplayName()
 *    Logika Implementasi:
 *      return displayName;
 * 
 * 3. @Override public String getCategory()
 *    Logika Implementasi:
 *      return category;
 * 
 * 4. @Override public long getBasePrice()
 *    Logika Implementasi:
 *      return basePrice;
 * 
 * 5. @Override public String toString()
 *    Logika Implementasi:
 *      return displayName + " [" + category + "] (" + itemId + ", " + basePrice + " G)";
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

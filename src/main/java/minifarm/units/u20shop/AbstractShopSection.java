package minifarm.units.u20shop;

import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractShopSection
 * ================================================================================================
 * Modul Unit: U20SHOP
 * 
 * Deskripsi Kelas:
 * Kelas abstrak bagian etalase toko (Shop Section).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractShopSection
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String sectionName;
 * 2. private final Map<String, Long> offerings = new LinkedHashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractShopSection(String sectionName)
 *    Logika Implementasi:
 *      this.sectionName = sectionName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getSectionName()
 *    Logika Implementasi:
 *      return sectionName;
 * 
 * 2. public void addOffering(String itemId, long price)
 *    Logika Implementasi:
 *      if (itemId != null && price >= 0) {
 *          offerings.put(itemId.toLowerCase(), price);
 *      }
 * 
 * 3. public boolean hasItem(String itemId)
 *    Logika Implementasi:
 *      return itemId != null && offerings.containsKey(itemId.toLowerCase());
 * 
 * 4. public long getPrice(String itemId)
 *    Logika Implementasi:
 *      if (itemId == null) return -1;
 *      return offerings.getOrDefault(itemId.toLowerCase(), -1L);
 * 
 * 5. public Map<String, Long> getOfferings()
 *    Logika Implementasi:
 *      return Collections.unmodifiableMap(offerings);
 * 
 * 6. public abstract boolean acceptsCategory(String category)
 *    Keterangan / Tujuan: Memeriksa apakah seksi ini mencakup kategori tertentu (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

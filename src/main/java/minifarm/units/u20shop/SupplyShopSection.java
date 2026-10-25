package minifarm.units.u20shop;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SupplyShopSection
 * ================================================================================================
 * Modul Unit: U20SHOP
 * 
 * Deskripsi Kelas:
 * Seksi toko untuk perlengkapan ternak dan perawatan (pakan, pupuk, pestisida).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SupplyShopSection
 * - Superclass (Pewarisan) : extends AbstractShopSection
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SupplyShopSection()
 *    Logika Implementasi:
 *      super("Supplies");
 *      addOffering(GameConfig.ITEM_ANIMAL_FEED, GameConfig.ANIMAL_FEED_PRICE);
 *      addOffering(GameConfig.ITEM_FERTILIZER, GameConfig.FERTILIZER_PRICE);
 *      addOffering(GameConfig.ITEM_PESTICIDE, GameConfig.PESTICIDE_PRICE);
 *      addOffering(GameConfig.ITEM_MEDICINE, GameConfig.MEDICINE_PRICE);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean acceptsCategory(String category)
 *    Logika Implementasi:
 *      return "supply".equalsIgnoreCase(category) || "consumable".equalsIgnoreCase(category);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

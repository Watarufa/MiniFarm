package minifarm.units.u20shop;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SeedShopSection
 * ================================================================================================
 * Modul Unit: U20SHOP
 * 
 * Deskripsi Kelas:
 * Seksi toko untuk benih tanaman.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SeedShopSection
 * - Superclass (Pewarisan) : extends AbstractShopSection
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SeedShopSection()
 *    Logika Implementasi:
 *      super("Seeds");
 *      addOffering(GameConfig.SEED_WHEAT, GameConfig.WHEAT_SEED_PRICE);
 *      addOffering(GameConfig.SEED_CORN, GameConfig.CORN_SEED_PRICE);
 *      addOffering(GameConfig.SEED_TOMATO, GameConfig.TOMATO_SEED_PRICE);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean acceptsCategory(String category)
 *    Logika Implementasi:
 *      return "seed".equalsIgnoreCase(category) || "resource".equalsIgnoreCase(category);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

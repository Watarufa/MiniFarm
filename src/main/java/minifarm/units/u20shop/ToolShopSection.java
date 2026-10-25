package minifarm.units.u20shop;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ToolShopSection
 * ================================================================================================
 * Modul Unit: U20SHOP
 * 
 * Deskripsi Kelas:
 * Seksi toko untuk peralatan pertanian.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ToolShopSection
 * - Superclass (Pewarisan) : extends AbstractShopSection
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ToolShopSection()
 *    Logika Implementasi:
 *      super("Tools");
 *      addOffering(GameConfig.TOOL_WATERING_CAN, 50L);
 *      addOffering(GameConfig.TOOL_HOE, 50L);
 *      addOffering("scythe", 80L);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean acceptsCategory(String category)
 *    Logika Implementasi:
 *      return "tool".equalsIgnoreCase(category);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

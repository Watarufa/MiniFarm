package minifarm.units.u09item;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ToolItem
 * ================================================================================================
 * Modul Unit: U09ITEM
 * 
 * Deskripsi Kelas:
 * Item peralatan pertanian (Tool) seperti watering can dan hoe.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ToolItem
 * - Superclass (Pewarisan) : extends AbstractFarmItem
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ToolItem(String itemId, String displayName, long basePrice)
 *    Logika Implementasi:
 *      super(itemId, displayName, "Tool", basePrice);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean canSell()
 *    Logika Implementasi:
 *      return false; // Alat dasar tidak dapat dijual
 * 
 * 2. @Override public boolean canConsume()
 *    Logika Implementasi:
 *      return false;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

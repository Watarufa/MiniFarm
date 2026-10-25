package minifarm.units.u09item;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ConsumableItem
 * ================================================================================================
 * Modul Unit: U09ITEM
 * 
 * Deskripsi Kelas:
 * Item habis pakai (Consumable) seperti pupuk (fertilizer) atau pakan (animal feed).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ConsumableItem
 * - Superclass (Pewarisan) : extends AbstractFarmItem
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ConsumableItem(String itemId, String displayName, long basePrice)
 *    Logika Implementasi:
 *      super(itemId, displayName, "Consumable", basePrice);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean canSell()
 *    Logika Implementasi:
 *      return false;
 * 
 * 2. @Override public boolean canConsume()
 *    Logika Implementasi:
 *      return true;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

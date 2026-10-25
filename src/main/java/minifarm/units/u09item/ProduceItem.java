package minifarm.units.u09item;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ProduceItem
 * ================================================================================================
 * Modul Unit: U09ITEM
 * 
 * Deskripsi Kelas:
 * Item komoditas hasil panen / peternakan (Produce) seperti wheat, corn, egg.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ProduceItem
 * - Superclass (Pewarisan) : extends AbstractFarmItem
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ProduceItem(String itemId, String displayName, long basePrice)
 *    Logika Implementasi:
 *      super(itemId, displayName, "Produce", basePrice);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean canSell()
 *    Logika Implementasi:
 *      return true;
 * 
 * 2. @Override public boolean canConsume()
 *    Logika Implementasi:
 *      return false;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

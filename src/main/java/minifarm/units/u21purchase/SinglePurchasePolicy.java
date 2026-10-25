package minifarm.units.u21purchase;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SinglePurchasePolicy
 * ================================================================================================
 * Modul Unit: U21PURCHASE
 * 
 * Deskripsi Kelas:
 * Kebijakan pembelian standar tanpa diskon. Total = unitPrice * quantity.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SinglePurchasePolicy
 * - Superclass (Pewarisan) : extends AbstractPurchasePolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SinglePurchasePolicy()
 *    Logika Implementasi:
 *      super("SinglePurchasePolicy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculateTotalCost(long unitPrice, int quantity)
 *    Logika Implementasi:
 *      if (unitPrice < 0 || quantity <= 0) return 0;
 *      return unitPrice * quantity;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

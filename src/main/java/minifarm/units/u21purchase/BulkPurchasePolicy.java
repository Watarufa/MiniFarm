package minifarm.units.u21purchase;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): BulkPurchasePolicy
 * ================================================================================================
 * Modul Unit: U21PURCHASE
 * 
 * Deskripsi Kelas:
 * Kebijakan pembelian grosir: diskon 10% jika membeli >= 10 unit.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class BulkPurchasePolicy
 * - Superclass (Pewarisan) : extends AbstractPurchasePolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public BulkPurchasePolicy()
 *    Logika Implementasi:
 *      super("BulkPurchasePolicy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculateTotalCost(long unitPrice, int quantity)
 *    Logika Implementasi:
 *      if (unitPrice < 0 || quantity <= 0) return 0;
 *      long total = unitPrice * quantity;
 *      if (quantity >= 10) {
 *          return (long) (total * 0.9); // Diskon 10%
 *      }
 *      return total;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u22pricing;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): BulkDiscountPricingStrategy
 * ================================================================================================
 * Modul Unit: U22PRICING
 * 
 * Deskripsi Kelas:
 * Strategi diskon volume: pembelian >= 20 unit mendapat potongan 15%.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class BulkDiscountPricingStrategy
 * - Superclass (Pewarisan) : extends AbstractPricingStrategy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public BulkDiscountPricingStrategy()
 *    Logika Implementasi:
 *      super("BulkDiscountPricingStrategy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculatePrice(long basePrice, int quantity, int qualityLevel)
 *    Logika Implementasi:
 *      if (basePrice < 0 || quantity <= 0) return 0;
 *      long subtotal = basePrice * quantity;
 *      if (quantity >= 20) {
 *          return (long) Math.round(subtotal * 0.85);
 *      }
 *      return subtotal;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

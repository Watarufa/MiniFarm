package minifarm.units.u22pricing;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): FixedPricingStrategy
 * ================================================================================================
 * Modul Unit: U22PRICING
 * 
 * Deskripsi Kelas:
 * Strategi harga tetap (Fixed Pricing - Default): total = basePrice * quantity.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class FixedPricingStrategy
 * - Superclass (Pewarisan) : extends AbstractPricingStrategy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public FixedPricingStrategy()
 *    Logika Implementasi:
 *      super("FixedPricingStrategy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculatePrice(long basePrice, int quantity, int qualityLevel)
 *    Logika Implementasi:
 *      if (basePrice < 0 || quantity <= 0) return 0;
 *      return basePrice * quantity;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u22pricing;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): QualityPricingStrategy
 * ================================================================================================
 * Modul Unit: U22PRICING
 * 
 * Deskripsi Kelas:
 * Strategi harga berdasarkan kualitas item: setiap level kualitas di atas 1 memberi bonus 20%.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class QualityPricingStrategy
 * - Superclass (Pewarisan) : extends AbstractPricingStrategy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public QualityPricingStrategy()
 *    Logika Implementasi:
 *      super("QualityPricingStrategy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculatePrice(long basePrice, int quantity, int qualityLevel)
 *    Logika Implementasi:
 *      if (basePrice < 0 || quantity <= 0) return 0;
 *      double multiplier = 1.0 + Math.max(0, qualityLevel - 1) * 0.2;
 *      return (long) Math.round(basePrice * quantity * multiplier);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

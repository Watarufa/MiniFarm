package minifarm.units.u22pricing;

import minifarm.core.api.PricingPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): PricingService
 * ================================================================================================
 * Modul Unit: U22PRICING
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U22: Strategi Penetapan Harga.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class PricingService implements PricingPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private AbstractPricingStrategy defaultStrategy;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public PricingService(AbstractPricingStrategy strategy)
 *    Logika Implementasi:
 *      this.defaultStrategy = strategy != null ? strategy : new FixedPricingStrategy();
 * 
 * 2. Constructor: public PricingService()
 *    Logika Implementasi:
 *      this(new FixedPricingStrategy());
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setStrategy(AbstractPricingStrategy strategy)
 *    Logika Implementasi:
 *      if (strategy != null) {
 *          this.defaultStrategy = strategy;
 *      }
 * 
 * 2. public long calculatePrice(long basePrice, int quantity, int qualityLevel)
 *    Logika Implementasi:
 *      // TODO U22: Hitung harga secara polimorfik menggunakan defaultStrategy
 *      return defaultStrategy.calculatePrice(basePrice, quantity, qualityLevel);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

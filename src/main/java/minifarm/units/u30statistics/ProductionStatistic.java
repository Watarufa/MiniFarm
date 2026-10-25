package minifarm.units.u30statistics;

import minifarm.core.events.AnimalProductCollected;
import minifarm.core.events.CropHarvested;
import minifarm.core.events.DomainEvent;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ProductionStatistic
 * ================================================================================================
 * Modul Unit: U30STATISTICS
 * 
 * Deskripsi Kelas:
 * Statistik produksi hasil pertanian dan produk peternakan.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ProductionStatistic
 * - Superclass (Pewarisan) : extends AbstractFarmStatistic
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private int totalCropsHarvested = 0;
 * 2. private int totalAnimalProductsCollected = 0;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ProductionStatistic()
 *    Logika Implementasi:
 *      super("Statistik Produksi");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public int getTotalCropsHarvested()
 *    Logika Implementasi:
 *      return totalCropsHarvested;
 * 
 * 2. public int getTotalAnimalProductsCollected()
 *    Logika Implementasi:
 *      return totalAnimalProductsCollected;
 * 
 * 3. @Override public void onEvent(DomainEvent event)
 *    Logika Implementasi:
 *      if (event instanceof CropHarvested harvest) {
 *          totalCropsHarvested += harvest.getQuantity();
 *      } else if (event instanceof AnimalProductCollected product) {
 *          totalAnimalProductsCollected += product.getQuantity();
 *      }
 * 
 * 4. @Override public String getFormattedSummary()
 *    Logika Implementasi:
 *      return "Total Panen: " + totalCropsHarvested + " | Produk Ternak: " + totalAnimalProductsCollected;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

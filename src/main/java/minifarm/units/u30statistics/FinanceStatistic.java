package minifarm.units.u30statistics;

import minifarm.core.events.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): FinanceStatistic
 * ================================================================================================
 * Modul Unit: U30STATISTICS
 * 
 * Deskripsi Kelas:
 * Statistik finansial: total koin diperoleh dan dibelanjakan.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class FinanceStatistic
 * - Superclass (Pewarisan) : extends AbstractFarmStatistic
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private long totalEarned = 0;
 * 2. private long totalSpent = 0;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public FinanceStatistic()
 *    Logika Implementasi:
 *      super("Statistik Keuangan");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public long getTotalEarned()
 *    Logika Implementasi:
 *      return totalEarned;
 * 
 * 2. public long getTotalSpent()
 *    Logika Implementasi:
 *      return totalSpent;
 * 
 * 3. @Override public void onEvent(DomainEvent event)
 *    Logika Implementasi:
 *      if (event instanceof ItemSold sold) {
 *          totalEarned += sold.getTotalPrice();
 *      } else if (event instanceof OrderCompleted order) {
 *          totalEarned += order.getRewardCoins();
 *      } else if (event instanceof ItemPurchased purchase) {
 *          totalSpent += purchase.getTotalPrice();
 *      } else if (event instanceof FarmUpgradePurchased up) {
 *          totalSpent += up.getCost();
 *      }
 * 
 * 4. @Override public String getFormattedSummary()
 *    Logika Implementasi:
 *      return "Total Pemasukan: " + totalEarned + " G | Total Pengeluaran: " + totalSpent + " G";
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

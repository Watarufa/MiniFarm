package minifarm.units.u25quest;

import minifarm.core.events.AnimalProductCollected;
import minifarm.core.events.DomainEvent;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AnimalProductQuest
 * ================================================================================================
 * Modul Unit: U25QUEST
 * 
 * Deskripsi Kelas:
 * Quest mengumpulkan produk hewani.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AnimalProductQuest
 * - Superclass (Pewarisan) : extends AbstractQuest
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String requiredProductId;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AnimalProductQuest(String questId, String title, String productId, int target, long reward)
 *    Logika Implementasi:
 *      super(questId, title, target, reward);
 *      this.requiredProductId = productId.toLowerCase();
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean handleEvent(DomainEvent event)
 *    Logika Implementasi:
 *      if (event instanceof AnimalProductCollected product) {
 *          if (product.getProductId().equalsIgnoreCase(requiredProductId)) {
 *              advanceProgress(product.getQuantity());
 *              return true;
 *          }
 *      }
 *      return false;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

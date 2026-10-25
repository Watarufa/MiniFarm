package minifarm.units.u26achievement;

import minifarm.core.api.ExperiencePort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.WalletPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ItemReward
 * ================================================================================================
 * Modul Unit: U26ACHIEVEMENT
 * 
 * Deskripsi Kelas:
 * Hadiah berupa Item inventaris.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ItemReward
 * - Superclass (Pewarisan) : extends AbstractReward
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String itemId;
 * 2. private final int quantity;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ItemReward(String itemId, int quantity)
 *    Logika Implementasi:
 *      super(quantity + "x " + itemId);
 *      this.itemId = itemId;
 *      this.quantity = quantity;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> grant(WalletPort wallet, InventoryPort inventory, ExperiencePort experience)
 *    Logika Implementasi:
 *      if (inventory != null) {
 *          return inventory.addItem(itemId, quantity);
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

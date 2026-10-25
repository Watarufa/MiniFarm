package minifarm.units.u29order;

import minifarm.core.api.InventoryPort;
import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.Collections;
import java.util.List;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractDeliveryOrder
 * ================================================================================================
 * Modul Unit: U29ORDER
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar pesanan pengiriman komoditas (Delivery Order).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractDeliveryOrder
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String orderId;
 * 2. private final String customerName;
 * 3. private final long rewardCoins;
 * 4. private final List<ItemStack> requiredItems;
 * 5. private boolean completed;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractDeliveryOrder(String orderId, String customerName, long rewardCoins, List<ItemStack> requiredItems)
 *    Logika Implementasi:
 *      this.orderId = orderId;
 *      this.customerName = customerName;
 *      this.rewardCoins = rewardCoins;
 *      this.requiredItems = requiredItems != null ? requiredItems : List.of();
 *      this.completed = false;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getOrderId()
 *    Logika Implementasi:
 *      return orderId;
 * 
 * 2. public String getCustomerName()
 *    Logika Implementasi:
 *      return customerName;
 * 
 * 3. public long getRewardCoins()
 *    Logika Implementasi:
 *      return rewardCoins;
 * 
 * 4. public List<ItemStack> getRequiredItems()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(requiredItems);
 * 
 * 5. public boolean isCompleted()
 *    Logika Implementasi:
 *      return completed;
 * 
 * 6. public void setCompleted(boolean completed)
 *    Logika Implementasi:
 *      this.completed = completed;
 * 
 * 7. public OperationResult<Void> validateAvailability(InventoryPort inventoryPort)
 *    Logika Implementasi:
 *      if (completed) {
 *          return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Pesanan sudah pernah dipenuhi");
 *      }
 *      for (ItemStack req : requiredItems) {
 *          if (!inventoryPort.hasItem(req.getItemId(), req.getQuantity())) {
 *              return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Item kurang: butuh " + req.getQuantity() + "x " + req.getItemId());
 *          }
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

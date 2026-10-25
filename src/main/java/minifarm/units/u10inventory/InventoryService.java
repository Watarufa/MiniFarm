package minifarm.units.u10inventory;

import minifarm.core.api.InventoryPort;
import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): InventoryService
 * ================================================================================================
 * Modul Unit: U10INVENTORY
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U10: Inventaris Pemain.
 * Mengimplementasikan InventoryPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class InventoryService
 * - Interface yang Diimplementasikan: implements InventoryPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final int capacity;
 * 2. private final Map<String, Integer> items = new LinkedHashMap<>();
 * 3. private AbstractInventoryPolicy policy;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public InventoryService(int capacity, AbstractInventoryPolicy policy)
 *    Logika Implementasi:
 *      this.capacity = capacity;
 *      this.policy = policy != null ? policy : new SlotCapacityPolicy();
 * 
 * 2. Constructor: public InventoryService()
 *    Logika Implementasi:
 *      this(GameConfig.INVENTORY_SLOT_CAPACITY, new SlotCapacityPolicy());
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setPolicy(AbstractInventoryPolicy policy)
 *    Logika Implementasi:
 *      if (policy != null) this.policy = policy;
 * 
 * 2. @Override public boolean hasItem(String itemId, int quantity)
 *    Logika Implementasi:
 *      if (itemId == null || quantity <= 0) return false;
 *      return items.getOrDefault(itemId.trim().toLowerCase(), 0) >= quantity;
 * 
 * 3. @Override public int getItemQuantity(String itemId)
 *    Logika Implementasi:
 *      if (itemId == null) return 0;
 *      return items.getOrDefault(itemId.trim().toLowerCase(), 0);
 * 
 * 4. @Override public OperationResult<Void> addItem(String itemId, int quantity)
 *    Logika Implementasi:
 *      // TODO U10:
 *      // 1. Validasi input menggunakan policy.validateCanAdd(...).
 *      // 2. Jika valid, tambahkan ke slot item (jika sudah ada, tumpuk jumlahnya).
 *      // 3. Kembalikan OperationResult.ok().
 *      if (itemId == null || itemId.trim().isEmpty() || quantity <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item atau kuantitas tidak valid");
 *      }
 *      String id = itemId.trim().toLowerCase();
 *      OperationResult<Void> valRes = policy.validateCanAdd(id, quantity, items, capacity);
 *      if (valRes.isFailure()) {
 *          return valRes;
 *      }
 *      
 *      items.put(id, items.getOrDefault(id, 0) + quantity);
 *      return OperationResult.ok();
 * 
 * 5. @Override public OperationResult<Void> removeItem(String itemId, int quantity)
 *    Logika Implementasi:
 *      // TODO U10:
 *      // 1. Cek apakah item tersedia sebanyak quantity.
 *      // 2. Jika kurang, kembalikan ResultCode.INSUFFICIENT_ITEMS.
 *      // 3. Jika habis pas, hapus key dari map; jika tersisa, kurangi jumlahnya.
 *      if (itemId == null || quantity <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item atau kuantitas tidak valid");
 *      }
 *      String id = itemId.trim().toLowerCase();
 *      int current = items.getOrDefault(id, 0);
 *      if (current < quantity) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Jumlah item tidak mencukupi di inventaris");
 *      }
 *      
 *      if (current == quantity) {
 *          items.remove(id);
 *      } else {
 *          items.put(id, current - quantity);
 *      }
 *      return OperationResult.ok();
 * 
 * 6. @Override public int getAvailableSlots()
 *    Logika Implementasi:
 *      return Math.max(0, capacity - items.size());
 * 
 * 7. @Override public int getTotalCapacity()
 *    Logika Implementasi:
 *      return capacity;
 * 
 * 8. @Override public List<ItemStack> getItems()
 *    Logika Implementasi:
 *      List<ItemStack> list = new ArrayList<>();
 *      items.forEach((id, qty) -> list.add(new ItemStack(id, qty)));
 *      return Collections.unmodifiableList(list);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

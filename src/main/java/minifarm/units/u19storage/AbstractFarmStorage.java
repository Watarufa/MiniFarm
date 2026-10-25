package minifarm.units.u19storage;

import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractFarmStorage
 * ================================================================================================
 * Modul Unit: U19STORAGE
 * 
 * Deskripsi Kelas:
 * Kelas abstrak fasilitas penyimpanan pertanian terpisah dari inventaris pemain.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractFarmStorage
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String storageId;
 * 2. private final String storageName;
 * 3. private int capacity;
 * 4. private final Map<String, Integer> items = new LinkedHashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractFarmStorage(String storageId, String storageName, int initialCapacity)
 *    Logika Implementasi:
 *      this.storageId = storageId;
 *      this.storageName = storageName;
 *      this.capacity = initialCapacity;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getStorageId()
 *    Logika Implementasi:
 *      return storageId;
 * 
 * 2. public String getStorageName()
 *    Logika Implementasi:
 *      return storageName;
 * 
 * 3. public int getCapacity()
 *    Logika Implementasi:
 *      return capacity;
 * 
 * 4. public void expandCapacity(int extra)
 *    Logika Implementasi:
 *      if (extra > 0) this.capacity += extra;
 * 
 * 5. public int getAvailableSlots()
 *    Logika Implementasi:
 *      return Math.max(0, capacity - items.size());
 * 
 * 6. public int getItemQuantity(String itemId)
 *    Logika Implementasi:
 *      if (itemId == null) return 0;
 *      return items.getOrDefault(itemId.toLowerCase(), 0);
 * 
 * 7. public List<ItemStack> getStoredItems()
 *    Logika Implementasi:
 *      List<ItemStack> list = new ArrayList<>();
 *      items.forEach((k, v) -> list.add(new ItemStack(k, v)));
 *      return Collections.unmodifiableList(list);
 * 
 * 8. public OperationResult<Void> deposit(String itemId, int quantity)
 *    Logika Implementasi:
 *      if (itemId == null || quantity <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item atau kuantitas tidak valid");
 *      }
 *      if (!acceptsItem(itemId)) {
 *          return OperationResult.failed(ResultCode.NOT_ALLOWED, storageName + " tidak menerima jenis item ini");
 *      }
 *      String id = itemId.toLowerCase();
 *      if (!items.containsKey(id) && items.size() >= capacity) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, storageName + " sudah penuh");
 *      }
 *      items.put(id, items.getOrDefault(id, 0) + quantity);
 *      return OperationResult.ok();
 * 
 * 9. public OperationResult<Void> withdraw(String itemId, int quantity)
 *    Logika Implementasi:
 *      if (itemId == null || quantity <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item atau kuantitas tidak valid");
 *      }
 *      String id = itemId.toLowerCase();
 *      int cur = items.getOrDefault(id, 0);
 *      if (cur < quantity) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Stok di storage tidak mencukupi");
 *      }
 *      if (cur == quantity) {
 *          items.remove(id);
 *      } else {
 *          items.put(id, cur - quantity);
 *      }
 *      return OperationResult.ok();
 * 
 * 10. public abstract boolean acceptsItem(String itemId)
 *    Keterangan / Tujuan: Memeriksa apakah storage menerima jenis item ini (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

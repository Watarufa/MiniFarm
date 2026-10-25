package minifarm.units.u19storage;

import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.StorageCapacityPort;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): StorageService
 * ================================================================================================
 * Modul Unit: U19STORAGE
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U19: Storage Pertanian.
 * Mengimplementasikan StorageCapacityPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class StorageService
 * - Interface yang Diimplementasikan: implements StorageCapacityPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AbstractFarmStorage> storages = new LinkedHashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public StorageService()
 *    Logika Implementasi:
 *      BarnStorage barn = new BarnStorage();
 *      SiloStorage silo = new SiloStorage();
 *      storages.put(barn.getStorageId(), barn);
 *      storages.put(silo.getStorageId(), silo);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public AbstractFarmStorage getStorage(String storageId)
 *    Logika Implementasi:
 *      if (storageId == null) return null;
 *      return storages.get(storageId.toLowerCase());
 * 
 * 2. public OperationResult<Void> transferToStorage(String storageId, String itemId, int quantity, InventoryPort inventoryPort)
 *    Keterangan / Tujuan: Transfer item dari inventaris pemain ke fasilitas penyimpanan secara atomik.
 *    Logika Implementasi:
 *      // TODO U19:
 *      // 1. Cek apakah inventory memiliki item sebanyak quantity.
 *      // 2. Cek apakah storageId valid dan dapat menerima item.
 *      // 3. Deposit ke storage. Jika berhasil, remove dari inventory.
 *      // 4. Pastikan jika deposit gagal, inventaris tidak terpotong (atomik)!
 *      AbstractFarmStorage storage = getStorage(storageId);
 *      if (storage == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Storage tidak ditemukan: " + storageId);
 *      }
 *      if (!inventoryPort.hasItem(itemId, quantity)) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Item tidak mencukupi di inventaris");
 *      }
 *      
 *      OperationResult<Void> depositRes = storage.deposit(itemId, quantity);
 *      if (depositRes.isFailure()) {
 *          return depositRes;
 *      }
 *      
 *      inventoryPort.removeItem(itemId, quantity);
 *      return OperationResult.ok();
 * 
 * 3. public OperationResult<Void> transferToInventory(String storageId, String itemId, int quantity, InventoryPort inventoryPort)
 *    Keterangan / Tujuan: Transfer item dari fasilitas penyimpanan ke inventaris pemain secara atomik.
 *    Logika Implementasi:
 *      AbstractFarmStorage storage = getStorage(storageId);
 *      if (storage == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Storage tidak ditemukan: " + storageId);
 *      }
 *      if (storage.getItemQuantity(itemId) < quantity) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Item tidak cukup di storage");
 *      }
 *      if (inventoryPort.getAvailableSlots() <= 0 && !inventoryPort.hasItem(itemId, 1)) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Slot inventaris penuh");
 *      }
 *      
 *      OperationResult<Void> withdrawRes = storage.withdraw(itemId, quantity);
 *      if (withdrawRes.isFailure()) {
 *          return withdrawRes;
 *      }
 *      
 *      inventoryPort.addItem(itemId, quantity);
 *      return OperationResult.ok();
 * 
 * 4. @Override public int getStorageCapacity()
 *    Logika Implementasi:
 *      AbstractFarmStorage barn = getStorage("barn_storage");
 *      return barn != null ? barn.getCapacity() : 0;
 * 
 * 5. @Override public OperationResult<Void> expandStorageCapacity(int additionalSlots)
 *    Logika Implementasi:
 *      AbstractFarmStorage barn = getStorage("barn_storage");
 *      if (barn == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Barn storage tidak ditemukan");
 *      }
 *      barn.expandCapacity(additionalSlots);
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

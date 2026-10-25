package minifarm.units.u21purchase;

import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.events.EventBus;
import minifarm.core.events.ItemPurchased;
import minifarm.core.api.ShopCatalogPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): PurchaseService
 * ================================================================================================
 * Modul Unit: U21PURCHASE
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U21: Alur Pembelian.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class PurchaseService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private AbstractPurchasePolicy policy;
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public PurchaseService(AbstractPurchasePolicy policy, EventBus eventBus)
 *    Logika Implementasi:
 *      this.policy = policy != null ? policy : new SinglePurchasePolicy();
 *      this.eventBus = eventBus;
 * 
 * 2. Constructor: public PurchaseService(EventBus eventBus)
 *    Logika Implementasi:
 *      this(new SinglePurchasePolicy(), eventBus);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setPolicy(AbstractPurchasePolicy policy)
 *    Logika Implementasi:
 *      if (policy != null) this.policy = policy;
 * 
 * 2. public OperationResult<Void> purchase( String itemId, int quantity, int day, ShopCatalogPort shop, WalletPort walletPort, InventoryPort inventoryPort )
 *    Keterangan / Tujuan: Membeli item dari toko dan memasukkannya ke inventaris pemain secara atomik.
 *    Logika Implementasi:
 *      // TODO U21:
 *      // 1. Validasi parameter (quantity > 0, itemId tidak kosong).
 *      // 2. Ambil harga dari toko (shop.getItemPrice).
 *      // 3. Hitung total biaya melalui policy.calculateTotalCost.
 *      // 4. Validasi saldo pemain (walletPort.getBalance() >= totalCost).
 *      // 5. Validasi ruang inventaris (apakah inventory muat).
 *      // 6. Lakukan debit wallet dan penambahan item ke inventory secara atomik!
 *      // 7. Publikasikan event ItemPurchased jika berhasil.
 *      if (itemId == null || itemId.trim().isEmpty() || quantity <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item atau kuantitas pembelian tidak valid");
 *      }
 *      
 *      OperationResult<Long> priceRes = shop.getItemPrice(itemId);
 *      if (priceRes.isFailure()) {
 *          return OperationResult.failed(priceRes.getCode(), priceRes.getMessage());
 *      }
 *      
 *      long unitPrice = priceRes.getOrNull();
 *      long totalCost = policy.calculateTotalCost(unitPrice, quantity);
 *      
 *      if (walletPort.getBalance() < totalCost) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_FUNDS, "Saldo tidak cukup (Butuh: " + totalCost + " G)");
 *      }
 *      
 *      if (inventoryPort.getAvailableSlots() <= 0 && !inventoryPort.hasItem(itemId, 1)) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Slot inventaris penuh");
 *      }
 *      
 *      // Eksekusi atomik: debit wallet, lalu tambahkan item
 *      OperationResult<Void> debitRes = walletPort.debit(totalCost, "Beli " + itemId + " x" + quantity);
 *      if (debitRes.isFailure()) {
 *          return debitRes;
 *      }
 *      
 *      OperationResult<Void> addRes = inventoryPort.addItem(itemId, quantity);
 *      if (addRes.isFailure()) {
 *          // Kompensasi jika penambahan gagal
 *          walletPort.credit(totalCost, "Refund gagal beli " + itemId);
 *          return addRes;
 *      }
 *      
 *      if (eventBus != null) {
 *          eventBus.publish(new ItemPurchased(day, itemId, quantity, totalCost));
 *      }
 *      
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */
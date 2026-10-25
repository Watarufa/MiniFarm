package minifarm.units.u23sale;

import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.events.EventBus;
import minifarm.core.events.ItemSold;
import minifarm.core.api.ItemCatalogPort;
import minifarm.core.api.ItemDefinitionPort;
import minifarm.core.api.PricingPort;
import java.util.Optional;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SellingService
 * ================================================================================================
 * Modul Unit: U23SALE
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U23: Alur Penjualan.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SellingService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private AbstractSalePolicy policy;
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SellingService(AbstractSalePolicy policy, EventBus eventBus)
 *    Logika Implementasi:
 *      this.policy = policy != null ? policy : new SingleSalePolicy();
 *      this.eventBus = eventBus;
 * 
 * 2. Constructor: public SellingService(EventBus eventBus)
 *    Logika Implementasi:
 *      this(new SingleSalePolicy(), eventBus);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setPolicy(AbstractSalePolicy policy)
 *    Logika Implementasi:
 *      if (policy != null) this.policy = policy;
 * 
 * 2. public OperationResult<Long> sellItem( String itemId, int quantity, int day, ItemCatalogPort catalog, PricingPort pricingService, InventoryPort inventoryPort, WalletPort walletPort )
 *    Keterangan / Tujuan: Menjual item dari inventaris pemain ke pasar secara atomik.
 *    Logika Implementasi:
 *      // TODO U23:
 *      // 1. Ambil definisi item dari catalog.getItem(itemId).
 *      // 2. Validasi dengan policy.validateSale(itemId, quantity, item.canSell()).
 *      // 3. Cek stok inventaris: inventoryPort.hasItem(itemId, quantity).
 *      // 4. Hitung total pemasukan koin via pricingService.calculatePrice(...).
 *      // 5. Potong item dari inventaris (inventoryPort.removeItem).
 *      // 6. Kredit wallet (walletPort.credit).
 *      // 7. Publikasikan event ItemSold jika sukses.
 *      // 8. Pastikan seluruh transaksi bersifat atomik!
 *      Optional<? extends ItemDefinitionPort> itemOpt = catalog.getItem(itemId);
 *      if (itemOpt.isEmpty()) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Item tidak terdaftar: " + itemId);
 *      }
 *      ItemDefinitionPort item = itemOpt.get();
 *      
 *      OperationResult<Void> valRes = policy.validateSale(itemId, quantity, item.canSell());
 *      if (valRes.isFailure()) {
 *          return OperationResult.failed(valRes.getCode(), valRes.getMessage());
 *      }
 *      
 *      if (!inventoryPort.hasItem(itemId, quantity)) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Stok item tidak mencukupi untuk dijual");
 *      }
 *      
 *      long earnings = pricingService.calculatePrice(item.getBasePrice(), quantity, 1);
 *      
 *      OperationResult<Void> removeRes = inventoryPort.removeItem(itemId, quantity);
 *      if (removeRes.isFailure()) {
 *          return OperationResult.failed(removeRes.getCode(), removeRes.getMessage());
 *      }
 *      
 *      walletPort.credit(earnings, "Jual " + itemId + " x" + quantity);
 *      
 *      if (eventBus != null) {
 *          eventBus.publish(new ItemSold(day, itemId, quantity, earnings));
 *      }
 *      
 *      return OperationResult.ok("Berhasil menjual " + quantity + " " + item.getDisplayName() + " seharga " + earnings + " G", earnings);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

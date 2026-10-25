package minifarm.units.u20shop;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ShopCatalogPort;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ShopCatalogService
 * ================================================================================================
 * Modul Unit: U20SHOP
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U20: Katalog Toko.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ShopCatalogService implements ShopCatalogPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final List<AbstractShopSection> sections = new ArrayList<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ShopCatalogService()
 *    Logika Implementasi:
 *      sections.add(new SeedShopSection());
 *      sections.add(new ToolShopSection());
 *      sections.add(new SupplyShopSection());
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public List<AbstractShopSection> getSections()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(sections);
 * 
 * 2. public boolean isItemForSale(String itemId)
 *    Logika Implementasi:
 *      if (itemId == null) return false;
 *      for (AbstractShopSection sec : sections) {
 *          if (sec.hasItem(itemId)) return true;
 *      }
 *      return false;
 * 
 * 3. public OperationResult<Long> getItemPrice(String itemId)
 *    Logika Implementasi:
 *      // TODO U20: Cari harga item dari etalase toko. Jika tidak dijual, kembalikan NOT_FOUND
 *      if (itemId == null) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item tidak valid");
 *      }
 *      for (AbstractShopSection sec : sections) {
 *          if (sec.hasItem(itemId)) {
 *              return OperationResult.ok("Item tersedia", sec.getPrice(itemId));
 *          }
 *      }
 *      return OperationResult.failed(ResultCode.NOT_FOUND, "Barang tidak dijual di toko: " + itemId);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

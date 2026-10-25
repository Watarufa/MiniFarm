package minifarm.units.u09item;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ItemCatalogPort;
import minifarm.core.config.GameConfig;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ItemCatalog
 * ================================================================================================
 * Modul Unit: U09ITEM
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U09: Taksonomi Item.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ItemCatalog implements ItemCatalogPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, FarmItem> items = new LinkedHashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ItemCatalog()
 *    Logika Implementasi:
 *      // Registrasi benih (Resource)
 *      register(new ResourceItem(GameConfig.SEED_WHEAT, "Wheat Seed", GameConfig.WHEAT_SEED_PRICE));
 *      register(new ResourceItem(GameConfig.SEED_CORN, "Corn Seed", GameConfig.CORN_SEED_PRICE));
 *      register(new ResourceItem(GameConfig.SEED_TOMATO, "Tomato Seed", GameConfig.TOMATO_SEED_PRICE));
 *      
 *      // Registrasi hasil panen & produk hewan (Produce)
 *      register(new ProduceItem(GameConfig.CROP_WHEAT, "Wheat", GameConfig.WHEAT_SELL_PRICE));
 *      register(new ProduceItem(GameConfig.CROP_CORN, "Corn", GameConfig.CORN_SELL_PRICE));
 *      register(new ProduceItem(GameConfig.CROP_TOMATO, "Tomato", GameConfig.TOMATO_SELL_PRICE));
 *      register(new ProduceItem(GameConfig.ITEM_EGG, "Egg", GameConfig.EGG_SELL_PRICE));
 *      
 *      // Registrasi konsumsi (Consumable)
 *      register(new ConsumableItem(GameConfig.ITEM_ANIMAL_FEED, "Animal Feed", GameConfig.ANIMAL_FEED_PRICE));
 *      register(new ConsumableItem(GameConfig.ITEM_FERTILIZER, "Fertilizer", GameConfig.FERTILIZER_PRICE));
 *      register(new ConsumableItem(GameConfig.ITEM_PESTICIDE, "Pesticide", GameConfig.PESTICIDE_PRICE));
 *      register(new ConsumableItem(GameConfig.ITEM_MEDICINE, "Medicine", GameConfig.MEDICINE_PRICE));
 *      
 *      // Registrasi alat (Tool)
 *      register(new ToolItem(GameConfig.TOOL_WATERING_CAN, "Watering Can", 50L));
 *      register(new ToolItem(GameConfig.TOOL_HOE, "Hoe", 50L));
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void register(FarmItem item)
 *    Logika Implementasi:
 *      if (item == null) {
 *          throw new IllegalArgumentException("Item tidak boleh null");
 *      }
 *      items.put(item.getItemId(), item);
 * 
 * 2. public Optional<FarmItem> getItem(String itemId)
 *    Logika Implementasi:
 *      if (itemId == null) return Optional.empty();
 *      return Optional.ofNullable(items.get(itemId.trim().toLowerCase()));
 * 
 * 3. public OperationResult<FarmItem> findItem(String itemId)
 *    Logika Implementasi:
 *      // TODO U09: Validasi dan kembalikan item terdaftar dalam OperationResult
 *      Optional<FarmItem> opt = getItem(itemId);
 *      if (opt.isEmpty()) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Item tidak ditemukan: " + itemId);
 *      }
 *      return OperationResult.ok(opt.get());
 * 
 * 4. public List<FarmItem> getAllItems()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(new ArrayList<>(items.values()));
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

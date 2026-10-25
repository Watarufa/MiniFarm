package minifarm.fixtures;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ShopCatalogPort;
import minifarm.core.config.GameConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory test double untuk ShopCatalogPort agar U21 dapat diuji tanpa bergantung pada U20.
 */
public class FakeShopCatalog implements ShopCatalogPort {
    private final Map<String, Long> priceMap = new HashMap<>();

    public FakeShopCatalog() {
        priceMap.put(GameConfig.SEED_WHEAT, 5L);
        priceMap.put(GameConfig.SEED_CORN, 8L);
        priceMap.put(GameConfig.SEED_TOMATO, 10L);
        priceMap.put(GameConfig.ITEM_ANIMAL_FEED, 12L);
        priceMap.put(GameConfig.ITEM_FERTILIZER, 15L);
    }

    public void setItemPrice(String itemId, long price) {
        priceMap.put(itemId, price);
    }

    public boolean isItemForSale(String itemId) {
        if (itemId == null) return false;
        return priceMap.containsKey(itemId);
    }

    @Override
    public OperationResult<Long> getItemPrice(String itemId) {
        if (itemId == null) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item tidak valid");
        }
        Long price = priceMap.get(itemId);
        if (price != null) {
            return OperationResult.ok("Tersedia", price);
        }
        return OperationResult.failed(ResultCode.NOT_FOUND, "Barang tidak dijual: " + itemId);
    }
}

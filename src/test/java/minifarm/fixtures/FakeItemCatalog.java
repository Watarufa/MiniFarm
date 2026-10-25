package minifarm.fixtures;

import minifarm.core.api.ItemCatalogPort;
import minifarm.core.api.ItemDefinitionPort;
import minifarm.core.config.GameConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * In-memory test double untuk ItemCatalogPort agar U23 dapat diuji tanpa bergantung pada U09.
 */
public class FakeItemCatalog implements ItemCatalogPort {

    public static class FakeItemDefinition implements ItemDefinitionPort {
        private final String itemId;
        private final String displayName;
        private final long basePrice;
        private final boolean canSell;

        public FakeItemDefinition(String itemId, String displayName, long basePrice, boolean canSell) {
            this.itemId = itemId;
            this.displayName = displayName;
            this.basePrice = basePrice;
            this.canSell = canSell;
        }

        public FakeItemDefinition(String itemId, String displayName, long basePrice) {
            this(itemId, displayName, basePrice, true);
        }

        @Override
        public String getItemId() {
            return itemId;
        }

        @Override
        public String getDisplayName() {
            return displayName;
        }

        @Override
        public long getBasePrice() {
            return basePrice;
        }

        @Override
        public boolean canSell() {
            return canSell;
        }
    }

    private final Map<String, ItemDefinitionPort> itemMap = new HashMap<>();

    public FakeItemCatalog() {
        itemMap.put(GameConfig.CROP_WHEAT, new FakeItemDefinition(GameConfig.CROP_WHEAT, "Wheat", 10L));
        itemMap.put(GameConfig.CROP_CORN, new FakeItemDefinition(GameConfig.CROP_CORN, "Corn", 15L));
        itemMap.put(GameConfig.CROP_TOMATO, new FakeItemDefinition(GameConfig.CROP_TOMATO, "Tomato", 18L));
        itemMap.put(GameConfig.ITEM_EGG, new FakeItemDefinition(GameConfig.ITEM_EGG, "Egg", 8L));
    }

    public void registerFakeItem(ItemDefinitionPort item) {
        if (item != null) {
            itemMap.put(item.getItemId().toLowerCase(), item);
        }
    }

    @Override
    public Optional<ItemDefinitionPort> getItem(String itemId) {
        if (itemId == null) return Optional.empty();
        return Optional.ofNullable(itemMap.get(itemId.toLowerCase()));
    }
}

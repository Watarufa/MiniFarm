package minifarm.units.u20shop;

import minifarm.core.config.GameConfig;

public class SupplyShopSection extends AbstractShopSection {
    public SupplyShopSection() {
        super("Supplies");
        addOffering(GameConfig.ITEM_ANIMAL_FEED, GameConfig.ANIMAL_FEED_PRICE);
        addOffering(GameConfig.ITEM_FERTILIZER, GameConfig.FERTILIZER_PRICE);
        addOffering(GameConfig.ITEM_PESTICIDE, GameConfig.PESTICIDE_PRICE);
        addOffering(GameConfig.ITEM_MEDICINE, GameConfig.MEDICINE_PRICE);
    }

    @Override 
    public boolean acceptsCategory(String category) {
        return "supply".equalsIgnoreCase(category) || "consumable".equalsIgnoreCase(category);
    }
}
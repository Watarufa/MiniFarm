package minifarm.units.u20shop;

import minifarm.core.config.GameConfig;

public class ToolShopSection extends AbstractShopSection {
    public ToolShopSection() {
        super("Tools");
        addOffering(GameConfig.TOOL_WATERING_CAN, 50L);
        addOffering(GameConfig.TOOL_HOE, 50L);
        addOffering("scythe", 80L);
    }

    @Override 
    public boolean acceptsCategory(String category) {
        return "tool".equalsIgnoreCase(category);
    }
}

package minifarm.units.u28crafting;

import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import java.util.List;

public class RepairKitRecipe extends AbstractCraftingRecipe {

    public RepairKitRecipe() {
        super(
                "recipe_repair_kit",
                "Craft Repair Kit",
                GameConfig.ENERGY_COST_CRAFTING,
                List.of(
                        new ItemStack(GameConfig.CROP_WHEAT, 1),
                        new ItemStack(GameConfig.CROP_CORN, 1)
                ),
                new ItemStack("repair_kit", 1)
        );
    }
}

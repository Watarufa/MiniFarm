package minifarm.units.u28crafting;

import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import java.util.List;


public class FertilizerRecipe extends AbstractCraftingRecipe {

    public FertilizerRecipe() {
        super(
                "recipe_fertilizer",
                "Craft Fertilizer",
                GameConfig.ENERGY_COST_CRAFTING,
                List.of(new ItemStack(GameConfig.CROP_TOMATO, 2)),
                new ItemStack(GameConfig.ITEM_FERTILIZER, 1)
        );
    }
}

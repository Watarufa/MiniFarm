package minifarm.units.u28crafting;

import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import java.util.List;

public class AnimalFeedRecipe extends AbstractCraftingRecipe {

    public AnimalFeedRecipe() {
        super(
                "recipe_feed",
                "Craft Animal Feed",
                GameConfig.ENERGY_COST_CRAFTING,
                List.of(
                        new ItemStack(GameConfig.CROP_WHEAT, 2)
                ),
                new ItemStack(GameConfig.ITEM_ANIMAL_FEED, 1)
        );
    }
}
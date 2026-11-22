package minifarm.units.u28crafting;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import java.util.Collections;
import java.util.List;

public abstract class AbstractCraftingRecipe {

    // Atribut
    private final String recipeId;
    private final String recipeName;
    private final int energyCost;
    private final List<ItemStack> requiredIngredients;
    private final ItemStack outputItem;

    // Constructor
    protected AbstractCraftingRecipe(
            String recipeId,
            String recipeName,
            int energyCost,
            List<ItemStack> requiredIngredients,
            ItemStack outputItem) {

        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.energyCost = energyCost > 0
                ? energyCost
                : GameConfig.ENERGY_COST_CRAFTING;

        this.requiredIngredients = requiredIngredients != null
                ? requiredIngredients
                : List.of();

        this.outputItem = outputItem;
    }

    // Getter ID resep
    public String getRecipeId() {
        return recipeId;
    }

    // Getter nama resep
    public String getRecipeName() {
        return recipeName;
    }

    // Getter biaya energi
    public int getEnergyCost() {
        return energyCost;
    }

    // Getter bahan resep
    public List<ItemStack> getRequiredIngredients() {
        return Collections.unmodifiableList(requiredIngredients);
    }

    // Getter hasil crafting
    public ItemStack getOutputItem() {
        return outputItem;
    }

    // Validasi bahan dan energi
    public OperationResult<Void> validate(
            InventoryPort inventory,
            EnergyPort energy) {

        if (energy.getCurrentEnergy() < energyCost) {
            return OperationResult.failed(
                    ResultCode.INSUFFICIENT_ENERGY,
                    "Energi tidak mencukupi untuk crafting"
            );
        }

        for (ItemStack ing : requiredIngredients) {
            if (!inventory.hasItem(
                    ing.getItemId(),
                    ing.getQuantity())) {

                return OperationResult.failed(
                        ResultCode.INSUFFICIENT_ITEMS,
                        "Bahan kurang: butuh "
                                + ing.getQuantity()
                                + "x "
                                + ing.getItemId()
                );
            }
        }

        if (inventory.getAvailableSlots() <= 0
                && !inventory.hasItem(outputItem.getItemId(), 1)) {

            return OperationResult.failed(
                    ResultCode.CAPACITY_EXCEEDED,
                    "Slot inventaris penuh untuk hasil output"
            );
        }

        return OperationResult.ok();
    }
}
package minifarm.units.u28crafting;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.events.EventBus;
import minifarm.core.events.ItemCrafted;
import java.util.*;

public class CraftingService {

    private final Map<String, AbstractCraftingRecipe> recipes = new LinkedHashMap<>();
    private final EventBus eventBus;

    public CraftingService(EventBus eventBus) {
        this.eventBus = eventBus;

        registerRecipe(new FertilizerRecipe());
        registerRecipe(new AnimalFeedRecipe());
        registerRecipe(new RepairKitRecipe());
    }

    public CraftingService() {
        this(null);
    }

    public void registerRecipe(AbstractCraftingRecipe recipe) {
        if (recipe != null) {
            recipes.put(recipe.getRecipeId(), recipe);
        }
    }

    public List<AbstractCraftingRecipe> getAllRecipes() {
        return Collections.unmodifiableList(
                new ArrayList<>(recipes.values())
        );
    }

    public Optional<AbstractCraftingRecipe> getRecipe(String recipeId) {
        if (recipeId == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(recipes.get(recipeId));
    }

    public OperationResult<ItemStack> craft(
            String recipeId,
            int day,
            InventoryPort inventoryPort,
            EnergyPort energyPort) {

        // 1. Mencari resep
        Optional<AbstractCraftingRecipe> recipeOpt = getRecipe(recipeId);

        if (recipeOpt.isEmpty()) {
            return OperationResult.failed(
                    ResultCode.NOT_FOUND,
                    "Resep tidak ditemukan: " + recipeId
            );
        }

        AbstractCraftingRecipe recipe = recipeOpt.get();

        // 2. Memvalidasi bahan dan energi
        OperationResult<Void> valRes =
                recipe.validate(inventoryPort, energyPort);

        if (valRes.isFailure()) {
            return OperationResult.failed(
                    valRes.getCode(),
                    valRes.getMessage()
            );
        }

        // 3. Mengambil hasil crafting
        ItemStack out = recipe.getOutputItem();

        // 4. Mengurangi seluruh bahan
        for (ItemStack ing : recipe.getRequiredIngredients()) {
            inventoryPort.removeItem(
                    ing.getItemId(),
                    ing.getQuantity()
            );
        }

        // 5. Menambahkan hasil crafting
        inventoryPort.addItem(
                out.getItemId(),
                out.getQuantity()
        );

        // 6. Mengurangi energi
        energyPort.consumeEnergy(recipe.getEnergyCost());

        // 7. Mengirim event jika crafting berhasil
        if (eventBus != null) {
            eventBus.publish(
                    new ItemCrafted(
                            day,
                            recipe.getRecipeId(),
                            out.getItemId(),
                            out.getQuantity()
                    )
            );
        }

        // 8. Mengembalikan hasil
        return OperationResult.ok(
                "Berhasil membuat " + out.getQuantity()
                        + "x " + out.getItemId(),
                out
        );
    }
}
package minifarm.units.u28crafting;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import java.util.Collections;
import java.util.List;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractCraftingRecipe
 * ================================================================================================
 * Modul Unit: U28CRAFTING
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar resep crafting barang pertanian.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractCraftingRecipe
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String recipeId;
 * 2. private final String recipeName;
 * 3. private final int energyCost;
 * 4. private final List<ItemStack> requiredIngredients;
 * 5. private final ItemStack outputItem;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractCraftingRecipe( String recipeId, String recipeName, int energyCost, List<ItemStack> requiredIngredients, ItemStack outputItem )
 *    Logika Implementasi:
 *      this.recipeId = recipeId;
 *      this.recipeName = recipeName;
 *      this.energyCost = energyCost > 0 ? energyCost : GameConfig.ENERGY_COST_CRAFTING;
 *      this.requiredIngredients = requiredIngredients != null ? requiredIngredients : List.of();
 *      this.outputItem = outputItem;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getRecipeId()
 *    Logika Implementasi:
 *      return recipeId;
 * 
 * 2. public String getRecipeName()
 *    Logika Implementasi:
 *      return recipeName;
 * 
 * 3. public int getEnergyCost()
 *    Logika Implementasi:
 *      return energyCost;
 * 
 * 4. public List<ItemStack> getRequiredIngredients()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(requiredIngredients);
 * 
 * 5. public ItemStack getOutputItem()
 *    Logika Implementasi:
 *      return outputItem;
 * 
 * 6. public OperationResult<Void> validate(InventoryPort inventory, EnergyPort energy)
 *    Keterangan / Tujuan: Memvalidasi apakah bahan dan energi mencukupi.
 *    Logika Implementasi:
 *      if (energy.getCurrentEnergy() < energyCost) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi untuk crafting");
 *      }
 *      for (ItemStack ing : requiredIngredients) {
 *          if (!inventory.hasItem(ing.getItemId(), ing.getQuantity())) {
 *              return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Bahan kurang: butuh " + ing.getQuantity() + "x " + ing.getItemId());
 *          }
 *      }
 *      if (inventory.getAvailableSlots() <= 0 && !inventory.hasItem(outputItem.getItemId(), 1)) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Slot inventaris penuh untuk hasil output");
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

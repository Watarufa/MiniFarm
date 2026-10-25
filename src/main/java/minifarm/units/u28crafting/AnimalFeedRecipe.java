package minifarm.units.u28crafting;

import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import java.util.List;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AnimalFeedRecipe
 * ================================================================================================
 * Modul Unit: U28CRAFTING
 * 
 * Deskripsi Kelas:
 * Resep Pakan Ternak (Animal Feed Recipe):
 * Bahan: 2 unit wheat -> Output: 1 unit animal_feed. Biaya: 2 energi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AnimalFeedRecipe
 * - Superclass (Pewarisan) : extends AbstractCraftingRecipe
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AnimalFeedRecipe()
 *    Logika Implementasi:
 *      super(
 *              "recipe_feed",
 *              "Craft Animal Feed",
 *              GameConfig.ENERGY_COST_CRAFTING,
 *              List.of(new ItemStack(GameConfig.CROP_WHEAT, 2)),
 *              new ItemStack(GameConfig.ITEM_ANIMAL_FEED, 1)
 *      );
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

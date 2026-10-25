package minifarm.units.u28crafting;

import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import java.util.List;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): FertilizerRecipe
 * ================================================================================================
 * Modul Unit: U28CRAFTING
 * 
 * Deskripsi Kelas:
 * Resep Pembuatan Pupuk Kompos (Fertilizer Recipe):
 * Bahan: 2 unit tomato -> Output: 1 unit fertilizer. Biaya: 2 energi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class FertilizerRecipe
 * - Superclass (Pewarisan) : extends AbstractCraftingRecipe
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public FertilizerRecipe()
 *    Logika Implementasi:
 *      super(
 *              "recipe_fertilizer",
 *              "Craft Fertilizer",
 *              GameConfig.ENERGY_COST_CRAFTING,
 *              List.of(new ItemStack(GameConfig.CROP_TOMATO, 2)),
 *              new ItemStack(GameConfig.ITEM_FERTILIZER, 1)
 *      );
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

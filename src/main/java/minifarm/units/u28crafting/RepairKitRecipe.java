package minifarm.units.u28crafting;

import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import java.util.List;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): RepairKitRecipe
 * ================================================================================================
 * Modul Unit: U28CRAFTING
 * 
 * Deskripsi Kelas:
 * Resep Alat Perbaikan (Repair Kit Recipe):
 * Bahan: 1 unit wheat + 1 unit corn -> Output: 1 repair_kit. Biaya: 2 energi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class RepairKitRecipe
 * - Superclass (Pewarisan) : extends AbstractCraftingRecipe
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public RepairKitRecipe()
 *    Logika Implementasi:
 *      super(
 *              "recipe_repair_kit",
 *              "Craft Repair Kit",
 *              GameConfig.ENERGY_COST_CRAFTING,
 *              List.of(
 *                      new ItemStack(GameConfig.CROP_WHEAT, 1),
 *                      new ItemStack(GameConfig.CROP_CORN, 1)
 *              ),
 *              new ItemStack("repair_kit", 1)
 *      );
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

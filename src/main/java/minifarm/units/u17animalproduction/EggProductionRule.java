package minifarm.units.u17animalproduction;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import java.util.Optional;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): EggProductionRule
 * ================================================================================================
 * Modul Unit: U17ANIMALPRODUCTION
 * 
 * Deskripsi Kelas:
 * Aturan produksi telur ayam (Egg Production Rule).
 * Menghasilkan 1 telur jika ayam sudah diberi makan (fed = true) dan sehat (health > 50).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class EggProductionRule
 * - Superclass (Pewarisan) : extends AbstractAnimalProductionRule
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public EggProductionRule()
 *    Logika Implementasi:
 *      super("chicken");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public Optional<ItemStack> calculateDailyProduction(AnimalSnapshot animal)
 *    Logika Implementasi:
 *      if (animal != null && animal.isFed() && animal.getHealth() > 50) {
 *          return Optional.of(new ItemStack(GameConfig.ITEM_EGG, 1));
 *      }
 *      return Optional.empty();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u17animalproduction;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.ItemStack;
import java.util.Optional;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): WoolProductionRule
 * ================================================================================================
 * Modul Unit: U17ANIMALPRODUCTION
 * 
 * Deskripsi Kelas:
 * Aturan produksi wol domba (Wool Production Rule).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class WoolProductionRule
 * - Superclass (Pewarisan) : extends AbstractAnimalProductionRule
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public WoolProductionRule()
 *    Logika Implementasi:
 *      super("sheep");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public Optional<ItemStack> calculateDailyProduction(AnimalSnapshot animal)
 *    Logika Implementasi:
 *      if (animal != null && animal.isFed() && animal.getHealth() > 50) {
 *          return Optional.of(new ItemStack("wool", 1));
 *      }
 *      return Optional.empty();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

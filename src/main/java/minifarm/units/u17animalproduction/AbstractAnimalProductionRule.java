package minifarm.units.u17animalproduction;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.ItemStack;
import java.util.Optional;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractAnimalProductionRule
 * ================================================================================================
 * Modul Unit: U17ANIMALPRODUCTION
 * 
 * Deskripsi Kelas:
 * Kelas abstrak aturan produksi harian hewan (Polimorfik).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractAnimalProductionRule
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String species;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractAnimalProductionRule(String species)
 *    Logika Implementasi:
 *      this.species = species.toLowerCase();
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getSpecies()
 *    Logika Implementasi:
 *      return species;
 * 
 * 2. public abstract Optional<ItemStack> calculateDailyProduction(AnimalSnapshot animal)
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

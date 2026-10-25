package minifarm.units.u18housing;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): Coop
 * ================================================================================================
 * Modul Unit: U18HOUSING
 * 
 * Deskripsi Kelas:
 * Kandang Ayam (Coop). Kapasitas awal: 4 ayam.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class Coop
 * - Superclass (Pewarisan) : extends AbstractAnimalHousing
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public Coop()
 *    Logika Implementasi:
 *      super("coop", "Chicken Coop", GameConfig.INITIAL_COOP_CAPACITY);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean supportsSpecies(String species)
 *    Logika Implementasi:
 *      return "chicken".equalsIgnoreCase(species);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u15animal;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): Chicken
 * ================================================================================================
 * Modul Unit: U15ANIMAL
 * 
 * Deskripsi Kelas:
 * Model Ayam (Chicken): makan animal_feed, menghasilkan egg.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class Chicken
 * - Superclass (Pewarisan) : extends AbstractFarmAnimal
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public Chicken(String id, String name)
 *    Logika Implementasi:
 *      super(id, "chicken", name);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public String getRequiredFeedItemId()
 *    Logika Implementasi:
 *      return GameConfig.ITEM_ANIMAL_FEED;
 * 
 * 2. @Override public String getProducedItemId()
 *    Logika Implementasi:
 *      return GameConfig.ITEM_EGG;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

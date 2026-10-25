package minifarm.units.u03seed;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): WheatSeed
 * ================================================================================================
 * Modul Unit: U03SEED
 * 
 * Deskripsi Kelas:
 * Implementasi konkret benih gandum (Wheat Seed).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class WheatSeed
 * - Superclass (Pewarisan) : extends AbstractSeedItem
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public WheatSeed()
 *    Logika Implementasi:
 *      super(GameConfig.SEED_WHEAT, "Wheat Seed", GameConfig.WHEAT_SEED_PRICE, GameConfig.CROP_WHEAT);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getDaysToMature()
 *    Logika Implementasi:
 *      return GameConfig.WHEAT_GROWTH_DAYS;
 * 
 * 2. @Override public int getBaseYield()
 *    Logika Implementasi:
 *      return GameConfig.WHEAT_BASE_YIELD;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

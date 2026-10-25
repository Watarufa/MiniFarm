package minifarm.units.u03seed;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CornSeed
 * ================================================================================================
 * Modul Unit: U03SEED
 * 
 * Deskripsi Kelas:
 * Implementasi konkret benih jagung (Corn Seed).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CornSeed
 * - Superclass (Pewarisan) : extends AbstractSeedItem
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public CornSeed()
 *    Logika Implementasi:
 *      super(GameConfig.SEED_CORN, "Corn Seed", GameConfig.CORN_SEED_PRICE, GameConfig.CROP_CORN);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getDaysToMature()
 *    Logika Implementasi:
 *      return GameConfig.CORN_GROWTH_DAYS;
 * 
 * 2. @Override public int getBaseYield()
 *    Logika Implementasi:
 *      return GameConfig.CORN_BASE_YIELD;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

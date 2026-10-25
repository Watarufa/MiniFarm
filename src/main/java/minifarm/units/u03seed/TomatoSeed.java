package minifarm.units.u03seed;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): TomatoSeed
 * ================================================================================================
 * Modul Unit: U03SEED
 * 
 * Deskripsi Kelas:
 * Implementasi konkret benih tomat (Tomato Seed).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class TomatoSeed
 * - Superclass (Pewarisan) : extends AbstractSeedItem
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public TomatoSeed()
 *    Logika Implementasi:
 *      super(GameConfig.SEED_TOMATO, "Tomato Seed", GameConfig.TOMATO_SEED_PRICE, GameConfig.CROP_TOMATO);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getDaysToMature()
 *    Logika Implementasi:
 *      return GameConfig.TOMATO_GROWTH_DAYS;
 * 
 * 2. @Override public int getBaseYield()
 *    Logika Implementasi:
 *      return GameConfig.TOMATO_BASE_YIELD;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

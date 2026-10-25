package minifarm.units.u02crop;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): TomatoCrop
 * ================================================================================================
 * Modul Unit: U02CROP
 * 
 * Deskripsi Kelas:
 * Model tanaman tomat (Tomato).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class TomatoCrop
 * - Superclass (Pewarisan) : extends AbstractCrop
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public TomatoCrop(String cropId)
 *    Logika Implementasi:
 *      super(cropId, GameConfig.CROP_TOMATO);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int daysToMature()
 *    Logika Implementasi:
 *      return GameConfig.TOMATO_GROWTH_DAYS;
 * 
 * 2. @Override public int baseYield()
 *    Logika Implementasi:
 *      return GameConfig.TOMATO_BASE_YIELD;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u19storage;

import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): BarnStorage
 * ================================================================================================
 * Modul Unit: U19STORAGE
 * 
 * Deskripsi Kelas:
 * Gudang Umum (Barn Storage): menerima semua jenis item pertanian.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class BarnStorage
 * - Superclass (Pewarisan) : extends AbstractFarmStorage
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public BarnStorage()
 *    Logika Implementasi:
 *      super("barn_storage", "Barn Storage", GameConfig.INITIAL_STORAGE_SLOT_CAPACITY);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean acceptsItem(String itemId)
 *    Logika Implementasi:
 *      return itemId != null; // Menerima semua item
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

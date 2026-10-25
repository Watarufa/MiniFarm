package minifarm.units.u05soil;

import minifarm.core.api.*;
import minifarm.core.config.GameConfig;
import java.util.HashMap;
import java.util.Map;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SoilService
 * ================================================================================================
 * Modul Unit: U05SOIL
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U05: Profil Tanah dan Pupuk.
 * Mengimplementasikan SoilPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SoilService
 * - Interface yang Diimplementasikan: implements SoilPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<Integer, AbstractSoilProfile> profiles = new HashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SoilService(int initialPlots)
 *    Logika Implementasi:
 *      for (int i = 0; i < initialPlots; i++) {
 *          profiles.put(i, new LoamySoilProfile(GameConfig.INITIAL_SOIL_FERTILITY));
 *      }
 * 
 * 2. Constructor: public SoilService()
 *    Logika Implementasi:
 *      this(GameConfig.INITIAL_PLOT_COUNT);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setPlotProfile(int plotIndex, AbstractSoilProfile profile)
 *    Logika Implementasi:
 *      if (profile != null) {
 *          profiles.put(plotIndex, profile);
 *      }
 * 
 * 2. @Override public SoilSnapshot getSoilSnapshot(int plotIndex)
 *    Logika Implementasi:
 *      AbstractSoilProfile profile = profiles.get(plotIndex);
 *      if (profile == null) {
 *          return new SoilSnapshot(0, false, "Unknown");
 *      }
 *      return profile.toSnapshot(false);
 * 
 * 3. @Override public OperationResult<Void> applyFertilizer(int plotIndex, int boostAmount)
 *    Logika Implementasi:
 *      // TODO U05: Validasi plotIndex, tambahkan kesuburan menggunakan boostFertility, maksimal 100
 *      AbstractSoilProfile profile = profiles.get(plotIndex);
 *      if (profile == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Profil tanah petak tidak ditemukan: " + plotIndex);
 *      }
 *      if (profile.getFertility() >= 100) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Kesuburan petak sudah maksimal (100)");
 *      }
 *      profile.boostFertility(boostAmount > 0 ? boostAmount : profile.getFertilizerEffect());
 *      return OperationResult.ok();
 * 
 * 4. public OperationResult<Void> applyFertilizerFromInventory(int plotIndex, InventoryPort inventoryPort)
 *    Keterangan / Tujuan: Menerapkan pupuk dengan memotong item fertilizer dari inventaris pemain secara atomik.
 *    Logika Implementasi:
 *      // TODO U05:
 *      // 1. Cek apakah inventory memiliki 1x "fertilizer" (inventoryPort.hasItem).
 *      // 2. Cek apakah plot valid dan belum 100.
 *      // 3. Jika valid, potong item dari inventory (inventoryPort.removeItem) dan naikkan kesuburan.
 *      // 4. Pastikan jika penambahan kesuburan gagal, item tidak terpotong!
 *      if (inventoryPort == null || !inventoryPort.hasItem(GameConfig.ITEM_FERTILIZER, 1)) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Tidak memiliki pupuk (fertilizer)");
 *      }
 *      AbstractSoilProfile profile = profiles.get(plotIndex);
 *      if (profile == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Petak tidak ditemukan");
 *      }
 *      if (profile.getFertility() >= 100) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Kesuburan tanah sudah maksimal");
 *      }
 *      
 *      OperationResult<Void> removeRes = inventoryPort.removeItem(GameConfig.ITEM_FERTILIZER, 1);
 *      if (removeRes.isFailure()) {
 *          return removeRes;
 *      }
 *      
 *      profile.boostFertility(profile.getFertilizerEffect());
 *      return OperationResult.ok();
 * 
 * 5. @Override public void applyFertilityDecay(int plotIndex)
 *    Logika Implementasi:
 *      AbstractSoilProfile profile = profiles.get(plotIndex);
 *      if (profile != null) {
 *          profile.decayFertility();
 *      }
 * 
 * 6. public boolean qualifiesForYieldBonus(int plotIndex)
 *    Keterangan / Tujuan: Memeriksa apakah tanah berhak mendapatkan bonus panen (kesuburan >= 80).
 *    Logika Implementasi:
 *      AbstractSoilProfile profile = profiles.get(plotIndex);
 *      return profile != null && profile.getFertility() >= GameConfig.HIGH_FERTILITY_BONUS_THRESHOLD;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u33upgrade;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.StorageCapacityPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): StorageExpansionUpgrade
 * ================================================================================================
 * Modul Unit: U33UPGRADE
 * 
 * Deskripsi Kelas:
 * Upgrade kapasitas gudang penyimpanan (+10 slot). Biaya: 150 koin.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class StorageExpansionUpgrade
 * - Superclass (Pewarisan) : extends AbstractFarmUpgrade
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final StorageCapacityPort storagePort;
 * 2. private int upgradeLevel = 0;
 * 3. public static final int MAX_STORAGE_UPGRADES = 3;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public StorageExpansionUpgrade(StorageCapacityPort storagePort)
 *    Logika Implementasi:
 *      super("upgrade_storage", "Storage Expansion (+10 slots)");
 *      this.storagePort = storagePort;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculateCost()
 *    Logika Implementasi:
 *      return 150L;
 * 
 * 2. @Override public boolean isMaxLevel()
 *    Logika Implementasi:
 *      return upgradeLevel >= MAX_STORAGE_UPGRADES;
 * 
 * 3. @Override public OperationResult<Void> apply()
 *    Logika Implementasi:
 *      if (isMaxLevel()) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Kapasitas storage sudah mencapai batas upgrade");
 *      }
 *      OperationResult<Void> res = storagePort.expandStorageCapacity(10);
 *      if (res.isSuccess()) {
 *          upgradeLevel++;
 *      }
 *      return res;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u33upgrade;

import minifarm.core.api.HousingCapacityPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): HousingExpansionUpgrade
 * ================================================================================================
 * Modul Unit: U33UPGRADE
 * 
 * Deskripsi Kelas:
 * Upgrade kapasitas kandang coop (+2 kapasitas). Biaya: 150 koin.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class HousingExpansionUpgrade
 * - Superclass (Pewarisan) : extends AbstractFarmUpgrade
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final HousingCapacityPort housingPort;
 * 2. private int upgradeLevel = 0;
 * 3. public static final int MAX_HOUSING_UPGRADES = 2;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public HousingExpansionUpgrade(HousingCapacityPort housingPort)
 *    Logika Implementasi:
 *      super("upgrade_housing", "Coop Expansion (+2 Capacity)");
 *      this.housingPort = housingPort;
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
 *      return upgradeLevel >= MAX_HOUSING_UPGRADES;
 * 
 * 3. @Override public OperationResult<Void> apply()
 *    Logika Implementasi:
 *      if (isMaxLevel()) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Kapasitas kandang sudah maksimal");
 *      }
 *      OperationResult<Void> res = housingPort.expandCapacity("coop", 2);
 *      if (res.isSuccess()) {
 *          upgradeLevel++;
 *      }
 *      return res;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

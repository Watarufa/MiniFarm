package minifarm.units.u33upgrade;

import minifarm.core.api.OperationResult;
import minifarm.core.api.WalletPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractFarmUpgrade
 * ================================================================================================
 * Modul Unit: U33UPGRADE
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar peningkatan kapasitas dan fasilitas pertanian (Polimorfik).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractFarmUpgrade
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String upgradeId;
 * 2. private final String upgradeName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractFarmUpgrade(String upgradeId, String upgradeName)
 *    Logika Implementasi:
 *      this.upgradeId = upgradeId;
 *      this.upgradeName = upgradeName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getUpgradeId()
 *    Logika Implementasi:
 *      return upgradeId;
 * 
 * 2. public String getUpgradeName()
 *    Logika Implementasi:
 *      return upgradeName;
 * 
 * 3. public abstract long calculateCost()
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 4. public abstract boolean isMaxLevel()
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 5. public abstract OperationResult<Void> apply()
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

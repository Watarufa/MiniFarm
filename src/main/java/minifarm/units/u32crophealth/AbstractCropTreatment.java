package minifarm.units.u32crophealth;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractCropTreatment
 * ================================================================================================
 * Modul Unit: U32CROPHEALTH
 * 
 * Deskripsi Kelas:
 * Kelas abstrak tindakan pengobatan dan pemulihan kesehatan tanaman (Polimorfik).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractCropTreatment
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String treatmentName;
 * 2. private final String requiredItem;
 * 3. private final int healAmount;
 * 4. private final int energyCost;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractCropTreatment(String treatmentName, String requiredItem, int healAmount, int energyCost)
 *    Logika Implementasi:
 *      this.treatmentName = treatmentName;
 *      this.requiredItem = requiredItem;
 *      this.healAmount = healAmount;
 *      this.energyCost = energyCost > 0 ? energyCost : GameConfig.ENERGY_COST_CROP_TREATMENT;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getTreatmentName()
 *    Logika Implementasi:
 *      return treatmentName;
 * 
 * 2. public String getRequiredItem()
 *    Logika Implementasi:
 *      return requiredItem;
 * 
 * 3. public int getHealAmount()
 *    Logika Implementasi:
 *      return healAmount;
 * 
 * 4. public int getEnergyCost()
 *    Logika Implementasi:
 *      return energyCost;
 * 
 * 5. public OperationResult<Void> validateAndConsume(InventoryPort inventory, EnergyPort energy)
 *    Logika Implementasi:
 *      if (energy.getCurrentEnergy() < energyCost) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak cukup untuk treatment");
 *      }
 *      if (!inventory.hasItem(requiredItem, 1)) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Item obat tidak ada: " + requiredItem);
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

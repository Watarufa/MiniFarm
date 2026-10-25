package minifarm.units.u08harvest;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ToolEffectPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ToolAssistedHarvestStrategy
 * ================================================================================================
 * Modul Unit: U08HARVEST
 * 
 * Deskripsi Kelas:
 * Pemanenan berbantuan sabit/scythe: biaya 3 energi, bonus hasil jika alat berlevel tinggi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ToolAssistedHarvestStrategy
 * - Superclass (Pewarisan) : extends AbstractHarvestStrategy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ToolAssistedHarvestStrategy()
 *    Logika Implementasi:
 *      super("Tool-Assisted Harvest", 3);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int calculateFinalYield(int baseYield, boolean hasSoilBonus, ToolEffectPort toolPort)
 *    Logika Implementasi:
 *      int bonus = hasSoilBonus ? 1 : 0;
 *      if (toolPort != null && toolPort.getToolLevel("scythe") >= 2) {
 *          bonus += 1; // Bonus level alat
 *      }
 *      return baseYield + bonus;
 * 
 * 2. @Override public OperationResult<Void> validateRequirements(EnergyPort energyPort, ToolEffectPort toolPort)
 *    Logika Implementasi:
 *      if (toolPort == null || !toolPort.canUseTool("scythe")) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Scythe tidak tersedia atau rusak");
 *      }
 *      if (energyPort.getCurrentEnergy() < getEnergyCost()) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi untuk panen alat");
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

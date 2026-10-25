package minifarm.units.u08harvest;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ToolEffectPort;
import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ManualHarvestStrategy
 * ================================================================================================
 * Modul Unit: U08HARVEST
 * 
 * Deskripsi Kelas:
 * Pemanenan manual dengan tangan kosong: biaya 5 energi, tanpa bonus alat.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ManualHarvestStrategy
 * - Superclass (Pewarisan) : extends AbstractHarvestStrategy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ManualHarvestStrategy()
 *    Logika Implementasi:
 *      super("Manual Harvest", GameConfig.ENERGY_COST_HARVEST);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int calculateFinalYield(int baseYield, boolean hasSoilBonus, ToolEffectPort toolPort)
 *    Logika Implementasi:
 *      return baseYield + (hasSoilBonus ? 1 : 0);
 * 
 * 2. @Override public OperationResult<Void> validateRequirements(EnergyPort energyPort, ToolEffectPort toolPort)
 *    Logika Implementasi:
 *      if (energyPort.getCurrentEnergy() < getEnergyCost()) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi untuk panen manual");
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

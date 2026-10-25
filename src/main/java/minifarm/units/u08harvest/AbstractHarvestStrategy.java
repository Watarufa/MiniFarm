package minifarm.units.u08harvest;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ToolEffectPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractHarvestStrategy
 * ================================================================================================
 * Modul Unit: U08HARVEST
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar strategi pemanenan tanaman.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractHarvestStrategy
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String strategyName;
 * 2. private final int energyCost;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractHarvestStrategy(String strategyName, int energyCost)
 *    Logika Implementasi:
 *      this.strategyName = strategyName;
 *      this.energyCost = energyCost;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getStrategyName()
 *    Logika Implementasi:
 *      return strategyName;
 * 
 * 2. public int getEnergyCost()
 *    Logika Implementasi:
 *      return energyCost;
 * 
 * 3. public abstract int calculateFinalYield(int baseYield, boolean hasSoilBonus, ToolEffectPort toolPort)
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 4. public abstract OperationResult<Void> validateRequirements(EnergyPort energyPort, ToolEffectPort toolPort)
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

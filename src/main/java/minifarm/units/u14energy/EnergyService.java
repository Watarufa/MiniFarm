package minifarm.units.u14energy;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): EnergyService
 * ================================================================================================
 * Modul Unit: U14ENERGY
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U14: Energi dan Biaya Aksi.
 * Mengimplementasikan EnergyPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class EnergyService
 * - Interface yang Diimplementasikan: implements EnergyPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private int currentEnergy;
 * 2. private final int maxEnergy;
 * 3. private AbstractEnergyCostPolicy policy;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public EnergyService(int initialEnergy, int maxEnergy, AbstractEnergyCostPolicy policy)
 *    Logika Implementasi:
 *      this.maxEnergy = maxEnergy > 0 ? maxEnergy : GameConfig.MAX_ENERGY;
 *      this.currentEnergy = Math.max(0, Math.min(this.maxEnergy, initialEnergy));
 *      this.policy = policy != null ? policy : new FixedCostPolicy();
 * 
 * 2. Constructor: public EnergyService()
 *    Logika Implementasi:
 *      this(GameConfig.INITIAL_ENERGY, GameConfig.MAX_ENERGY, new FixedCostPolicy());
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setPolicy(AbstractEnergyCostPolicy policy)
 *    Logika Implementasi:
 *      if (policy != null) this.policy = policy;
 * 
 * 2. @Override public int getCurrentEnergy()
 *    Logika Implementasi:
 *      return currentEnergy;
 * 
 * 3. @Override public int getMaxEnergy()
 *    Logika Implementasi:
 *      return maxEnergy;
 * 
 * 4. public int calculateActionCost(int baseCost, String actionType)
 *    Logika Implementasi:
 *      return policy.calculateCost(baseCost, actionType);
 * 
 * 5. @Override public OperationResult<Void> consumeEnergy(int amount)
 *    Logika Implementasi:
 *      // TODO U14:
 *      // 1. Validasi amount (tidak boleh negatif).
 *      // 2. Cek apakah currentEnergy >= amount.
 *      // 3. Jika kurang, kembalikan INSUFFICIENT_ENERGY tanpa mengurangi energi (atomik).
 *      // 4. Jika cukup, kurangi currentEnergy dan kembalikan OperationResult.ok().
 *      if (amount < 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Biaya energi tidak boleh negatif: " + amount);
 *      }
 *      if (currentEnergy < amount) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi (Tersisa: " + currentEnergy + ", Butuh: " + amount + ")");
 *      }
 *      
 *      this.currentEnergy -= amount;
 *      return OperationResult.ok();
 * 
 * 6. @Override public void restoreEnergy(int amount)
 *    Logika Implementasi:
 *      if (amount > 0) {
 *          this.currentEnergy = Math.min(maxEnergy, currentEnergy + amount);
 *      }
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

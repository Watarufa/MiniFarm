package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WaterablePlotPort;
import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SinglePlotWatering
 * ================================================================================================
 * Modul Unit: U04WATERING
 * 
 * Deskripsi Kelas:
 * Metode penyiraman satu petak (Single Plot).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SinglePlotWatering
 * - Superclass (Pewarisan) : extends AbstractWateringMethod
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SinglePlotWatering()
 *    Logika Implementasi:
 *      super("Single Plot", GameConfig.ENERGY_COST_WATER);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> executeWatering(int targetPlotIndex, WaterablePlotPort plotPort, EnergyPort energyPort)
 *    Logika Implementasi:
 *      // TODO U04:
 *      // 1. Periksa apakah petak target sudah lembap (plotPort.isPlotMoist). Jika sudah, kembalikan ALREADY_COMPLETED.
 *      // 2. Periksa apakah energi mencukupi (validateAndConsumeEnergy).
 *      // 3. Siram petak melalui plotPort.waterPlot(targetPlotIndex).
 *      // 4. Pastikan atomik: jika penyiraman gagal, energi jangan dipotong!
 *      if (plotPort.isPlotMoist(targetPlotIndex)) {
 *          return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Petak sudah lembap (tersiram air hujan atau sudah disiram hari ini)");
 *      }
 *      if (energyPort.getCurrentEnergy() < getEnergyCost()) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi untuk menyiram");
 *      }
 *      
 *      OperationResult<Void> waterRes = plotPort.waterPlot(targetPlotIndex);
 *      if (waterRes.isFailure()) {
 *          return waterRes;
 *      }
 *      
 *      return energyPort.consumeEnergy(getEnergyCost());
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

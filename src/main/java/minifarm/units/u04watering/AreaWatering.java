package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WaterablePlotPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AreaWatering
 * ================================================================================================
 * Modul Unit: U04WATERING
 * 
 * Deskripsi Kelas:
 * Metode penyiraman area (Area Watering).
 * Menyiram petak target dan petak tetangganya sekaligus.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AreaWatering
 * - Superclass (Pewarisan) : extends AbstractWateringMethod
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AreaWatering()
 *    Logika Implementasi:
 *      super("Area Watering", 12);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> executeWatering(int targetPlotIndex, WaterablePlotPort plotPort, EnergyPort energyPort)
 *    Logika Implementasi:
 *      // TODO U04: Implementasi penyiraman area dengan konsumsi energi 12
 *      if (energyPort.getCurrentEnergy() < getEnergyCost()) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak cukup untuk area watering");
 *      }
 *      OperationResult<Void> res = plotPort.waterPlot(targetPlotIndex);
 *      if (res.isFailure() && res.getCode() != ResultCode.ALREADY_COMPLETED) {
 *          return res;
 *      }
 *      // Coba siram petak tetangga jika valid
 *      plotPort.waterPlot(targetPlotIndex + 1);
 *      
 *      return energyPort.consumeEnergy(getEnergyCost());
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

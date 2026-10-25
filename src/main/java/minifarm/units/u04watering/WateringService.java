package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ToolEffectPort;
import minifarm.core.api.WaterablePlotPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): WateringService
 * ================================================================================================
 * Modul Unit: U04WATERING
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U04: Aksi Penyiraman.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class WateringService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private WateringMethod defaultMethod;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public WateringService(WateringMethod defaultMethod)
 *    Logika Implementasi:
 *      this.defaultMethod = defaultMethod != null ? defaultMethod : new SinglePlotWatering();
 * 
 * 2. Constructor: public WateringService()
 *    Logika Implementasi:
 *      this(new SinglePlotWatering());
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setMethod(WateringMethod method)
 *    Logika Implementasi:
 *      if (method != null) {
 *          this.defaultMethod = method;
 *      }
 * 
 * 2. public OperationResult<Void> waterPlot(int plotIndex, WaterablePlotPort plotPort, EnergyPort energyPort, ToolEffectPort toolPort)
 *    Keterangan / Tujuan: Melakukan penyiraman pada petak tertentu dengan alat watering_can dan energi.
 *    Logika Implementasi:
 *      // TODO U04:
 *      // 1. Validasi tool watering_can (apakah toolPort.canUseTool("watering_can") == true).
 *      // 2. Jika tool rusak, kembalikan ResultCode.INVALID_STATE.
 *      // 3. Eksekusi metode penyiraman defaultMethod.executeWatering(...).
 *      // 4. Jika penyiraman berhasil, kurangi durability tool (toolPort.useTool("watering_can")).
 *      if (toolPort != null && !toolPort.canUseTool("watering_can")) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Watering can rusak / durability habis");
 *      }
 *      
 *      OperationResult<Void> result = defaultMethod.executeWatering(plotIndex, plotPort, energyPort);
 *      if (result.isSuccess() && toolPort != null) {
 *          toolPort.useTool("watering_can");
 *      }
 *      return result;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

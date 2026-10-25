package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.WaterablePlotPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): WateringMethod
 * ================================================================================================
 * Modul Unit: U04WATERING
 * 
 * Deskripsi Kelas:
 * Kontrak polimorfik untuk metode penyiraman.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public interface WateringMethod
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. String getMethodName()
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 2. int getEnergyCost()
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 3. OperationResult<Void> executeWatering(int targetPlotIndex, WaterablePlotPort plotPort, EnergyPort energyPort)
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WaterablePlotPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractWateringMethod
 * ================================================================================================
 * Modul Unit: U04WATERING
 * 
 * Deskripsi Kelas:
 * Kelas dasar abstrak untuk metode penyiraman.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractWateringMethod
 * - Interface yang Diimplementasikan: implements WateringMethod
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String methodName;
 * 2. private final int energyCost;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractWateringMethod(String methodName, int energyCost)
 *    Logika Implementasi:
 *      if (energyCost < 0) {
 *          throw new IllegalArgumentException("Biaya energi tidak boleh negatif");
 *      }
 *      this.methodName = methodName;
 *      this.energyCost = energyCost;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public String getMethodName()
 *    Logika Implementasi:
 *      return methodName;
 * 
 * 2. @Override public int getEnergyCost()
 *    Logika Implementasi:
 *      return energyCost;
 * 
 * 3. protected OperationResult<Void> validateAndConsumeEnergy(EnergyPort energyPort)
 *    Logika Implementasi:
 *      if (energyPort.getCurrentEnergy() < energyCost) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak cukup untuk menyiram");
 *      }
 *      return energyPort.consumeEnergy(energyCost);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

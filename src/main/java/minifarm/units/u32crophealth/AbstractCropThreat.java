package minifarm.units.u32crophealth;

import minifarm.core.api.CropSlotPort;
import minifarm.core.api.CropSnapshot;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.Optional;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractCropThreat
 * ================================================================================================
 * Modul Unit: U32CROPHEALTH
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar ancaman kesehatan tanaman (Hama atau Penyakit).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractCropThreat
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String threatName;
 * 2. private final int damageAmount;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractCropThreat(String threatName, int damageAmount)
 *    Logika Implementasi:
 *      this.threatName = threatName;
 *      this.damageAmount = damageAmount;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getThreatName()
 *    Logika Implementasi:
 *      return threatName;
 * 
 * 2. public int getDamageAmount()
 *    Logika Implementasi:
 *      return damageAmount;
 * 
 * 3. public OperationResult<Void> applyToPlot(int plotIndex, CropSlotPort slotPort)
 *    Logika Implementasi:
 *      Optional<CropSnapshot> cropOpt = slotPort.getCropSnapshot(plotIndex);
 *      if (cropOpt.isEmpty()) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Tidak ada tanaman di petak #" + plotIndex);
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

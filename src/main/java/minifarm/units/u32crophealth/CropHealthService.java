package minifarm.units.u32crophealth;

import minifarm.core.api.*;
import minifarm.core.events.CropDestroyed;
import minifarm.core.events.EventBus;
import java.util.HashMap;
import java.util.Map;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CropHealthService
 * ================================================================================================
 * Modul Unit: U32CROPHEALTH
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U32: Ancaman Tanaman dan Perawatan Kesehatan.
 * Mengimplementasikan CropHealthPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CropHealthService
 * - Interface yang Diimplementasikan: implements CropHealthPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<Integer, Integer> cropHealthMap = new HashMap<>();
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public CropHealthService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 * 
 * 2. Constructor: public CropHealthService()
 *    Logika Implementasi:
 *      this(null);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getHealth(int plotIndex)
 *    Logika Implementasi:
 *      return cropHealthMap.getOrDefault(plotIndex, 100);
 * 
 * 2. @Override public OperationResult<Void> damageCrop(int plotIndex, int damageAmount, String reason)
 *    Logika Implementasi:
 *      // TODO U32:
 *      // Kurangi kesehatan tanaman pada petak plotIndex.
 *      // Jika HP mencapai 0 atau kurang:
 *      // - Set HP = 0
 *      // - Publikasikan event CropDestroyed
 *      if (damageAmount < 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Damage tidak boleh negatif");
 *      }
 *      int cur = getHealth(plotIndex);
 *      int next = Math.max(0, cur - damageAmount);
 *      cropHealthMap.put(plotIndex, next);
 *      
 *      if (next <= 0 && eventBus != null) {
 *          eventBus.publish(new CropDestroyed(1, plotIndex, reason));
 *      }
 *      
 *      return OperationResult.ok();
 * 
 * 3. @Override public OperationResult<Void> restoreHealth(int plotIndex, int healAmount)
 *    Logika Implementasi:
 *      if (healAmount < 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Heal tidak boleh negatif");
 *      }
 *      int cur = getHealth(plotIndex);
 *      if (cur <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Tanaman sudah mati, tidak bisa diobati");
 *      }
 *      cropHealthMap.put(plotIndex, Math.min(100, cur + healAmount));
 *      return OperationResult.ok();
 * 
 * 4. public OperationResult<Void> applyTreatment( int plotIndex, AbstractCropTreatment treatment, InventoryPort inventoryPort, EnergyPort energyPort )
 *    Logika Implementasi:
 *      // TODO U32: Validasi bahan dan energi treatment, potong bahan dan energi, lalu pulihkan kesehatan tanaman
 *      if (treatment == null) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Treatment null");
 *      }
 *      OperationResult<Void> valRes = treatment.validateAndConsume(inventoryPort, energyPort);
 *      if (valRes.isFailure()) {
 *          return valRes;
 *      }
 *      
 *      OperationResult<Void> healRes = restoreHealth(plotIndex, treatment.getHealAmount());
 *      if (healRes.isFailure()) {
 *          return healRes;
 *      }
 *      
 *      inventoryPort.removeItem(treatment.getRequiredItem(), 1);
 *      energyPort.consumeEnergy(treatment.getEnergyCost());
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

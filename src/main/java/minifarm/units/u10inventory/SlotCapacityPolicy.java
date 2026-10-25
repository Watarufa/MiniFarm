package minifarm.units.u10inventory;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.Map;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SlotCapacityPolicy
 * ================================================================================================
 * Modul Unit: U10INVENTORY
 * 
 * Deskripsi Kelas:
 * Kebijakan standar inventaris berbasis kapasitas slot maksimum.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SlotCapacityPolicy
 * - Superclass (Pewarisan) : extends AbstractInventoryPolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SlotCapacityPolicy()
 *    Logika Implementasi:
 *      super("SlotCapacityPolicy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> validateCanAdd(String itemId, int quantity, Map<String, Integer> currentSlots, int maxCapacity)
 *    Logika Implementasi:
 *      if (itemId == null || itemId.trim().isEmpty() || quantity <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item atau kuantitas tidak valid");
 *      }
 *      String id = itemId.trim().toLowerCase();
 *      if (!currentSlots.containsKey(id) && currentSlots.size() >= maxCapacity) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Slot inventaris penuh (" + maxCapacity + " slot)");
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

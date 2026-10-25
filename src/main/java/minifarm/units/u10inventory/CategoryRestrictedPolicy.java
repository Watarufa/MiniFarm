package minifarm.units.u10inventory;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.Map;
import java.util.Set;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CategoryRestrictedPolicy
 * ================================================================================================
 * Modul Unit: U10INVENTORY
 * 
 * Deskripsi Kelas:
 * Kebijakan inventaris khusus yang membatasi jenis item yang diizinkan masuk.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CategoryRestrictedPolicy
 * - Superclass (Pewarisan) : extends AbstractInventoryPolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Set<String> allowedPrefixes;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public CategoryRestrictedPolicy(Set<String> allowedPrefixes)
 *    Logika Implementasi:
 *      super("CategoryRestrictedPolicy");
 *      this.allowedPrefixes = allowedPrefixes != null ? allowedPrefixes : Set.of();
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> validateCanAdd(String itemId, int quantity, Map<String, Integer> currentSlots, int maxCapacity)
 *    Logika Implementasi:
 *      if (itemId == null || quantity <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item tidak valid");
 *      }
 *      boolean match = allowedPrefixes.stream().anyMatch(itemId.toLowerCase()::startsWith);
 *      if (!match) {
 *          return OperationResult.failed(ResultCode.NOT_ALLOWED, "Kategori item tidak diizinkan dalam inventaris khusus ini");
 *      }
 *      if (!currentSlots.containsKey(itemId.toLowerCase()) && currentSlots.size() >= maxCapacity) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Slot penuh");
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

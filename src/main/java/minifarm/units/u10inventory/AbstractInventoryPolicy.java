package minifarm.units.u10inventory;

import minifarm.core.api.OperationResult;
import java.util.Map;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractInventoryPolicy
 * ================================================================================================
 * Modul Unit: U10INVENTORY
 * 
 * Deskripsi Kelas:
 * Kontrak kebijakan penyimpanan dalam inventaris (Polimorfik).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractInventoryPolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String policyName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractInventoryPolicy(String policyName)
 *    Logika Implementasi:
 *      this.policyName = policyName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getPolicyName()
 *    Logika Implementasi:
 *      return policyName;
 * 
 * 2. public abstract OperationResult<Void> validateCanAdd(String itemId, int quantity, Map<String, Integer> currentSlots, int maxCapacity)
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

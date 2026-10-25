package minifarm.units.u23sale;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): BatchSalePolicy
 * ================================================================================================
 * Modul Unit: U23SALE
 * 
 * Deskripsi Kelas:
 * Kebijakan penjualan partai (Batch): kuantitas minimal 5 unit.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class BatchSalePolicy
 * - Superclass (Pewarisan) : extends AbstractSalePolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public BatchSalePolicy()
 *    Logika Implementasi:
 *      super("BatchSalePolicy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> validateSale(String itemId, int quantity, boolean canSell)
 *    Logika Implementasi:
 *      if (!canSell) {
 *          return OperationResult.failed(ResultCode.NOT_ALLOWED, "Item ini tidak dapat dijual");
 *      }
 *      if (quantity < 5) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Penjualan batch membutuhkan minimal 5 unit");
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u23sale;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SingleSalePolicy
 * ================================================================================================
 * Modul Unit: U23SALE
 * 
 * Deskripsi Kelas:
 * Kebijakan penjualan tunggal: minimal 1 unit.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SingleSalePolicy
 * - Superclass (Pewarisan) : extends AbstractSalePolicy
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SingleSalePolicy()
 *    Logika Implementasi:
 *      super("SingleSalePolicy");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> validateSale(String itemId, int quantity, boolean canSell)
 *    Logika Implementasi:
 *      if (!canSell) {
 *          return OperationResult.failed(ResultCode.NOT_ALLOWED, "Item ini tidak dapat dijual");
 *      }
 *      if (quantity <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah penjualan harus lebih dari 0");
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

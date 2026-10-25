package minifarm.units.u24wallet;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): DebitTransaction
 * ================================================================================================
 * Modul Unit: U24WALLET
 * 
 * Deskripsi Kelas:
 * Transaksi pemotongan saldo (Debit). Menolak saldo negatif!
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class DebitTransaction
 * - Superclass (Pewarisan) : extends AbstractWalletTransaction
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public DebitTransaction(String id, long amount, String desc)
 *    Logika Implementasi:
 *      super(id, amount, desc);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Long> apply(long currentBalance)
 *    Logika Implementasi:
 *      if (currentBalance < getAmount()) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_FUNDS, "Saldo tidak cukup untuk debit: " + getAmount());
 *      }
 *      return OperationResult.ok(currentBalance - getAmount());
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

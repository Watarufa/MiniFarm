package minifarm.units.u24wallet;

import minifarm.core.api.OperationResult;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CreditTransaction
 * ================================================================================================
 * Modul Unit: U24WALLET
 * 
 * Deskripsi Kelas:
 * Transaksi penambahan saldo (Credit).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CreditTransaction
 * - Superclass (Pewarisan) : extends AbstractWalletTransaction
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public CreditTransaction(String id, long amount, String desc)
 *    Logika Implementasi:
 *      super(id, amount, desc);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Long> apply(long currentBalance)
 *    Logika Implementasi:
 *      return OperationResult.ok(currentBalance + getAmount());
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

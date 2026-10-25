package minifarm.units.u24wallet;

import minifarm.core.api.OperationResult;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractWalletTransaction
 * ================================================================================================
 * Modul Unit: U24WALLET
 * 
 * Deskripsi Kelas:
 * Kelas abstrak transaksi dompet (Wallet Transaction).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractWalletTransaction
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String transactionId;
 * 2. private final long amount;
 * 3. private final String description;
 * 4. private final long timestamp = System.currentTimeMillis();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractWalletTransaction(String transactionId, long amount, String description)
 *    Logika Implementasi:
 *      if (amount <= 0) {
 *          throw new IllegalArgumentException("Jumlah transaksi harus positif");
 *      }
 *      this.transactionId = transactionId;
 *      this.amount = amount;
 *      this.description = description != null ? description : "";
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getTransactionId()
 *    Logika Implementasi:
 *      return transactionId;
 * 
 * 2. public long getAmount()
 *    Logika Implementasi:
 *      return amount;
 * 
 * 3. public String getDescription()
 *    Logika Implementasi:
 *      return description;
 * 
 * 4. public long getTimestamp()
 *    Logika Implementasi:
 *      return timestamp;
 * 
 * 5. public abstract OperationResult<Long> apply(long currentBalance)
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

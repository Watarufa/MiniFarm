package minifarm.units.u24wallet;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.config.GameConfig;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): WalletService
 * ================================================================================================
 * Modul Unit: U24WALLET
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U24: Wallet dan Ledger Transaksi.
 * Mengimplementasikan WalletPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class WalletService
 * - Interface yang Diimplementasikan: implements WalletPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private long balance;
 * 2. private final List<AbstractWalletTransaction> ledger = new ArrayList<>();
 * 3. private long transactionCounter = 1;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public WalletService(long initialBalance)
 *    Logika Implementasi:
 *      if (initialBalance < 0) {
 *          throw new IllegalArgumentException("Saldo awal tidak boleh negatif");
 *      }
 *      this.balance = initialBalance;
 * 
 * 2. Constructor: public WalletService()
 *    Logika Implementasi:
 *      this(GameConfig.INITIAL_COINS);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long getBalance()
 *    Logika Implementasi:
 *      return balance;
 * 
 * 2. @Override public OperationResult<Void> debit(long amount, String description)
 *    Logika Implementasi:
 *      // TODO U24:
 *      // 1. Validasi amount (amount > 0). Jika <= 0 kembalikan INVALID_ARGUMENT.
 *      // 2. Buat DebitTransaction baru.
 *      // 3. Terapkan tx.apply(balance). Jika gagal (saldo kurang), kembalikan INSUFFICIENT_FUNDS tanpa mutasi ledger.
 *      // 4. Jika sukses, perbarui balance dan catat ke ledger.
 *      if (amount <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah debit harus lebih besar dari 0");
 *      }
 *      DebitTransaction tx = new DebitTransaction("TX-" + (transactionCounter++), amount, description);
 *      OperationResult<Long> applyRes = tx.apply(balance);
 *      if (applyRes.isFailure()) {
 *          return OperationResult.failed(applyRes.getCode(), applyRes.getMessage());
 *      }
 *      
 *      this.balance = applyRes.getOrNull();
 *      ledger.add(tx);
 *      return OperationResult.ok();
 * 
 * 3. @Override public OperationResult<Void> credit(long amount, String description)
 *    Logika Implementasi:
 *      // TODO U24:
 *      // 1. Validasi amount (amount > 0).
 *      // 2. Buat CreditTransaction baru.
 *      // 3. Terapkan tx.apply(balance), perbarui balance, catat ke ledger.
 *      if (amount <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah kredit harus lebih besar dari 0");
 *      }
 *      CreditTransaction tx = new CreditTransaction("TX-" + (transactionCounter++), amount, description);
 *      OperationResult<Long> applyRes = tx.apply(balance);
 *      if (applyRes.isFailure()) {
 *          return OperationResult.failed(applyRes.getCode(), applyRes.getMessage());
 *      }
 *      
 *      this.balance = applyRes.getOrNull();
 *      ledger.add(tx);
 *      return OperationResult.ok();
 * 
 * 4. public OperationResult<Void> refund(long amount, String description)
 *    Logika Implementasi:
 *      if (amount <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah refund harus lebih besar dari 0");
 *      }
 *      RefundTransaction tx = new RefundTransaction("TX-" + (transactionCounter++), amount, description);
 *      this.balance = tx.apply(balance).getOrNull();
 *      ledger.add(tx);
 *      return OperationResult.ok();
 * 
 * 5. public List<AbstractWalletTransaction> getLedger()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(ledger);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

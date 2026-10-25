package minifarm.units.u24wallet;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U24")
@Tag("unit")
class WalletServiceTest {

    private WalletService wallet;

    @BeforeEach
    void setUp() {
        wallet = new WalletService(500L);
    }

    @Test
    @DisplayName("Credit menambah saldo dan debit mengurangi saldo dengan tepat serta tercatat di ledger")
    void transactions_mutateBalanceAndRecordToLedger() {
        wallet.credit(200L, "Panen");
        assertEquals(700L, wallet.getBalance());

        wallet.debit(150L, "Beli Benih");
        assertEquals(550L, wallet.getBalance());

        assertEquals(2, wallet.getLedger().size(), "Harus ada 2 transaksi tercatat");
    }

    @Test
    @DisplayName("Debit yang melebihi saldo ditolak dan tidak dicatat di ledger (Atomisitas)")
    void debit_whenInsufficientFunds_failsWithoutMutatingLedger() {
        OperationResult<Void> result = wallet.debit(1000L, "Beli Rumah Mewah");

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INSUFFICIENT_FUNDS, result.getCode());
        assertEquals(500L, wallet.getBalance(), "Saldo tidak boleh berubah");
        assertEquals(0, wallet.getLedger().size(), "Transaksi gagal tidak boleh masuk ledger");
    }

    @Test
    @DisplayName("Transaksi dengan nominal <= 0 ditolak")
    void transactions_withNonPositiveAmount_rejected() {
        OperationResult<Void> res1 = wallet.debit(0L, "Nol");
        OperationResult<Void> res2 = wallet.credit(-50L, "Minus");

        assertTrue(res1.isFailure());
        assertTrue(res2.isFailure());
        assertEquals(ResultCode.INVALID_ARGUMENT, res1.getCode());
    }

    @Test
    @DisplayName("Bukti Polymorphism: CreditTransaction, DebitTransaction, dan RefundTransaction menerapkan apply() secara berbeda")
    void polymorphicTransactions_applyDifferently() {
        AbstractWalletTransaction credit = new CreditTransaction("T1", 50L, "C");
        AbstractWalletTransaction debit = new DebitTransaction("T2", 50L, "D");
        AbstractWalletTransaction refund = new RefundTransaction("T3", 50L, "R");

        assertEquals(150L, credit.apply(100L).getOrNull());
        assertEquals(50L, debit.apply(100L).getOrNull());
        assertEquals(150L, refund.apply(100L).getOrNull());
    }
}


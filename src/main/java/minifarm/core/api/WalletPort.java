package minifarm.core.api;

/**
 * Port integrasi domain untuk manajemen keuangan dan saldo pemain.
 */
public interface WalletPort {
    long getBalance();
    OperationResult<Void> debit(long amount, String description);
    OperationResult<Void> credit(long amount, String description);
}


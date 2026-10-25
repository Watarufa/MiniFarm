package minifarm.fixtures;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;

/**
 * In-memory test double untuk WalletPort.
 */
public class FakeWalletPort implements WalletPort {
    private long balance;

    public FakeWalletPort(long initialBalance) {
        this.balance = initialBalance;
    }

    public FakeWalletPort() {
        this(500L);
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public OperationResult<Void> debit(long amount, String description) {
        if (amount <= 0) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah debit harus positif");
        }
        if (balance < amount) {
            return OperationResult.failed(ResultCode.INSUFFICIENT_FUNDS, "Saldo tidak mencukupi");
        }
        balance -= amount;
        return OperationResult.ok();
    }

    @Override
    public OperationResult<Void> credit(long amount, String description) {
        if (amount <= 0) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah kredit harus positif");
        }
        balance += amount;
        return OperationResult.ok();
    }
}


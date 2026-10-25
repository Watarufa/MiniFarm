package minifarm.fixtures;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;

/**
 * In-memory test double untuk EnergyPort.
 */
public class FakeEnergyPort implements EnergyPort {
    private int energy;
    private final int maxEnergy;

    public FakeEnergyPort(int initialEnergy, int maxEnergy) {
        this.energy = initialEnergy;
        this.maxEnergy = maxEnergy;
    }

    public FakeEnergyPort() {
        this(100, 100);
    }

    @Override
    public int getCurrentEnergy() {
        return energy;
    }

    @Override
    public int getMaxEnergy() {
        return maxEnergy;
    }

    @Override
    public OperationResult<Void> consumeEnergy(int amount) {
        if (amount < 0) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Biaya energi tidak boleh negatif");
        }
        if (energy < amount) {
            return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi");
        }
        energy -= amount;
        return OperationResult.ok();
    }

    @Override
    public void restoreEnergy(int amount) {
        energy = Math.min(maxEnergy, energy + amount);
    }
}


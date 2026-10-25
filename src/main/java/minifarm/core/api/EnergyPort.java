package minifarm.core.api;

/**
 * Port integrasi domain untuk manajemen stamina/energi pemain.
 */
public interface EnergyPort {
    int getCurrentEnergy();
    int getMaxEnergy();
    OperationResult<Void> consumeEnergy(int amount);
    void restoreEnergy(int amount);
}


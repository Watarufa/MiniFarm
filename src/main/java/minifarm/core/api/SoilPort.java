package minifarm.core.api;

/**
 * Port integrasi domain untuk pemeriksaan kesuburan dan penerapan pupuk.
 */
public interface SoilPort {
    SoilSnapshot getSoilSnapshot(int plotIndex);
    OperationResult<Void> applyFertilizer(int plotIndex, int boostAmount);
    void applyFertilityDecay(int plotIndex);
}


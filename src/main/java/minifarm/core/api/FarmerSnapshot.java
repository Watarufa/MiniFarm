package minifarm.core.api;

import java.util.Objects;

/**
 * Snapshot immutable status profil petani.
 */
public final class FarmerSnapshot {
    private final String name;
    private final String specialization;
    private final int energy;
    private final int maxEnergy;
    private final long coins;

    public FarmerSnapshot(String name, String specialization, int energy, int maxEnergy, long coins) {
        this.name = Objects.requireNonNull(name, "name tidak boleh null");
        this.specialization = Objects.requireNonNull(specialization, "specialization tidak boleh null");
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public long getCoins() {
        return coins;
    }

    @Override
    public String toString() {
        return name + " (" + specialization + ") - Energi: " + energy + "/" + maxEnergy + ", Koin: " + coins;
    }
}


package minifarm.core.api;

import java.util.Objects;

/**
 * Snapshot immutable kondisi tanah pada sebuah petak.
 */
public final class SoilSnapshot {
    private final int fertility;
    private final boolean moist;
    private final String soilType;

    public SoilSnapshot(int fertility, boolean moist, String soilType) {
        this.fertility = Math.max(0, Math.min(100, fertility));
        this.moist = moist;
        this.soilType = Objects.requireNonNullElse(soilType, "Standard");
    }

    public int getFertility() {
        return fertility;
    }

    public boolean isMoist() {
        return moist;
    }

    public String getSoilType() {
        return soilType;
    }

    @Override
    public String toString() {
        return "SoilSnapshot{fertility=" + fertility + ", moist=" + moist + ", soilType='" + soilType + "'}";
    }
}


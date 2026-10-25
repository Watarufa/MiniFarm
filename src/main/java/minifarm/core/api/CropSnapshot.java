package minifarm.core.api;

import java.util.Objects;

/**
 * Snapshot immutable status tanaman di suatu petak.
 */
public final class CropSnapshot {
    private final String cropId;
    private final String cropType;
    private final int growthDay;
    private final int daysToMature;
    private final int health;
    private final boolean mature;

    public CropSnapshot(String cropId, String cropType, int growthDay, int daysToMature, int health, boolean mature) {
        this.cropId = Objects.requireNonNull(cropId, "cropId tidak boleh null");
        this.cropType = Objects.requireNonNull(cropType, "cropType tidak boleh null");
        this.growthDay = growthDay;
        this.daysToMature = daysToMature;
        this.health = health;
        this.mature = mature;
    }

    public String getCropId() {
        return cropId;
    }

    public String getCropType() {
        return cropType;
    }

    public int getGrowthDay() {
        return growthDay;
    }

    public int getDaysToMature() {
        return daysToMature;
    }

    public int getHealth() {
        return health;
    }

    public boolean isMature() {
        return mature;
    }

    @Override
    public String toString() {
        return cropType + " (" + growthDay + "/" + daysToMature + " hari, HP: " + health + ", Matang: " + mature + ")";
    }
}


package minifarm.core.api;

import java.util.Objects;

/**
 * Snapshot immutable kondisi cuaca harian.
 */
public final class WeatherSnapshot {
    private final String weatherType;
    private final boolean providesRain;
    private final double growthModifier;

    public WeatherSnapshot(String weatherType, boolean providesRain, double growthModifier) {
        this.weatherType = Objects.requireNonNull(weatherType, "weatherType tidak boleh null");
        this.providesRain = providesRain;
        this.growthModifier = growthModifier;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public boolean providesRain() {
        return providesRain;
    }

    public double getGrowthModifier() {
        return growthModifier;
    }

    @Override
    public String toString() {
        return weatherType;
    }
}


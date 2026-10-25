package minifarm.core.api;

import java.util.Objects;

/**
 * Konteks harian deterministik yang dipassing ke pemroses harian saat Advance Day.
 */
public final class DayContext {
    private final int dayNumber;
    private final WeatherSnapshot weather;

    public DayContext(int dayNumber, WeatherSnapshot weather) {
        this.dayNumber = dayNumber;
        this.weather = Objects.requireNonNull(weather, "weather tidak boleh null");
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public WeatherSnapshot getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return "Day " + dayNumber + " [" + weather.getWeatherType() + "]";
    }
}


package minifarm.core.api;

/**
 * Kontrak jam permainan deterministik.
 */
public interface GameClock {
    int getCurrentDay();
    WeatherSnapshot getCurrentWeather();
}


package minifarm.fixtures;

import minifarm.core.api.GameClock;
import minifarm.core.api.WeatherSnapshot;

/**
 * In-memory test double untuk GameClock deterministik.
 */
public class FakeGameClock implements GameClock {
    private int currentDay;
    private WeatherSnapshot currentWeather;

    public FakeGameClock(int initialDay, WeatherSnapshot weather) {
        this.currentDay = initialDay;
        this.currentWeather = weather;
    }

    public FakeGameClock() {
        this(1, new WeatherSnapshot("SUNNY", false, 1.0));
    }

    @Override
    public int getCurrentDay() {
        return currentDay;
    }

    @Override
    public WeatherSnapshot getCurrentWeather() {
        return currentWeather;
    }

    public void advanceDay(WeatherSnapshot nextWeather) {
        this.currentDay++;
        this.currentWeather = nextWeather;
    }
}


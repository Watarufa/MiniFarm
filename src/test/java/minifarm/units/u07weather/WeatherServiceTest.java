package minifarm.units.u07weather;

import minifarm.core.api.WeatherSnapshot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U07")
@Tag("unit")
class WeatherServiceTest {

    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherService();
    }

    @Test
    @DisplayName("Urutan cuaca default berulang secara deterministik: SUNNY -> CLOUDY -> RAINY")
    void defaultCycle_repeatsDeterministically() {
        assertEquals("SUNNY", weatherService.getCurrentWeather().getWeatherType());
        assertFalse(weatherService.getCurrentWeather().providesRain());

        WeatherSnapshot day2 = weatherService.advanceToNextWeather();
        assertEquals("CLOUDY", day2.getWeatherType());
        assertFalse(day2.providesRain());

        WeatherSnapshot day3 = weatherService.advanceToNextWeather();
        assertEquals("RAINY", day3.getWeatherType());
        assertTrue(day3.providesRain());

        // Kembali ke SUNNY
        WeatherSnapshot day4 = weatherService.advanceToNextWeather();
        assertEquals("SUNNY", day4.getWeatherType());
    }

    @Test
    @DisplayName("Mendukung custom sequence cuaca yang diinjeksi untuk kebutuhan testing")
    void customWeatherSequence_worksCorrectly() {
        WeatherService customService = new WeatherService(List.of(new RainyWeather(), new RainyWeather()));
        assertTrue(customService.getCurrentWeather().providesRain());
        customService.advanceToNextWeather();
        assertTrue(customService.getCurrentWeather().providesRain());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tiap state cuaca memiliki sifat providesRain dan modifier berbeda")
    void polymorphicWeatherStates_differInRainAndModifiers() {
        AbstractWeatherState sunny = new SunnyWeather();
        AbstractWeatherState rainy = new RainyWeather();

        assertFalse(sunny.providesRain());
        assertTrue(rainy.providesRain());

        assertEquals(1.0, sunny.getGrowthModifier());
        assertEquals(1.2, rainy.getGrowthModifier());
    }
}


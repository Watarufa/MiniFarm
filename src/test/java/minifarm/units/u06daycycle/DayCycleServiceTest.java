package minifarm.units.u06daycycle;

import minifarm.core.api.WeatherSnapshot;
import minifarm.core.events.DayAdvanced;
import minifarm.core.events.EventBus;
import minifarm.fixtures.FakeEnergyPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U06")
@Tag("unit")
class DayCycleServiceTest {

    private DayCycleService dayCycleService;
    private EventBus eventBus;
    private FakeEnergyPort energyPort;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        energyPort = new FakeEnergyPort(20, 100);
        dayCycleService = new DayCycleService(1, new WeatherSnapshot("SUNNY", false, 1.0), eventBus, energyPort);
    }

    @Test
    @DisplayName("Advance Day memajukan nomor hari tepat satu dan memulihkan energi")
    void advanceDay_incrementsDayAndRestoresEnergy() {
        assertEquals(1, dayCycleService.getCurrentDay());
        assertEquals(20, energyPort.getCurrentEnergy());

        WeatherSnapshot cloudy = new WeatherSnapshot("CLOUDY", false, 1.0);
        dayCycleService.advanceDay(cloudy);

        assertEquals(2, dayCycleService.getCurrentDay(), "Hari harus menjadi 2");
        assertEquals("CLOUDY", dayCycleService.getCurrentWeather().getWeatherType());
        assertEquals(100, energyPort.getCurrentEnergy(), "Energi harus pulih maksimal");
    }

    @Test
    @DisplayName("Advance Day menerbitkan event DayAdvanced tepat satu kali")
    void advanceDay_publishesDayAdvancedEventOnce() {
        AtomicInteger eventCount = new AtomicInteger(0);
        eventBus.subscribe(DayAdvanced.class, event -> {
            assertEquals(2, event.getNewDay());
            eventCount.incrementAndGet();
        });

        dayCycleService.advanceDay(new WeatherSnapshot("RAINY", true, 1.2));
        assertEquals(1, eventCount.get(), "Event harus dipublikasikan tepat 1 kali");
    }

    @Test
    @DisplayName("Bukti Polymorphism: DailyProcess dieksekusi secara berurutan sesuai order")
    void polymorphicProcesses_executedInOrder() {
        StringBuilder orderLog = new StringBuilder();

        dayCycleService.registerProcess(new AbstractDailyProcess("CustomFirst", 5) {
            @Override public void execute(minifarm.core.api.DayContext context) {
                orderLog.append("A");
            }
        });
        dayCycleService.registerProcess(new AbstractDailyProcess("CustomSecond", 95) {
            @Override public void execute(minifarm.core.api.DayContext context) {
                orderLog.append("B");
            }
        });

        dayCycleService.advanceDay(new WeatherSnapshot("SUNNY", false, 1.0));
        assertEquals("AB", orderLog.toString(), "Proses harus dieksekusi sesuai urutan order integer");
    }
}


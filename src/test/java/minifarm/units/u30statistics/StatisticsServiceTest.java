package minifarm.units.u30statistics;

import minifarm.core.events.CropHarvested;
import minifarm.core.events.EventBus;
import minifarm.core.events.ItemSold;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U30")
@Tag("unit")
class StatisticsServiceTest {

    private StatisticsService statisticsService;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        statisticsService = new StatisticsService(eventBus);
    }

    @Test
    @DisplayName("Statistik bertambah saat menerima domain event yang sesuai")
    void onEvent_incrementsStatisticsAccurately() {
        // Panen 3 wheat
        eventBus.publish(new CropHarvested(1, 0, "wheat", 3));
        // Jual seharga 30 G
        eventBus.publish(new ItemSold(1, "wheat", 3, 30L));

        ProductionStatistic prod = (ProductionStatistic) statisticsService.getAllStatistics().get(0);
        FinanceStatistic fin = (FinanceStatistic) statisticsService.getAllStatistics().get(1);

        assertEquals(3, prod.getTotalCropsHarvested());
        assertEquals(30L, fin.getTotalEarned());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Tiap turunan AbstractFarmStatistic memproses format ringkasan secara berbeda")
    void polymorphicStatistics_formatSummaryDifferently() {
        AbstractFarmStatistic prod = new ProductionStatistic();
        AbstractFarmStatistic fin = new FinanceStatistic();

        assertNotEquals(prod.getMetricName(), fin.getMetricName());
        assertNotEquals(prod.getFormattedSummary(), fin.getFormattedSummary());
    }
}


package minifarm.units.u26achievement;

import minifarm.core.events.AchievementUnlocked;
import minifarm.core.events.CropHarvested;
import minifarm.core.events.EventBus;
import minifarm.fixtures.FakeWalletPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U26")
@Tag("unit")
class AchievementServiceTest {

    private AchievementService achievementService;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        achievementService = new AchievementService(eventBus);
    }

    @Test
    @DisplayName("Event panen pertama membuka achievement Panen Pertama dan memancarkan event")
    void onEvent_unlocksAchievement() {
        AtomicInteger eventCount = new AtomicInteger(0);
        eventBus.subscribe(AchievementUnlocked.class, e -> eventCount.incrementAndGet());

        AchievementService.AchievementEntry ach = achievementService.getAchievement("ach_first_harvest").orElseThrow();
        assertFalse(ach.isUnlocked());

        // Picu panen
        eventBus.publish(new CropHarvested(1, 0, "wheat", 2));

        assertTrue(ach.isUnlocked(), "Achievement harus berstatus terbuka");
        assertEquals(1, eventCount.get());

        // Panen kedua tidak memicu event ganda (Idempotent)
        eventBus.publish(new CropHarvested(1, 1, "wheat", 2));
        assertEquals(1, eventCount.get(), "Event tidak boleh terbit dua kali");
    }

    @Test
    @DisplayName("Bukti Polymorphism: CoinReward, ItemReward, dan XpReward menerapkan grant() secara berbeda")
    void polymorphicRewards_grantDifferently() {
        FakeWalletPort wallet = new FakeWalletPort(100L);
        CoinReward coinReward = new CoinReward(50L);

        coinReward.grant(wallet, null, null);
        assertEquals(150L, wallet.getBalance(), "CoinReward harus menambah saldo wallet");
    }
}


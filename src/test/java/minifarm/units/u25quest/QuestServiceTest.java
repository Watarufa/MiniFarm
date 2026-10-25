package minifarm.units.u25quest;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.events.CropHarvested;
import minifarm.core.events.EventBus;
import minifarm.core.events.QuestCompleted;
import minifarm.fixtures.FakeWalletPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U25")
@Tag("unit")
class QuestServiceTest {

    private QuestService questService;
    private EventBus eventBus;
    private FakeWalletPort walletPort;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        questService = new QuestService(eventBus);
        walletPort = new FakeWalletPort(100L);
    }

    @Test
    @DisplayName("Event panen wheat menaikkan progres quest panen wheat hingga selesai tepat pada target")
    void onEvent_advancesMatchingQuestToCompletion() {
        AtomicInteger completedEvents = new AtomicInteger(0);
        eventBus.subscribe(QuestCompleted.class, e -> completedEvents.incrementAndGet());

        AbstractQuest quest = questService.getQuest("quest_wheat").orElseThrow();
        assertEquals(0, quest.getCurrentProgress());

        // Event 1 panen
        eventBus.publish(new CropHarvested(1, 0, "wheat", 1));
        assertEquals(1, quest.getCurrentProgress());
        assertFalse(quest.isCompleted());

        // Event 2 panen (mencapai target 2)
        eventBus.publish(new CropHarvested(1, 1, "wheat", 1));
        assertEquals(2, quest.getCurrentProgress());
        assertTrue(quest.isCompleted());
        assertEquals(1, completedEvents.get(), "Event QuestCompleted harus diterbitkan");
    }

    @Test
    @DisplayName("Event panen jagung (corn) diabaikan oleh quest panen gandum (wheat)")
    void onEvent_ignoresIrrelevantCrop() {
        AbstractQuest quest = questService.getQuest("quest_wheat").orElseThrow();
        eventBus.publish(new CropHarvested(1, 0, "corn", 5));

        assertEquals(0, quest.getCurrentProgress(), "Progress tidak boleh bertambah");
    }

    @Test
    @DisplayName("Hadiah quest yang sudah selesai dapat diklaim tepat 1 kali")
    void claimReward_onlyGrantedOnce() {
        AbstractQuest quest = questService.getQuest("quest_wheat").orElseThrow();
        quest.advanceProgress(2);
        assertTrue(quest.isCompleted());

        OperationResult<Void> firstClaim = questService.claimReward("quest_wheat", walletPort);
        assertTrue(firstClaim.isSuccess());
        assertEquals(150L, walletPort.getBalance(), "Saldo bertambah 50 koin reward");

        // Klaim kedua kali ditolak
        OperationResult<Void> secondClaim = questService.claimReward("quest_wheat", walletPort);
        assertTrue(secondClaim.isFailure());
        assertEquals(ResultCode.ALREADY_COMPLETED, secondClaim.getCode());
        assertEquals(150L, walletPort.getBalance(), "Saldo tidak bertambah lagi");
    }

    @Test
    @DisplayName("Bukti Polymorphism: HarvestQuest, AnimalProductQuest, dan SaleValueQuest merespons event yang berbeda")
    void polymorphicQuests_respondToDifferentEvents() {
        HarvestQuest hq = new HarvestQuest("hq", "Harvest", "wheat", 5, 10L);
        AnimalProductQuest apq = new AnimalProductQuest("apq", "Egg", "egg", 5, 10L);

        assertTrue(hq.handleEvent(new CropHarvested(1, 0, "wheat", 1)));
        assertFalse(apq.handleEvent(new CropHarvested(1, 0, "wheat", 1)));
    }
}


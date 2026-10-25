package minifarm.units.u32crophealth;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import minifarm.core.events.CropDestroyed;
import minifarm.core.events.EventBus;
import minifarm.fixtures.FakeEnergyPort;
import minifarm.fixtures.FakeInventoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U32")
@Tag("unit")
class CropHealthServiceTest {

    private CropHealthService healthService;
    private EventBus eventBus;
    private FakeInventoryPort inventoryPort;
    private FakeEnergyPort energyPort;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        healthService = new CropHealthService(eventBus);
        inventoryPort = new FakeInventoryPort(20);
        energyPort = new FakeEnergyPort(100, 100);

        inventoryPort.addItem(GameConfig.ITEM_PESTICIDE, 2);
    }

    @Test
    @DisplayName("Kerusakan mengurangi HP tanaman secara deterministik dan memancarkan CropDestroyed jika mencapai 0")
    void damageCrop_reducesHealthAndPublishesEventWhenDead() {
        AtomicInteger destroyEvents = new AtomicInteger(0);
        eventBus.subscribe(CropDestroyed.class, e -> destroyEvents.incrementAndGet());

        assertEquals(100, healthService.getHealth(0));

        healthService.damageCrop(0, 40, "Hama");
        assertEquals(60, healthService.getHealth(0));
        assertEquals(0, destroyEvents.get());

        // Serangan fatal (60 damage -> HP 0)
        healthService.damageCrop(0, 60, "Hama Berat");
        assertEquals(0, healthService.getHealth(0));
        assertEquals(1, destroyEvents.get(), "Event CropDestroyed harus diterbitkan");
    }

    @Test
    @DisplayName("Pengobatan memulihkan HP, memotong obat dan energi secara atomik")
    void applyTreatment_restoresHealthAndConsumesItemAndEnergy() {
        healthService.damageCrop(0, 50, "Pest");
        assertEquals(50, healthService.getHealth(0));

        PestTreatment treatment = new PestTreatment();
        OperationResult<Void> result = healthService.applyTreatment(0, treatment, inventoryPort, energyPort);

        assertTrue(result.isSuccess());
        assertEquals(80, healthService.getHealth(0), "50 + 30 heal = 80 HP");
        assertEquals(1, inventoryPort.getItemQuantity(GameConfig.ITEM_PESTICIDE), "Pesticide berkurang 1");
        assertEquals(96, energyPort.getCurrentEnergy(), "Energi berkurang 4");
    }

    @Test
    @DisplayName("Bukti Polymorphism: Ancaman dan Treatment yang berbeda memiliki nama dan nilai efek berbeda")
    void polymorphicThreatsAndTreatments_differInEffects() {
        AbstractCropThreat pest = new PestThreat();
        AbstractCropThreat fungal = new FungalThreat();
        assertEquals(30, pest.getDamageAmount());
        assertEquals(20, fungal.getDamageAmount());

        AbstractCropTreatment pestTreat = new PestTreatment();
        AbstractCropTreatment recovTreat = new RecoveryTreatment();
        assertEquals(30, pestTreat.getHealAmount());
        assertEquals(40, recovTreat.getHealAmount());
    }
}


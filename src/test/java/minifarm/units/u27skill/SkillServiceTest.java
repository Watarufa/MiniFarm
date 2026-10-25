package minifarm.units.u27skill;

import minifarm.core.events.CropHarvested;
import minifarm.core.events.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U27")
@Tag("unit")
class SkillServiceTest {

    private SkillService skillService;
    private EventBus eventBus;

    @BeforeEach
    void setUp() {
        eventBus = new EventBus();
        skillService = new SkillService(eventBus);
    }

    @Test
    @DisplayName("Aktivitas panen menambah XP ke kategori Crop Skill dan menaikkan level pada ambang batas")
    void onEvent_addsXpAndLevelsUpAtThreshold() {
        assertEquals(1, skillService.getLevel("crop"));
        assertEquals(0, skillService.getExperience("crop"));

        // Panen menghasilkan 10 XP
        eventBus.publish(new CropHarvested(1, 0, "wheat", 2));
        assertEquals(10, skillService.getExperience("crop"));
        assertEquals(1, skillService.getLevel("crop"));

        // Tambah 15 XP lagi (total 25 XP -> ambang Lv 2)
        skillService.addExperience("crop", 15);
        assertEquals(25, skillService.getExperience("crop"));
        assertEquals(2, skillService.getLevel("crop"), "Harus naik ke level 2 saat mencapai 25 XP");
    }

    @Test
    @DisplayName("Bukti Polymorphism: Crop, Animal, dan Trade skill memiliki rumus ambang batas naik level berbeda")
    void polymorphicSkills_haveDifferentThresholds() {
        CropSkill crop = new CropSkill();
        AnimalSkill animal = new AnimalSkill();
        TradingSkill trade = new TradingSkill();

        assertEquals(25, crop.getThresholdForNextLevel(1));
        assertEquals(20, animal.getThresholdForNextLevel(1));
        assertEquals(30, trade.getThresholdForNextLevel(1));
    }
}


package minifarm.units.u13farmerprofile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U13")
@Tag("unit")
class FarmerProfileServiceTest {

    private FarmerProfileService profileService;

    @BeforeEach
    void setUp() {
        profileService = new FarmerProfileService(new BalancedFarmer("AgroMaster"));
    }

    @Test
    @DisplayName("Nama profil petani tidak boleh null atau kosong")
    void profile_rejectsEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new BalancedFarmer(""));
        assertThrows(IllegalArgumentException.class, () -> new BalancedFarmer("   "));
    }

    @Test
    @DisplayName("Bukti Polymorphism: Cultivator dan Rancher memberikan modifier energi yang berbeda pada aktivitas tertentu")
    void polymorphicModifiers_differByProfession() {
        FarmerProfileService cultivator = new FarmerProfileService(new CultivatorFarmer("PlantSpecialist"));
        FarmerProfileService rancher = new FarmerProfileService(new RancherFarmer("AnimalSpecialist"));

        // Untuk aksi water
        assertEquals(0.8, cultivator.getEnergyModifier("water"));
        assertEquals(1.0, rancher.getEnergyModifier("water"));

        // Untuk aksi animal_care
        assertEquals(1.0, cultivator.getEnergyModifier("animal_care"));
        assertEquals(0.7, rancher.getEnergyModifier("animal_care"));
    }
}


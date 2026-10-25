package minifarm.units.u18housing;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U18")
@Tag("unit")
class HousingServiceTest {

    private HousingService housingService;

    @BeforeEach
    void setUp() {
        housingService = new HousingService();
    }

    @Test
    @DisplayName("Coop awal menampung 2 ekor ayam dengan kapasitas 4")
    void initialCoop_hasTwoChickensAndCapacityFour() {
        assertEquals(4, housingService.getCapacity("coop"));
        assertEquals(2, housingService.getOccupiedCount("coop"));
        assertTrue(housingService.canAcceptSpecies("coop", "chicken"));
        assertFalse(housingService.canAcceptSpecies("coop", "cow"));
    }

    @Test
    @DisplayName("Kandang menolak penempatan spesies yang tidak sesuai")
    void placeAnimal_whenWrongSpecies_fails() {
        AbstractAnimalHousing coop = housingService.getHousingEntity("coop");
        OperationResult<Void> result = coop.addAnimal("cow_1", "cow");

        assertTrue(result.isFailure());
        assertEquals(ResultCode.NOT_ALLOWED, result.getCode());
    }

    @Test
    @DisplayName("Kandang yang penuh menolak penambahan hewan baru")
    void placeAnimal_whenFull_fails() {
        AbstractAnimalHousing coop = housingService.getHousingEntity("coop");
        // Isi hingga kapasitas 4
        coop.addAnimal("chicken_3", "chicken");
        coop.addAnimal("chicken_4", "chicken");
        assertEquals(4, coop.getOccupiedCount());

        OperationResult<Void> overflowResult = coop.addAnimal("chicken_5", "chicken");
        assertTrue(overflowResult.isFailure());
        assertEquals(ResultCode.CAPACITY_EXCEEDED, overflowResult.getCode());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Coop hanya menerima ayam, Barn hanya menerima sapi")
    void polymorphicHousing_supportsDifferentSpecies() {
        AbstractAnimalHousing coop = new Coop();
        AbstractAnimalHousing barn = new Barn();

        assertTrue(coop.supportsSpecies("chicken"));
        assertFalse(coop.supportsSpecies("cow"));

        assertFalse(barn.supportsSpecies("chicken"));
        assertTrue(barn.supportsSpecies("cow"));
    }
}


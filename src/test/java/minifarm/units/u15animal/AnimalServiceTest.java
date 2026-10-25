package minifarm.units.u15animal;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U15")
@Tag("unit")
class AnimalServiceTest {

    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        animalService = new AnimalService();
    }

    @Test
    @DisplayName("Data awal memuat 2 ekor ayam dengan status sehat")
    void initialAnimals_containsTwoChickens() {
        List<AnimalSnapshot> list = animalService.getAllAnimals();
        assertEquals(2, list.size());
        assertTrue(animalService.getAnimal("chicken_1").isPresent());
        assertTrue(animalService.getAnimal("chicken_2").isPresent());
    }

    @Test
    @DisplayName("Pemberian pakan yang cocok mengubah status fed menjadi true")
    void feedAnimal_whenFeedMatches_succeeds() {
        OperationResult<Void> result = animalService.feedAnimal("chicken_1", GameConfig.ITEM_ANIMAL_FEED);

        assertTrue(result.isSuccess());
        AnimalSnapshot animal = animalService.getAnimal("chicken_1").orElseThrow();
        assertTrue(animal.isFed());
    }

    @Test
    @DisplayName("Pemberian pakan yang salah ditolak")
    void feedAnimal_whenFeedMismatch_fails() {
        OperationResult<Void> result = animalService.feedAnimal("chicken_1", "meat");

        assertTrue(result.isFailure());
        assertEquals(ResultCode.INVALID_ARGUMENT, result.getCode());
        assertFalse(animalService.getAnimal("chicken_1").orElseThrow().isFed());
    }

    @Test
    @DisplayName("Bukti Polymorphism: Chicken, Cow, dan Sheep membutuhkan pakan dan menghasilkan produk berbeda")
    void polymorphicAnimalSpecies_differInFeedsAndProducts() {
        AbstractFarmAnimal chicken = new Chicken("c1", "Chicken");
        AbstractFarmAnimal cow = new Cow("w1", "Cow");
        AbstractFarmAnimal sheep = new Sheep("s1", "Sheep");

        assertEquals("animal_feed", chicken.getRequiredFeedItemId());
        assertEquals("hay", cow.getRequiredFeedItemId());
        assertEquals("sweet_grass", sheep.getRequiredFeedItemId());

        assertEquals("egg", chicken.getProducedItemId());
        assertEquals("milk", cow.getProducedItemId());
        assertEquals("wool", sheep.getProducedItemId());
    }
}


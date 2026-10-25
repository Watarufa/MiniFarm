package minifarm.fixtures;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.FarmAnimalPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;

import java.util.*;

/**
 * In-memory test double untuk FarmAnimalPort.
 */
public class FakeFarmAnimalPort implements FarmAnimalPort {
    private final Map<String, AnimalSnapshot> animals = new HashMap<>();

    public FakeFarmAnimalPort() {
        animals.put("chicken_1", new AnimalSnapshot("chicken_1", "chicken", "Hen 1", 100, false, true));
        animals.put("chicken_2", new AnimalSnapshot("chicken_2", "chicken", "Hen 2", 100, false, true));
    }

    @Override
    public List<AnimalSnapshot> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public Optional<AnimalSnapshot> getAnimal(String animalId) {
        return Optional.ofNullable(animals.get(animalId));
    }

    @Override
    public OperationResult<Void> feedAnimal(String animalId, String feedItemId) {
        AnimalSnapshot animal = animals.get(animalId);
        if (animal == null) {
            return OperationResult.failed(ResultCode.NOT_FOUND, "Hewan tidak ditemukan: " + animalId);
        }
        animals.put(animalId, new AnimalSnapshot(animal.getId(), animal.getSpecies(), animal.getName(), animal.getHealth(), true, animal.isClean()));
        return OperationResult.ok();
    }

    @Override
    public OperationResult<Void> careAnimal(String animalId, String careType) {
        AnimalSnapshot animal = animals.get(animalId);
        if (animal == null) {
            return OperationResult.failed(ResultCode.NOT_FOUND, "Hewan tidak ditemukan: " + animalId);
        }
        animals.put(animalId, new AnimalSnapshot(animal.getId(), animal.getSpecies(), animal.getName(), Math.min(100, animal.getHealth() + 10), animal.isFed(), true));
        return OperationResult.ok();
    }
}


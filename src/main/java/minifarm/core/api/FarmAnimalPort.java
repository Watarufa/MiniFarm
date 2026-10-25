package minifarm.core.api;

import java.util.List;
import java.util.Optional;

/**
 * Port integrasi domain untuk mengelola entitas hewan ternak.
 */
public interface FarmAnimalPort {
    List<AnimalSnapshot> getAllAnimals();
    Optional<AnimalSnapshot> getAnimal(String animalId);
    OperationResult<Void> feedAnimal(String animalId, String feedItemId);
    OperationResult<Void> careAnimal(String animalId, String careType);
}


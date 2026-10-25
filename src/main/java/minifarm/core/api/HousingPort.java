package minifarm.core.api;

import java.util.List;

/**
 * Port integrasi domain untuk kandang hewan (coop, barn, pasture).
 */
public interface HousingPort {
    int getCapacity(String housingId);
    int getOccupiedCount(String housingId);
    boolean canAcceptSpecies(String housingId, String species);
    OperationResult<Void> placeAnimal(String housingId, String animalId);
    OperationResult<Void> removeAnimal(String housingId, String animalId);
    List<String> getAnimalIdsInHousing(String housingId);
}


package minifarm.core.api;

/**
 * Port integrasi domain untuk upgrade kapasitas kandang hewan.
 */
public interface HousingCapacityPort {
    int getCapacity(String housingId);
    OperationResult<Void> expandCapacity(String housingId, int additionalCapacity);
}


package minifarm.core.api;

/**
 * Port integrasi domain untuk upgrade kapasitas storage pertanian.
 */
public interface StorageCapacityPort {
    int getStorageCapacity();
    OperationResult<Void> expandStorageCapacity(int additionalSlots);
}


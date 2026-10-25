package minifarm.core.api;

/**
 * Kontrak bagi entitas tanaman yang dapat diekstrak snapshot statusnya.
 */
public interface CropSnapshotProvider {
    CropSnapshot toSnapshot();
}


package minifarm.core.api;

import java.util.Optional;

/**
 * Port integrasi domain untuk penempatan dan pengambilan tanaman pada petak lahan.
 */
public interface CropSlotPort {
    int getPlotCount();
    int getOccupiedPlotCount();
    boolean isPlotEmpty(int plotIndex);
    Optional<CropSnapshot> getCropSnapshot(int plotIndex);
    OperationResult<Void> placeCrop(int plotIndex, Object crop);
    OperationResult<Object> takeCrop(int plotIndex);
    OperationResult<Void> clearPlot(int plotIndex);
}


package minifarm.fixtures;

import minifarm.core.api.CropSlotPort;
import minifarm.core.api.CropSnapshot;
import minifarm.core.api.OperationResult;
import minifarm.core.api.PlotCapacityPort;
import minifarm.core.api.ResultCode;

import java.util.*;

/**
 * In-memory test double untuk CropSlotPort dan PlotCapacityPort.
 */
public class FakeCropSlotPort implements CropSlotPort, PlotCapacityPort {
    private final Map<Integer, Object> plots = new HashMap<>();
    private int plotCount;
    private int maxPlots;

    public FakeCropSlotPort(int plotCount, int maxPlots) {
        this.plotCount = plotCount;
        this.maxPlots = maxPlots;
    }

    public FakeCropSlotPort(int plotCount) {
        this(plotCount, 8);
    }

    public FakeCropSlotPort() {
        this(4, 8);
    }

    @Override
    public int getPlotCount() {
        return plotCount;
    }

    @Override
    public int getOccupiedPlotCount() {
        return plots.size();
    }

    @Override
    public boolean isPlotEmpty(int plotIndex) {
        if (plotIndex < 0 || plotIndex >= plotCount) return false;
        return !plots.containsKey(plotIndex);
    }

    @Override
    public Optional<CropSnapshot> getCropSnapshot(int plotIndex) {
        if (!plots.containsKey(plotIndex)) {
            return Optional.empty();
        }
        Object crop = plots.get(plotIndex);
        return Optional.of(new CropSnapshot("crop_" + plotIndex, crop.toString(), 2, 2, 100, true));
    }

    @Override
    public OperationResult<Void> placeCrop(int plotIndex, Object crop) {
        if (plotIndex < 0 || plotIndex >= plotCount) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid: " + plotIndex);
        }
        if (plots.containsKey(plotIndex)) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Petak sudah terisi");
        }
        plots.put(plotIndex, crop);
        return OperationResult.ok();
    }

    @Override
    public OperationResult<Object> takeCrop(int plotIndex) {
        if (!plots.containsKey(plotIndex)) {
            return OperationResult.failed(ResultCode.NOT_FOUND, "Petak kosong");
        }
        Object removed = plots.remove(plotIndex);
        return OperationResult.ok(removed);
    }

    @Override
    public OperationResult<Void> clearPlot(int plotIndex) {
        plots.remove(plotIndex);
        return OperationResult.ok();
    }

    public void setPlotCount(int count) {
        this.plotCount = count;
    }

    @Override
    public int getCurrentPlots() {
        return plotCount;
    }

    @Override
    public int getMaxPlots() {
        return maxPlots;
    }

    @Override
    public OperationResult<Void> expandPlots(int count) {
        if (count <= 0) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah ekspansi harus lebih dari 0");
        }
        if (plotCount + count > maxPlots) {
            return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Melebihi kapasitas maksimal petak (" + maxPlots + ")");
        }
        plotCount += count;
        return OperationResult.ok();
    }

    @Override
    public OperationResult<Void> convertToProtectedPlot(int plotIndex) {
        if (plotIndex < 0 || plotIndex >= plotCount) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid: " + plotIndex);
        }
        return OperationResult.ok();
    }
}

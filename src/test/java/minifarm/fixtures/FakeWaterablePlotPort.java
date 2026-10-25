package minifarm.fixtures;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WaterablePlotPort;

import java.util.HashSet;
import java.util.Set;

/**
 * In-memory test double untuk WaterablePlotPort.
 */
public class FakeWaterablePlotPort implements WaterablePlotPort {
    private final Set<Integer> moistPlots = new HashSet<>();
    private final int totalPlots;

    public FakeWaterablePlotPort(int totalPlots) {
        this.totalPlots = totalPlots;
    }

    public FakeWaterablePlotPort() {
        this(4);
    }

    @Override
    public boolean isPlotMoist(int plotIndex) {
        return moistPlots.contains(plotIndex);
    }

    @Override
    public OperationResult<Void> waterPlot(int plotIndex) {
        if (plotIndex < 0 || plotIndex >= totalPlots) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid: " + plotIndex);
        }
        if (moistPlots.contains(plotIndex)) {
            return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Petak sudah disiram");
        }
        moistPlots.add(plotIndex);
        return OperationResult.ok();
    }

    @Override
    public void resetDailyMoisture() {
        moistPlots.clear();
    }
}


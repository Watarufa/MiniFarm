package minifarm.core.api;

/**
 * Port integrasi domain untuk perluasan kapasitas petak dan upgrade petak khusus.
 */
public interface PlotCapacityPort {
    int getMaxPlots();
    int getCurrentPlots();
    OperationResult<Void> expandPlots(int count);
    OperationResult<Void> convertToProtectedPlot(int plotIndex);
}


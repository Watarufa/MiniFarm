package minifarm.core.api;

/**
 * Port integrasi domain untuk aksi penyiraman petak lahan.
 */
public interface WaterablePlotPort {
    boolean isPlotMoist(int plotIndex);
    OperationResult<Void> waterPlot(int plotIndex);
    void resetDailyMoisture();
}


package minifarm.units.u01plot;

import minifarm.core.api.*;
import minifarm.core.config.GameConfig;

import java.util.*;

/**
 * Public Facade untuk Unit U01: Manajemen Lahan dan Petak.
 * Mengimplementasikan CropSlotPort, PlotCapacityPort, dan WaterablePlotPort.
 */
public class PlotService implements CropSlotPort, PlotCapacityPort, WaterablePlotPort {
    private final List<AbstractFarmPlot> plots = new ArrayList<>();
    private final int maxPlots;

    public PlotService(int initialPlots, int maxPlots) {
        this.maxPlots = maxPlots;
        for (int i = 0; i < initialPlots; i++) {
            plots.add(new OutdoorCropPlot(i));
        }
    }

    public PlotService() {
        this(GameConfig.INITIAL_PLOT_COUNT, GameConfig.MAX_PLOT_COUNT);
    }

    @Override
    public int getPlotCount() {
        return plots.size();
    }

    @Override
    public int getOccupiedPlotCount() {
        int count = 0;
        for (AbstractFarmPlot plot : plots) {
            if (plot.isOccupied()) count++;
        }
        return count;
    }

    @Override
    public boolean isPlotEmpty(int plotIndex) {
        if (!isValidIndex(plotIndex)) return false;
        return !plots.get(plotIndex).isOccupied();
    }

    @Override
    public Optional<CropSnapshot> getCropSnapshot(int plotIndex) {
        if (!isValidIndex(plotIndex)) return Optional.empty();
        return plots.get(plotIndex).getCropSnapshot();
    }

    @Override
    public OperationResult<Void> placeCrop(int plotIndex, Object crop) {
        // TODO U01: Validasi plotIndex dan pastikan petak tidak sedang terisi tanaman.
        // Jika valid, masukkan tanaman ke petak dan kembalikan OperationResult.ok().
        // Jika tidak valid, kembalikan OperationResult.failed dengan kode yang sesuai.
        if (!isValidIndex(plotIndex)) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid: " + plotIndex);
        }
        AbstractFarmPlot plot = plots.get(plotIndex);
        if (plot.isOccupied()) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Petak #" + plotIndex + " sudah terisi");
        }
        plot.placeCrop(crop);
        return OperationResult.ok();
    }

    @Override
    public OperationResult<Object> takeCrop(int plotIndex) {
        // TODO U01: Validasi plotIndex dan pastikan petak terisi.
        // Hapus tanaman dari petak dan kembalikan objek tanaman tersebut di dalam OperationResult.ok(crop).
        if (!isValidIndex(plotIndex)) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid");
        }
        AbstractFarmPlot plot = plots.get(plotIndex);
        if (!plot.isOccupied()) {
            return OperationResult.failed(ResultCode.NOT_FOUND, "Petak #" + plotIndex + " kosong");
        }
        Object removed = plot.removeCrop();
        return OperationResult.ok(removed);
    }

    @Override
    public OperationResult<Void> clearPlot(int plotIndex) {
        if (!isValidIndex(plotIndex)) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid");
        }
        plots.get(plotIndex).clear();
        return OperationResult.ok();
    }

    @Override
    public boolean isPlotMoist(int plotIndex) {
        if (!isValidIndex(plotIndex)) return false;
        return plots.get(plotIndex).isMoist();
    }

    @Override
    public OperationResult<Void> waterPlot(int plotIndex) {
        // TODO U01: Validasi plotIndex. Jika sudah lembap, kembalikan failed(ALREADY_COMPLETED).
        // Jika belum, set status moist menjadi true.
        if (!isValidIndex(plotIndex)) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid");
        }
        AbstractFarmPlot plot = plots.get(plotIndex);
        if (plot.isMoist()) {
            return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Petak #" + plotIndex + " sudah lembap (tersiram air hujan atau sudah disiram hari ini)");
        }
        plot.setMoist(true);
        return OperationResult.ok();
    }

    @Override
    public void resetDailyMoisture() {
        for (AbstractFarmPlot plot : plots) {
            plot.setMoist(false);
        }
    }

    @Override
    public int getMaxPlots() {
        return maxPlots;
    }

    @Override
    public int getCurrentPlots() {
        return plots.size();
    }

    @Override
    public OperationResult<Void> expandPlots(int count) {
        // TODO U01: Validasi count. Pastikan plots.size() + count <= maxPlots.
        if (count <= 0) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah ekspansi harus lebih dari 0");
        }
        if (plots.size() + count > maxPlots) {
            return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Melebihi batas maksimum petak (" + maxPlots + ")");
        }
        for (int i = 0; i < count; i++) {
            plots.add(new OutdoorCropPlot(plots.size()));
        }
        return OperationResult.ok();
    }

    @Override
    public OperationResult<Void> convertToProtectedPlot(int plotIndex) {
        // TODO U01: Mengubah petak luar ruang yang kosong menjadi ProtectedCropPlot.
        if (!isValidIndex(plotIndex)) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid");
        }
        AbstractFarmPlot current = plots.get(plotIndex);
        if (current.isOccupied()) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Hanya petak kosong yang dapat di-upgrade ke Protected Plot");
        }
        ProtectedCropPlot protectedPlot = new ProtectedCropPlot(plotIndex);
        plots.set(plotIndex, protectedPlot);
        return OperationResult.ok();
    }

    public void applyDailyWeather(boolean isRaining) {
        // TODO U01: Terapkan efek cuaca secara polimorfik ke setiap petak lahan
        for (AbstractFarmPlot plot : plots) {
            plot.applyWeather(isRaining);
        }
    }

    public AbstractFarmPlot getPlot(int plotIndex) {
        if (!isValidIndex(plotIndex)) return null;
        return plots.get(plotIndex);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < plots.size();
    }
}


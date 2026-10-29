package minifarm.units.u01plot;

import minifarm.core.api.*;
import minifarm.core.config.GameConfig;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): PlotService
 * ================================================================================================
 * Modul Unit: U01PLOT
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U01: Manajemen Lahan dan Petak.
 * Mengimplementasikan CropSlotPort, PlotCapacityPort, dan WaterablePlotPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class PlotService
 * - Interface yang Diimplementasikan: implements CropSlotPort, PlotCapacityPort, WaterablePlotPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final List<AbstractFarmPlot> plots = new ArrayList<>();
 * 2. private final int maxPlots;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public PlotService(int initialPlots, int maxPlots)
 *    Logika Implementasi:
 *      this.maxPlots = maxPlots;
 *      for (int i = 0; i < initialPlots; i++) {
 *          plots.add(new OutdoorCropPlot(i));
 *      }
 * 
 * 2. Constructor: public PlotService()
 *    Logika Implementasi:
 *      this(GameConfig.INITIAL_PLOT_COUNT, GameConfig.MAX_PLOT_COUNT);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public int getPlotCount()
 *    Logika Implementasi:
 *      return plots.size();
 * 
 * 2. @Override public int getOccupiedPlotCount()
 *    Logika Implementasi:
 *      int count = 0;
 *      for (AbstractFarmPlot plot : plots) {
 *          if (plot.isOccupied()) count++;
 *      }
 *      return count;
 * 
 * 3. @Override public boolean isPlotEmpty(int plotIndex)
 *    Logika Implementasi:
 *      if (!isValidIndex(plotIndex)) return false;
 *      return !plots.get(plotIndex).isOccupied();
 * 
 * 4. @Override public Optional<CropSnapshot> getCropSnapshot(int plotIndex)
 *    Logika Implementasi:
 *      if (!isValidIndex(plotIndex)) return Optional.empty();
 *      return plots.get(plotIndex).getCropSnapshot();
 * 
 * 5. @Override public OperationResult<Void> placeCrop(int plotIndex, Object crop)
 *    Logika Implementasi:
 *      // TODO U01: Validasi plotIndex dan pastikan petak tidak sedang terisi tanaman.
 *      // Jika valid, masukkan tanaman ke petak dan kembalikan OperationResult.ok().
 *      // Jika tidak valid, kembalikan OperationResult.failed dengan kode yang sesuai.
 *      if (!isValidIndex(plotIndex)) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid: " + plotIndex);
 *      }
 *      AbstractFarmPlot plot = plots.get(plotIndex);
 *      if (plot.isOccupied()) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Petak #" + plotIndex + " sudah terisi");
 *      }
 *      plot.placeCrop(crop);
 *      return OperationResult.ok();
 * 
 * 6. @Override public OperationResult<Object> takeCrop(int plotIndex)
 *    Logika Implementasi:
 *      // TODO U01: Validasi plotIndex dan pastikan petak terisi.
 *      // Hapus tanaman dari petak dan kembalikan objek tanaman tersebut di dalam OperationResult.ok(crop).
 *      if (!isValidIndex(plotIndex)) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid");
 *      }
 *      AbstractFarmPlot plot = plots.get(plotIndex);
 *      if (!plot.isOccupied()) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Petak #" + plotIndex + " kosong");
 *      }
 *      Object removed = plot.removeCrop();
 *      return OperationResult.ok(removed);
 * 
 * 7. @Override public OperationResult<Void> clearPlot(int plotIndex)
 *    Logika Implementasi:
 *      if (!isValidIndex(plotIndex)) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid");
 *      }
 *      plots.get(plotIndex).clear();
 *      return OperationResult.ok();
 * 
 * 8. @Override public boolean isPlotMoist(int plotIndex)
 *    Logika Implementasi:
 *      if (!isValidIndex(plotIndex)) return false;
 *      return plots.get(plotIndex).isMoist();
 * 
 * 9. @Override public OperationResult<Void> waterPlot(int plotIndex)
 *    Logika Implementasi:
 *      // TODO U01: Validasi plotIndex. Jika sudah lembap, kembalikan failed(ALREADY_COMPLETED).
 *      // Jika belum, set status moist menjadi true.
 *      if (!isValidIndex(plotIndex)) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid");
 *      }
 *      AbstractFarmPlot plot = plots.get(plotIndex);
 *      if (plot.isMoist()) {
 *          return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Petak #" + plotIndex + " sudah lembap (tersiram air hujan atau sudah disiram hari ini)");
 *      }
 *      plot.setMoist(true);
 *      return OperationResult.ok();
 * 
 * 10. @Override public void resetDailyMoisture()
 *    Logika Implementasi:
 *      for (AbstractFarmPlot plot : plots) {
 *          plot.setMoist(false);
 *      }
 * 
 * 11. @Override public int getMaxPlots()
 *    Logika Implementasi:
 *      return maxPlots;
 * 
 * 12. @Override public int getCurrentPlots()
 *    Logika Implementasi:
 *      return plots.size();
 * 
 * 13. @Override public OperationResult<Void> expandPlots(int count)
 *    Logika Implementasi:
 *      // TODO U01: Validasi count. Pastikan plots.size() + count <= maxPlots.
 *      if (count <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Jumlah ekspansi harus lebih dari 0");
 *      }
 *      if (plots.size() + count > maxPlots) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Melebihi batas maksimum petak (" + maxPlots + ")");
 *      }
 *      for (int i = 0; i < count; i++) {
 *          plots.add(new OutdoorCropPlot(plots.size()));
 *      }
 *      return OperationResult.ok();
 * 
 * 14. @Override public OperationResult<Void> convertToProtectedPlot(int plotIndex)
 *    Logika Implementasi:
 *      // TODO U01: Mengubah petak luar ruang yang kosong menjadi ProtectedCropPlot.
 *      if (!isValidIndex(plotIndex)) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Indeks petak tidak valid");
 *      }
 *      AbstractFarmPlot current = plots.get(plotIndex);
 *      if (current.isOccupied()) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Hanya petak kosong yang dapat di-upgrade ke Protected Plot");
 *      }
 *      ProtectedCropPlot protectedPlot = new ProtectedCropPlot(plotIndex);
 *      plots.set(plotIndex, protectedPlot);
 *      return OperationResult.ok();
 * 
 * 15. public void applyDailyWeather(boolean isRaining)
 *    Logika Implementasi:
 *      // TODO U01: Terapkan efek cuaca secara polimorfik ke setiap petak lahan
 *      for (AbstractFarmPlot plot : plots) {
 *          plot.applyWeather(isRaining);
 *      }
 * 
 * 16. public AbstractFarmPlot getPlot(int plotIndex)
 *    Logika Implementasi:
 *      if (!isValidIndex(plotIndex)) return null;
 *      return plots.get(plotIndex);
 * 
 * 17. private boolean isValidIndex(int index)
 *    Logika Implementasi:
 *      return index >= 0 && index < plots.size();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

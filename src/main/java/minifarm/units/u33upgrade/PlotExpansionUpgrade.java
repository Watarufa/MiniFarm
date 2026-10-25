package minifarm.units.u33upgrade;

import minifarm.core.api.OperationResult;
import minifarm.core.api.PlotCapacityPort;
import minifarm.core.api.ResultCode;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): PlotExpansionUpgrade
 * ================================================================================================
 * Modul Unit: U33UPGRADE
 * 
 * Deskripsi Kelas:
 * Upgrade penambahan 1 petak lahan baru.
 * Rumus biaya: 100 * (jumlah ekspansi sebelumnya + 1) koin. Maksimum 8 petak.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class PlotExpansionUpgrade
 * - Superclass (Pewarisan) : extends AbstractFarmUpgrade
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final PlotCapacityPort plotCapacityPort;
 * 2. private int expansionCount = 0;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public PlotExpansionUpgrade(PlotCapacityPort plotCapacityPort)
 *    Logika Implementasi:
 *      super("upgrade_plot_expansion", "Plot Expansion");
 *      this.plotCapacityPort = plotCapacityPort;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculateCost()
 *    Logika Implementasi:
 *      return 100L * (expansionCount + 1);
 * 
 * 2. @Override public boolean isMaxLevel()
 *    Logika Implementasi:
 *      return plotCapacityPort.getCurrentPlots() >= plotCapacityPort.getMaxPlots();
 * 
 * 3. @Override public OperationResult<Void> apply()
 *    Logika Implementasi:
 *      if (isMaxLevel()) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Batas maksimum petak (" + plotCapacityPort.getMaxPlots() + ") telah tercapai");
 *      }
 *      OperationResult<Void> res = plotCapacityPort.expandPlots(1);
 *      if (res.isSuccess()) {
 *          expansionCount++;
 *      }
 *      return res;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

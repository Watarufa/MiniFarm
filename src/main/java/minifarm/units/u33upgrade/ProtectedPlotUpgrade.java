package minifarm.units.u33upgrade;

import minifarm.core.api.OperationResult;
import minifarm.core.api.PlotCapacityPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ProtectedPlotUpgrade
 * ================================================================================================
 * Modul Unit: U33UPGRADE
 * 
 * Deskripsi Kelas:
 * Upgrade petak kosong menjadi Protected Crop Plot (rumah kaca). Biaya: 200 koin.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ProtectedPlotUpgrade
 * - Superclass (Pewarisan) : extends AbstractFarmUpgrade
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final PlotCapacityPort plotCapacityPort;
 * 2. private int targetPlotIndex = 0;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ProtectedPlotUpgrade(PlotCapacityPort plotCapacityPort)
 *    Logika Implementasi:
 *      super("upgrade_protected_plot", "Greenhouse Protected Plot");
 *      this.plotCapacityPort = plotCapacityPort;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setTargetPlotIndex(int targetPlotIndex)
 *    Logika Implementasi:
 *      this.targetPlotIndex = targetPlotIndex;
 * 
 * 2. @Override public long calculateCost()
 *    Logika Implementasi:
 *      return 200L;
 * 
 * 3. @Override public boolean isMaxLevel()
 *    Logika Implementasi:
 *      return false;
 * 
 * 4. @Override public OperationResult<Void> apply()
 *    Logika Implementasi:
 *      return plotCapacityPort.convertToProtectedPlot(targetPlotIndex);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

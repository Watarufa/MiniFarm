package minifarm.units.u12toolmaintenance;

import minifarm.core.api.OperationResult;
import minifarm.core.api.WalletPort;
import minifarm.core.api.MaintainableTool;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ToolMaintenanceService
 * ================================================================================================
 * Modul Unit: U12TOOLMAINTENANCE
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U12: Perawatan dan Upgrade Alat.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ToolMaintenanceService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final RepairAction repairAction = new RepairAction();
 * 2. private final UpgradeAction upgradeAction = new UpgradeAction();
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public OperationResult<Void> repairTool(MaintainableTool tool, WalletPort walletPort)
 *    Logika Implementasi:
 *      // TODO U12: Delegasikan aksi perbaikan ke repairAction.execute(tool, walletPort)
 *      return repairAction.execute(tool, walletPort);
 * 
 * 2. public OperationResult<Void> upgradeTool(MaintainableTool tool, WalletPort walletPort)
 *    Logika Implementasi:
 *      // TODO U12: Delegasikan aksi upgrade ke upgradeAction.execute(tool, walletPort)
 *      return upgradeAction.execute(tool, walletPort);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

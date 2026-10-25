package minifarm.units.u12toolmaintenance;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.api.MaintainableTool;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): UpgradeAction
 * ================================================================================================
 * Modul Unit: U12TOOLMAINTENANCE
 * 
 * Deskripsi Kelas:
 * Aksi peningkatan level alat (Upgrade): menaikkan level alat 1 tingkat.
 * Biaya upgrade: 50 koin * level saat ini. Maksimum level: 3.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class UpgradeAction
 * - Superclass (Pewarisan) : extends AbstractMaintenanceAction
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public static final int MAX_TOOL_LEVEL = 3;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public UpgradeAction()
 *    Logika Implementasi:
 *      super("Upgrade Tool");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculateCost(MaintainableTool tool)
 *    Logika Implementasi:
 *      if (tool == null) return 0;
 *      return 50L * tool.getLevel();
 * 
 * 2. @Override public OperationResult<Void> execute(MaintainableTool tool, WalletPort walletPort)
 *    Logika Implementasi:
 *      if (tool == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Alat tidak ditemukan");
 *      }
 *      if (tool.getLevel() >= MAX_TOOL_LEVEL) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Alat sudah mencapai level maksimum (" + MAX_TOOL_LEVEL + ")");
 *      }
 *      long cost = calculateCost(tool);
 *      if (walletPort.getBalance() < cost) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_FUNDS, "Saldo koin tidak cukup untuk upgrade (" + cost + " G)");
 *      }
 *      
 *      OperationResult<Void> debitRes = walletPort.debit(cost, "Upgrade " + tool.getToolName());
 *      if (debitRes.isFailure()) {
 *          return debitRes;
 *      }
 *      
 *      tool.setLevel(tool.getLevel() + 1);
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

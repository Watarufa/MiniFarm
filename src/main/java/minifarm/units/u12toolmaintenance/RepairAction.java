package minifarm.units.u12toolmaintenance;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.api.MaintainableTool;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): RepairAction
 * ================================================================================================
 * Modul Unit: U12TOOLMAINTENANCE
 * 
 * Deskripsi Kelas:
 * Aksi perbaikan alat (Repair): mengembalikan durability ke nilai maksimum.
 * Biaya perbaikan: 20 koin.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class RepairAction
 * - Superclass (Pewarisan) : extends AbstractMaintenanceAction
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public static final long REPAIR_COST = 20L;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public RepairAction()
 *    Logika Implementasi:
 *      super("Repair Tool");
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public long calculateCost(MaintainableTool tool)
 *    Logika Implementasi:
 *      return REPAIR_COST;
 * 
 * 2. @Override public OperationResult<Void> execute(MaintainableTool tool, WalletPort walletPort)
 *    Logika Implementasi:
 *      if (tool == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Alat tidak ditemukan");
 *      }
 *      if (tool.getDurability() >= tool.getMaxDurability()) {
 *          return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Alat masih dalam kondisi prima (durability penuh)");
 *      }
 *      if (walletPort.getBalance() < REPAIR_COST) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_FUNDS, "Saldo koin tidak cukup untuk perbaikan (" + REPAIR_COST + " G)");
 *      }
 *      
 *      OperationResult<Void> debitRes = walletPort.debit(REPAIR_COST, "Repair " + tool.getToolName());
 *      if (debitRes.isFailure()) {
 *          return debitRes;
 *      }
 *      
 *      tool.repair();
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

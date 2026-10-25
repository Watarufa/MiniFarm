package minifarm.units.u12toolmaintenance;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.api.MaintainableTool;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractMaintenanceAction
 * ================================================================================================
 * Modul Unit: U12TOOLMAINTENANCE
 * 
 * Deskripsi Kelas:
 * Kelas abstrak aksi perawatan dan upgrade alat (Polimorfik).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractMaintenanceAction
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String actionName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractMaintenanceAction(String actionName)
 *    Logika Implementasi:
 *      this.actionName = actionName;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getActionName()
 *    Logika Implementasi:
 *      return actionName;
 * 
 * 2. public abstract long calculateCost(MaintainableTool tool)
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 3. public abstract OperationResult<Void> execute(MaintainableTool tool, WalletPort walletPort)
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

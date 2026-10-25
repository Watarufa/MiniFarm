package minifarm.units.u11tool;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ToolEffectPort;
import java.util.HashMap;
import java.util.Map;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): ToolService
 * ================================================================================================
 * Modul Unit: U11TOOL
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U11: Jenis Alat dan Efek Penggunaan.
 * Mengimplementasikan ToolEffectPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class ToolService
 * - Interface yang Diimplementasikan: implements ToolEffectPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AbstractTool> tools = new HashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public ToolService()
 *    Logika Implementasi:
 *      registerTool(new Hoe());
 *      registerTool(new WateringCan());
 *      registerTool(new HarvestScythe());
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void registerTool(AbstractTool tool)
 *    Logika Implementasi:
 *      if (tool != null) {
 *          tools.put(tool.getToolId(), tool);
 *      }
 * 
 * 2. public AbstractTool getTool(String toolId)
 *    Logika Implementasi:
 *      if (toolId == null) return null;
 *      return tools.get(toolId.toLowerCase());
 * 
 * 3. @Override public boolean canUseTool(String toolId)
 *    Logika Implementasi:
 *      AbstractTool tool = getTool(toolId);
 *      return tool != null && tool.isUsable();
 * 
 * 4. @Override public int getDurability(String toolId)
 *    Logika Implementasi:
 *      AbstractTool tool = getTool(toolId);
 *      return tool != null ? tool.getDurability() : 0;
 * 
 * 5. @Override public int getToolLevel(String toolId)
 *    Logika Implementasi:
 *      AbstractTool tool = getTool(toolId);
 *      return tool != null ? tool.getLevel() : 1;
 * 
 * 6. @Override public OperationResult<Void> useTool(String toolId)
 *    Logika Implementasi:
 *      // TODO U11: Validasi keberadaan alat dan status isUsable(). Jika bisa, gunakan tool.use()
 *      AbstractTool tool = getTool(toolId);
 *      if (tool == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Alat tidak ditemukan: " + toolId);
 *      }
 *      if (!tool.isUsable()) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Alat rusak / durability 0: " + tool.getToolName());
 *      }
 *      
 *      tool.use();
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

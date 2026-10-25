package minifarm.core.api;

/**
 * Port integrasi domain untuk efektivitas dan penggunaan alat pertanian.
 */
public interface ToolEffectPort {
    boolean canUseTool(String toolId);
    int getDurability(String toolId);
    int getToolLevel(String toolId);
    OperationResult<Void> useTool(String toolId);
}


package minifarm.core.api;

/**
 * Port integrasi domain untuk perbaikan (repair) dan upgrade level alat.
 */
public interface MaintainableToolPort {
    OperationResult<Void> repairTool(String toolId);
    OperationResult<Void> upgradeTool(String toolId);
    int getMaxDurability(String toolId);
}


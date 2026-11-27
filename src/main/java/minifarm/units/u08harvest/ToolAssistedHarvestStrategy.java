package minifarm.units.u08harvest;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ToolEffectPort;

public class ToolAssistedHarvestStrategy extends AbstractHarvestStrategy {

    public ToolAssistedHarvestStrategy() {
        super("Tool-Assisted Harvest", 3);
    }

    @Override
    public int calculateFinalYield(int baseYield, boolean hasSoilBonus, ToolEffectPort toolPort) {
        int bonus = hasSoilBonus ? 1 : 0;
        if (toolPort != null && toolPort.getToolLevel("scythe") >= 2) {
            bonus += 1; // Bonus level alat
        }
        return baseYield + bonus;
    }

    @Override
    public OperationResult<Void> validateRequirements(EnergyPort energyPort, ToolEffectPort toolPort) {
        if (toolPort == null || !toolPort.canUseTool("scythe")) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Scythe tidak tersedia atau rusak");
        }
        if (energyPort.getCurrentEnergy() < getEnergyCost()) {
            return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi untuk panen alat");
        }
        return OperationResult.ok();
    }
}

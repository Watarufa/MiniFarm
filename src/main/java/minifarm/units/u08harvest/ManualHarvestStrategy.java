package minifarm.units.u08harvest;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ToolEffectPort;
import minifarm.core.config.GameConfig;

public class ManualHarvestStrategy extends AbstractHarvestStrategy {

    public ManualHarvestStrategy() {
        super("Manual Harvest", GameConfig.ENERGY_COST_HARVEST);
    }

    @Override
    public int calculateFinalYield(int baseYield, boolean hasSoilBonus, ToolEffectPort toolPort) {
        return baseYield + (hasSoilBonus ? 1 : 0);
    }

    @Override
    public OperationResult<Void> validateRequirements(EnergyPort energyPort, ToolEffectPort toolPort) {
        if (energyPort.getCurrentEnergy() < getEnergyCost()) {
            return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi untuk panen manual");
        }
        return OperationResult.ok();
    }
}

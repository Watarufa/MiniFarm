package minifarm.units.u08harvest;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ToolEffectPort;

public abstract class AbstractHarvestStrategy {
    private final String strategyName;
    private final int energyCost;

    protected AbstractHarvestStrategy(String strategyName, int energyCost) {
        this.strategyName = strategyName;
        this.energyCost = energyCost;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public abstract int calculateFinalYield(int baseYield, boolean hasSoilBonus, ToolEffectPort toolPort);

    public abstract OperationResult<Void> validateRequirements(EnergyPort energyPort, ToolEffectPort toolPort);
}

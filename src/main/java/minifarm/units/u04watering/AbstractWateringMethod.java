package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;

public abstract class AbstractWateringMethod implements WateringMethod {

    private final String methodName;
    private final int energyCost;

    protected AbstractWateringMethod(String methodName, int energyCost) {
        if (energyCost < 0) {
            throw new IllegalArgumentException("Biaya energi tidak boleh negatif");
        }
        this.methodName = methodName;
        this.energyCost = energyCost;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }

    @Override
    public int getEnergyCost() {
        return energyCost;
    }

    protected OperationResult<Void> validateAndConsumeEnergy(EnergyPort energyPort) {
        if (energyPort.getCurrentEnergy() < energyCost) {
            return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak cukup untuk menyiram");
        }
        return energyPort.consumeEnergy(energyCost);
    }
}

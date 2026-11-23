package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.WaterablePlotPort;

public interface WateringMethod {

    String getMethodName();

    int getEnergyCost();

    OperationResult<Void> executeWatering(int targetPlotIndex, WaterablePlotPort plotPort, EnergyPort energyPort);
}

package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WaterablePlotPort;

public class AreaWatering extends AbstractWateringMethod {

    public AreaWatering() {
        super("Area Watering", 12);
    }

    @Override
    public OperationResult<Void> executeWatering(int targetPlotIndex, WaterablePlotPort plotPort, EnergyPort energyPort) {
        if (energyPort.getCurrentEnergy() < getEnergyCost()) {
            return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak cukup untuk area watering");
        }
        OperationResult<Void> res = plotPort.waterPlot(targetPlotIndex);
        if (res.isFailure() && res.getCode() != ResultCode.ALREADY_COMPLETED) {
            return res;
        }
        // Coba siram petak tetangga jika valid
        plotPort.waterPlot(targetPlotIndex + 1);

        return energyPort.consumeEnergy(getEnergyCost());
    }
}

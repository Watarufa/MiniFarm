package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WaterablePlotPort;
import minifarm.core.config.GameConfig;

public class SinglePlotWatering extends AbstractWateringMethod {

    public SinglePlotWatering() {
        super("Single Plot", GameConfig.ENERGY_COST_WATER);
    }

    @Override
    public OperationResult<Void> executeWatering(int targetPlotIndex, WaterablePlotPort plotPort, EnergyPort energyPort) {
        if (plotPort.isPlotMoist(targetPlotIndex)) {
            return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Petak sudah lembap (tersiram air hujan atau sudah disiram hari ini)");
        }
        if (energyPort.getCurrentEnergy() < getEnergyCost()) {
            return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak mencukupi untuk menyiram");
        }

        OperationResult<Void> waterRes = plotPort.waterPlot(targetPlotIndex);
        if (waterRes.isFailure()) {
            return waterRes;
        }

        return energyPort.consumeEnergy(getEnergyCost());
    }
}

package minifarm.units.u04watering;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ToolEffectPort;
import minifarm.core.api.WaterablePlotPort;

public class WateringService {

    private WateringMethod defaultMethod;

    public WateringService(WateringMethod defaultMethod) {
        this.defaultMethod = defaultMethod != null ? defaultMethod : new SinglePlotWatering();
    }

    public WateringService() {
        this(new SinglePlotWatering());
    }

    public void setMethod(WateringMethod method) {
        if (method != null) {
            this.defaultMethod = method;
        }
    }

    public OperationResult<Void> waterPlot(int plotIndex, WaterablePlotPort plotPort, EnergyPort energyPort, ToolEffectPort toolPort) {
        if (toolPort != null && !toolPort.canUseTool("watering_can")) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Watering can rusak / durability habis");
        }

        OperationResult<Void> result = defaultMethod.executeWatering(plotIndex, plotPort, energyPort);
        if (result.isSuccess() && toolPort != null) {
            toolPort.useTool("watering_can");
        }
        return result;
    }
}

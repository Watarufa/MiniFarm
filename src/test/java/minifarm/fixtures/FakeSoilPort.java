package minifarm.fixtures;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.SoilPort;
import minifarm.core.api.SoilSnapshot;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory test double untuk SoilPort.
 */
public class FakeSoilPort implements SoilPort {
    private final Map<Integer, Integer> fertilityMap = new HashMap<>();

    public FakeSoilPort() {
        for (int i = 0; i < 4; i++) {
            fertilityMap.put(i, 50);
        }
    }

    @Override
    public SoilSnapshot getSoilSnapshot(int plotIndex) {
        int fert = fertilityMap.getOrDefault(plotIndex, 50);
        return new SoilSnapshot(fert, false, "Loamy");
    }

    @Override
    public OperationResult<Void> applyFertilizer(int plotIndex, int boostAmount) {
        if (!fertilityMap.containsKey(plotIndex)) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Petak tidak valid");
        }
        int cur = fertilityMap.get(plotIndex);
        fertilityMap.put(plotIndex, Math.min(100, cur + boostAmount));
        return OperationResult.ok();
    }

    @Override
    public void applyFertilityDecay(int plotIndex) {
        if (fertilityMap.containsKey(plotIndex)) {
            int cur = fertilityMap.get(plotIndex);
            fertilityMap.put(plotIndex, Math.max(0, cur - 5));
        }
    }
}


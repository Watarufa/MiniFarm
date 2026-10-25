package minifarm.fixtures;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ToolEffectPort;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory test double untuk ToolEffectPort.
 */
public class FakeToolEffectPort implements ToolEffectPort {
    private final Map<String, Integer> durability = new HashMap<>();
    private final Map<String, Integer> levels = new HashMap<>();

    public FakeToolEffectPort() {
        durability.put("watering_can", 30);
        durability.put("hoe", 30);
        levels.put("watering_can", 1);
        levels.put("hoe", 1);
    }

    @Override
    public boolean canUseTool(String toolId) {
        return getDurability(toolId) > 0;
    }

    @Override
    public int getDurability(String toolId) {
        return durability.getOrDefault(toolId, 0);
    }

    @Override
    public int getToolLevel(String toolId) {
        return levels.getOrDefault(toolId, 1);
    }

    @Override
    public OperationResult<Void> useTool(String toolId) {
        int current = getDurability(toolId);
        if (current <= 0) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Alat rusak / durability habis");
        }
        durability.put(toolId, current - 1);
        return OperationResult.ok();
    }
}


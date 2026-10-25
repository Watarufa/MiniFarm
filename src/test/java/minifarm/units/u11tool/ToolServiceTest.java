package minifarm.units.u11tool;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.config.GameConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U11")
@Tag("unit")
class ToolServiceTest {

    private ToolService toolService;

    @BeforeEach
    void setUp() {
        toolService = new ToolService();
    }

    @Test
    @DisplayName("Durability alat berkurang tepat 1 saat alat digunakan")
    void useTool_decreasesDurabilityByOne() {
        int initial = toolService.getDurability(GameConfig.TOOL_HOE);
        OperationResult<Void> result = toolService.useTool(GameConfig.TOOL_HOE);

        assertTrue(result.isSuccess());
        assertEquals(initial - 1, toolService.getDurability(GameConfig.TOOL_HOE));
    }

    @Test
    @DisplayName("Alat dengan durability 0 menolak penggunaan (rusak)")
    void useTool_whenBroken_fails() {
        AbstractTool can = toolService.getTool(GameConfig.TOOL_WATERING_CAN);
        // Habiskan durability
        while (can.isUsable()) {
            can.use();
        }
        assertEquals(0, can.getDurability());
        assertFalse(toolService.canUseTool(GameConfig.TOOL_WATERING_CAN));

        OperationResult<Void> result = toolService.useTool(GameConfig.TOOL_WATERING_CAN);
        assertTrue(result.isFailure());
        assertEquals(ResultCode.INVALID_STATE, result.getCode());
    }

    @Test
    @DisplayName("Bukti Polymorphism: HarvestScythe memiliki effect multiplier lebih tinggi dari Hoe")
    void polymorphicTools_differInEffectMultiplier() {
        AbstractTool hoe = toolService.getTool(GameConfig.TOOL_HOE);
        AbstractTool scythe = toolService.getTool("scythe");

        assertEquals(1.0, hoe.getEffectMultiplier());
        assertEquals(1.5, scythe.getEffectMultiplier());
    }
}


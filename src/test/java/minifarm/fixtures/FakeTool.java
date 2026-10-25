package minifarm.fixtures;

import minifarm.core.api.MaintainableTool;

/**
 * In-memory test double untuk MaintainableTool agar U12 dapat diuji tanpa bergantung pada U11.
 */
public class FakeTool implements MaintainableTool {
    private final String toolId;
    private final String toolName;
    private int durability;
    private final int maxDurability;
    private int level;

    public FakeTool(String toolId, String toolName, int initialDurability, int maxDurability, int level) {
        this.toolId = toolId;
        this.toolName = toolName;
        this.durability = initialDurability;
        this.maxDurability = maxDurability;
        this.level = Math.max(1, level);
    }

    public FakeTool(String toolId, String toolName, int maxDurability) {
        this(toolId, toolName, maxDurability, maxDurability, 1);
    }

    public FakeTool() {
        this("fake_tool", "Fake Tool", 30);
    }

    @Override
    public String getToolId() {
        return toolId;
    }

    @Override
    public String getToolName() {
        return toolName;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public int getMaxDurability() {
        return maxDurability;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void repair() {
        this.durability = maxDurability;
    }

    public boolean use() {
        if (durability <= 0) return false;
        durability--;
        return true;
    }

    public double getEffectMultiplier() {
        return 1.0;
    }
}

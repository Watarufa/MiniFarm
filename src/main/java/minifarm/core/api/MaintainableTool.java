package minifarm.core.api;

/**
 * Kontrak abstraksi alat yang dapat dirawat (repair) dan ditingkatkan levelnya (upgrade).
 */
public interface MaintainableTool {
    String getToolId();
    String getToolName();
    int getDurability();
    int getMaxDurability();
    int getLevel();
    void setLevel(int level);
    void repair();
}


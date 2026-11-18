package minifarm.units.u02crop;

import minifarm.core.config.GameConfig;

/**
 * Model tanaman jagung (Corn).
 */
public class CornCrop extends AbstractCrop {

    public CornCrop(String cropId) {
        super(cropId, GameConfig.CROP_CORN);
    }

    @Override
    public int daysToMature() {
        return GameConfig.CORN_GROWTH_DAYS;
    }

    @Override
    public int baseYield() {
        return GameConfig.CORN_BASE_YIELD;
    }
}
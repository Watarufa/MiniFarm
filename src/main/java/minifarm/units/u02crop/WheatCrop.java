package minifarm.units.u02crop;

import minifarm.core.config.GameConfig;

/**
 * Model tanaman gandum (Wheat).
 */
public class WheatCrop extends AbstractCrop {

    public WheatCrop(String cropId) {
        super(cropId, GameConfig.CROP_WHEAT);
    }

    @Override
    public int daysToMature() {
        return GameConfig.WHEAT_GROWTH_DAYS;
    }

    @Override
    public int baseYield() {
        return GameConfig.WHEAT_BASE_YIELD;
    }
}
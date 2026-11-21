package minifarm.units.u02crop;

import minifarm.core.config.GameConfig;

/**
 * Model tanaman tomat (Tomato).
 */
public class TomatoCrop extends AbstractCrop {

    public TomatoCrop(String cropId) {
        super(cropId, GameConfig.CROP_TOMATO);
    }

    @Override
    public int daysToMature() {
        return GameConfig.TOMATO_GROWTH_DAYS;
    }

    @Override
    public int baseYield() {
        return GameConfig.TOMATO_BASE_YIELD;
    }
}
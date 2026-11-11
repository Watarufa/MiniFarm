package minifarm.units.u17animalproduction;

import java.util.Optional;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;

// aturan produksi telur ayam
public class EggProductionRule extends AbstractAnimalProductionRule {

    public EggProductionRule() {
        // super ngirim jenis hewan ke constructor induk
        super("chicken");
    }

    // override: versi ayam dari aturan produksi harian
    @Override
    public Optional<ItemStack> calculateDailyProduction(AnimalSnapshot animal) {
        // ayam harus ada, udah dikasih makan dan kesehatannya di atas 50
        if (animal != null && animal.isFed() && animal.getHealth() > 50) {
            return Optional.of(new ItemStack(GameConfig.ITEM_EGG, 1));
        }
        return Optional.empty(); // syarat belum lengkap, jadi belum ada telur
    }
}


package minifarm.units.u17animalproduction;

import java.util.Optional;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.ItemStack;

// aturan produksi wol domba
public class WoolProductionRule extends AbstractAnimalProductionRule {

    public WoolProductionRule() {
        // super ngirim jenis hewan ke constructor induk
        super("sheep");
    }

    // override: versi domba dari aturan produksi harian
    @Override
    public Optional<ItemStack> calculateDailyProduction(AnimalSnapshot animal) {
        // domba harus ada, udh dikasih makan, dan kesehatannya di atas 50
        if (animal != null && animal.isFed() && animal.getHealth() > 50) {
            return Optional.of(new ItemStack("wool", 1));
        }
        return Optional.empty(); // syarat belum lengkap, jadi belum ada wol
    }
}


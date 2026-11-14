package minifarm.units.u17animalproduction;

import java.util.Optional;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.ItemStack;

// aturan produksi susu sapi
public class MilkProductionRule extends AbstractAnimalProductionRule {

    public MilkProductionRule() {
        // super ngirim jenis hewan ke constructor induk
        super("cow");
    }

    // override: versi sapi dari aturan produksi harian
    @Override
    public Optional<ItemStack> calculateDailyProduction(AnimalSnapshot animal) {
        // sapi harus ada, udah dikasih makan dan kesehatannya di atas 50
        if (animal != null && animal.isFed() && animal.getHealth() > 50) {
            return Optional.of(new ItemStack("milk", 1));
        }
        return Optional.empty(); // syarat belum lengkap, jadi belum ada susu
    }
}


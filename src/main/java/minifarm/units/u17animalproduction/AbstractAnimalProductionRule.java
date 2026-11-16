package minifarm.units.u17animalproduction;

import java.util.Locale;
import java.util.Optional;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.ItemStack;

// abstract class: cetakan dasar buat aturan produksi tiap jenis hewan
// ga bisa di new lgsg, harus lewat aturan ayam, sapi / domba
public abstract class AbstractAnimalProductionRule {

    // species dibuat private final biar identitas aturan ga bisa diganti dari luar
    private final String species;

    // protected: constructor ini dipake kelas anak lewat super
    protected AbstractAnimalProductionRule(String species) {
        // validasi dulu supaya species gak null atau cuma berisi spasi
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Spesies tidak boleh kosong");
        }
        this.species = species.trim().toLowerCase(Locale.ROOT);
    }

    // getter: cara baca species yg fieldnya tetep private
    public String getSpecies() {
        return species;
    }

    // method abstract: tiap aturan hewan menentukan sendiri produk yg dihasilkan
    // optional kosong artinya hewan belum memenuhi syarat buat produksi
    public abstract Optional<ItemStack> calculateDailyProduction(AnimalSnapshot animal);
}


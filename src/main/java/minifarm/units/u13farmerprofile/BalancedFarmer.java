package minifarm.units.u13farmerprofile;

// petani serba bisa, semua aktivitas biaya energinya normal
// inheritance: extends AbstractFarmerProfile, jadi dapet name, specialization, getter, dan toSnapshot
public class BalancedFarmer extends AbstractFarmerProfile {

    public BalancedFarmer(String name) {
        // super ngirim data ke constructor induk
        // validasi nama juga otomatis jalan di sana
        super(name, "Balanced Farmer");
    }

    // override: isi method abstract dari induk sesuai profesi ini
    @Override
    public double getEnergyCostModifier(String actionType) {
        return 1.0; // gak ada diskon, gak ada tambahan biaya
    }
}
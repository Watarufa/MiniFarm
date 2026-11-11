package minifarm.units.u13farmerprofile;

// petani tanaman, hemat energi pas tanam, siram dan panen
// inheritance: extends AbstractFarmerProfile
public class CultivatorFarmer extends AbstractFarmerProfile {

    public CultivatorFarmer(String name) {
        super(name, "Cultivator");
    }

    // override: versi Cultivator dari getEnergyCostModifier
    @Override
    public double getEnergyCostModifier(String actionType) {
        // equalsIgnoreCase: huruf besar kecil gak ngaruh, Plant sama aja kaya plant
        // string literal ditaruh di depan biar aman kalau actionType nya null
        if ("plant".equalsIgnoreCase(actionType)
                || "water".equalsIgnoreCase(actionType)
                || "harvest".equalsIgnoreCase(actionType)) {
            return 0.8; // cuma bayar 80% dari biaya normal
        }
        return 1.0; // aksi lain tetap normal
    }
}
package minifarm.units.u13farmerprofile;

// petani ternak, hemat energi pas ngurus dan ngasih makan hewan
// inheritance: extends AbstractFarmerProfile
public class RancherFarmer extends AbstractFarmerProfile {

    public RancherFarmer(String name) {
        super(name, "Rancher");
    }

    // override: versi Rancher dari getEnergyCostModifier
    @Override
    public double getEnergyCostModifier(String actionType) {
        if ("animal_care".equalsIgnoreCase(actionType)
                || "feed".equalsIgnoreCase(actionType)) {
            return 0.7; // cuma bayar 70% dari biaya normal
        }
        return 1.0; // aksi di luar peternakan tetap normal
    }
}
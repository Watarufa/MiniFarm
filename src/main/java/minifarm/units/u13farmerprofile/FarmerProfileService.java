package minifarm.units.u13farmerprofile;

import minifarm.core.api.FarmerProfilePort;
import minifarm.core.api.FarmerSnapshot;

// pintu masuk (facade) unit U13 buat modul lain
// implements FarmerProfilePort: interface ini kontraknya, jadi method di dalamnya wajib dibikin
public class FarmerProfileService implements FarmerProfilePort {

    // tipenya induk (abstract class), jadi isinya bisa Balanced, Cultivator, atau Rancher
    private AbstractFarmerProfile currentProfile;

    public FarmerProfileService(AbstractFarmerProfile initialProfile) {
        // kalau profil awal null, pakai petani default biar service tetap siap dipakai
        if (initialProfile != null) {
            this.currentProfile = initialProfile;
        } else {
            this.currentProfile = new BalancedFarmer("Player");
        }
    }

    public FarmerProfileService() {
        // constructor tanpa parameter, langsung pakai petani default
        this(new BalancedFarmer("Player"));
    }

    public void setProfile(AbstractFarmerProfile profile) {
        // ganti profesi cuma kalau profil barunya gak null
        if (profile != null) {
            this.currentProfile = profile;
        }
    }

    public AbstractFarmerProfile getProfileEntity() {
        return currentProfile;
    }

    // method dari interface FarmerProfilePort
    @Override
    public FarmerSnapshot getProfile() {
        // nilai awalnya: energi 100 dari 100, koin 500
        return currentProfile.toSnapshot(100, 100, 500L);
    }

    // method dari interface FarmerProfilePort
    @Override
    public double getEnergyModifier(String actionType) {
        // polymorphism: yang jalan itu versi milik profesi yang lagi aktif
        // service gak perlu tau profesinya apa, tinggal panggil aja
        return currentProfile.getEnergyCostModifier(actionType);
    }
}
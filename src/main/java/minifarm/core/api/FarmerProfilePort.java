package minifarm.core.api;

/**
 * Port integrasi domain untuk membaca profil dan modifier karakter petani.
 */
public interface FarmerProfilePort {
    FarmerSnapshot getProfile();
    double getEnergyModifier(String actionType);
}


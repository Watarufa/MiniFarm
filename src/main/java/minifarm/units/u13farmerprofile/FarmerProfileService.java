package minifarm.units.u13farmerprofile;

import minifarm.core.api.FarmerProfilePort;
import minifarm.core.api.FarmerSnapshot;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): FarmerProfileService
 * ================================================================================================
 * Modul Unit: U13FARMERPROFILE
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U13: Profil dan Spesialisasi Petani.
 * Mengimplementasikan FarmerProfilePort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class FarmerProfileService
 * - Interface yang Diimplementasikan: implements FarmerProfilePort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private AbstractFarmerProfile currentProfile;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public FarmerProfileService(AbstractFarmerProfile initialProfile)
 *    Logika Implementasi:
 *      this.currentProfile = initialProfile != null ? initialProfile : new BalancedFarmer("Player");
 * 
 * 2. Constructor: public FarmerProfileService()
 *    Logika Implementasi:
 *      this(new BalancedFarmer("Player"));
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setProfile(AbstractFarmerProfile profile)
 *    Logika Implementasi:
 *      if (profile != null) {
 *          this.currentProfile = profile;
 *      }
 * 
 * 2. public AbstractFarmerProfile getProfileEntity()
 *    Logika Implementasi:
 *      return currentProfile;
 * 
 * 3. @Override public FarmerSnapshot getProfile()
 *    Logika Implementasi:
 *      return currentProfile.toSnapshot(100, 100, 500L);
 * 
 * 4. @Override public double getEnergyModifier(String actionType)
 *    Logika Implementasi:
 *      // TODO U13: Panggil modifier polimorfik dari currentProfile
 *      return currentProfile.getEnergyCostModifier(actionType);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

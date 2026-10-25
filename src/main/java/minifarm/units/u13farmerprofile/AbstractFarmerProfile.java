package minifarm.units.u13farmerprofile;

import minifarm.core.api.FarmerSnapshot;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractFarmerProfile
 * ================================================================================================
 * Modul Unit: U13FARMERPROFILE
 * 
 * Deskripsi Kelas:
 * Kelas abstrak profil petani dengan spesialisasi profesi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractFarmerProfile
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String name;
 * 2. private final String specialization;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractFarmerProfile(String name, String specialization)
 *    Logika Implementasi:
 *      if (name == null || name.trim().isEmpty()) {
 *          throw new IllegalArgumentException("Nama petani tidak boleh kosong");
 *      }
 *      this.name = name.trim();
 *      this.specialization = specialization;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getName()
 *    Logika Implementasi:
 *      return name;
 * 
 * 2. public String getSpecialization()
 *    Logika Implementasi:
 *      return specialization;
 * 
 * 3. public abstract double getEnergyCostModifier(String actionType)
 *    Keterangan / Tujuan: Modifier biaya stamina/energi berdasarkan spesialisasi profesi (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 4. public FarmerSnapshot toSnapshot(int energy, int maxEnergy, long coins)
 *    Logika Implementasi:
 *      return new FarmerSnapshot(name, specialization, energy, maxEnergy, coins);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

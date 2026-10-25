package minifarm.units.u05soil;

import minifarm.core.api.SoilSnapshot;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractSoilProfile
 * ================================================================================================
 * Modul Unit: U05SOIL
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar untuk profil tanah.
 * Mengontrol kesuburan (fertility), laju penurunan kesuburan (decay), dan efektivitas pupuk.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractSoilProfile
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String profileName;
 * 2. private int fertility;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractSoilProfile(String profileName, int initialFertility)
 *    Keterangan: 0 - 100
 *    Logika Implementasi:
 *      this.profileName = profileName;
 *      this.fertility = Math.max(0, Math.min(100, initialFertility));
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getProfileName()
 *    Logika Implementasi:
 *      return profileName;
 * 
 * 2. public int getFertility()
 *    Logika Implementasi:
 *      return fertility;
 * 
 * 3. public void setFertility(int fertility)
 *    Logika Implementasi:
 *      this.fertility = Math.max(0, Math.min(100, fertility));
 * 
 * 4. public void boostFertility(int amount)
 *    Logika Implementasi:
 *      if (amount > 0) {
 *          setFertility(this.fertility + amount);
 *      }
 * 
 * 5. public void decayFertility()
 *    Logika Implementasi:
 *      setFertility(this.fertility - getDecayRate());
 * 
 * 6. public SoilSnapshot toSnapshot(boolean isMoist)
 *    Logika Implementasi:
 *      return new SoilSnapshot(fertility, isMoist, profileName);
 * 
 * 7. public abstract int getDecayRate()
 *    Keterangan / Tujuan: Laju penurunan kesuburan tanah per siklus pertumbuhan (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 8. public abstract int getFertilizerEffect()
 *    Keterangan / Tujuan: Efek penambahan kesuburan dari pupuk (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

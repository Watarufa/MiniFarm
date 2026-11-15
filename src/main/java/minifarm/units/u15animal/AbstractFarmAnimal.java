package minifarm.units.u15animal;

import minifarm.core.api.AnimalSnapshot;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractFarmAnimal
 * ================================================================================================
 * Modul Unit: U15ANIMAL
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar model hewan ternak di MiniFarm.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractFarmAnimal
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String id;
 * 2. private final String species;
 * 3. private final String name;
 * 4. private int health;
 * 5. private boolean fed;
 *    Keterangan: 0 - 100
 * 6. private boolean clean;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractFarmAnimal(String id, String species, String name)
 *    Logika Implementasi:
 *      if (id == null || id.trim().isEmpty()) {
 *          throw new IllegalArgumentException("ID hewan tidak boleh kosong");
 *      }
 *      if (species == null || species.trim().isEmpty()) {
 *          throw new IllegalArgumentException("Species tidak boleh kosong");
 *      }
 *      if (name == null || name.trim().isEmpty()) {
 *          throw new IllegalArgumentException("Nama hewan tidak boleh kosong");
 *      }
 *      this.id = id.trim();
 *      this.species = species.trim().toLowerCase();
 *      this.name = name.trim();
 *      this.health = 100;
 *      this.fed = false;
 *      this.clean = true;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getId()
 *    Logika Implementasi:
 *      return id;
 * 
 * 2. public String getSpecies()
 *    Logika Implementasi:
 *      return species;
 * 
 * 3. public String getName()
 *    Logika Implementasi:
 *      return name;
 * 
 * 4. public int getHealth()
 *    Logika Implementasi:
 *      return health;
 * 
 * 5. public boolean isFed()
 *    Logika Implementasi:
 *      return fed;
 * 
 * 6. public void setFed(boolean fed)
 *    Logika Implementasi:
 *      this.fed = fed;
 * 
 * 7. public boolean isClean()
 *    Logika Implementasi:
 *      return clean;
 * 
 * 8. public void setClean(boolean clean)
 *    Logika Implementasi:
 *      this.clean = clean;
 * 
 * 9. public void applyHealthChange(int amount)
 *    Logika Implementasi:
 *      this.health = Math.max(0, Math.min(100, this.health + amount));
 * 
 * 10. public boolean isHealthy()
 *    Logika Implementasi:
 *      return health > 50;
 * 
 * 11. public AnimalSnapshot toSnapshot()
 *    Logika Implementasi:
 *      return new AnimalSnapshot(id, species, name, health, fed, clean);
 * 
 * 12. public abstract String getRequiredFeedItemId()
 *    Keterangan / Tujuan: ID item pakan yang diterima hewan ini (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 13. public abstract String getProducedItemId()
 *    Keterangan / Tujuan: ID produk harian yang dihasilkan jika sehat dan kenyang (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * 14. @Override public String toString()
 *    Logika Implementasi:
 *      return name + " (" + species + ", HP: " + health + ", Makan: " + fed + ")";
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

public abstract class AbstractFarmAnimal {
    private final String id;
    private final String species;
    private final String name;
    private int health;
    private boolean fed;
    private boolean clean;

    protected AbstractFarmAnimal(String id, String species, String name) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID hewan tidak boleh kosong");
        }
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species tidak boleh kosong");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama hewan tidak boleh kosong");
        }
        this.id = id.trim();
        this.species = species.trim().toLowerCase();
        this.name = name.trim();
        this.health = 100;
        this.fed = false;
        this.clean = true;
    }

    public String getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isFed() {
        return fed;
    }

    public void setFed(boolean fed) {
        this.fed = fed;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public void applyHealthChange(int amount) {
        this.health = Math.max(0, Math.min(100, this.health + amount));
    }

    public boolean isHealthy() {
        return health > 50;
    }

    public AnimalSnapshot toSnapshot() {
        return new AnimalSnapshot(id, species, name, health, fed, clean);
    }
  
    public abstract String getRequiredFeedItemId();
    
    public abstract String getProducedItemId();
  
    @Override 
    public String toString() { 
        return name + " (" + species + ", HP: " + health + ", Makan: " + fed + ")";
    }
}
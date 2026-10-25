package minifarm.units.u18housing;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractAnimalHousing
 * ================================================================================================
 * Modul Unit: U18HOUSING
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar kandang hewan (Animal Housing).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractAnimalHousing
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String housingId;
 * 2. private final String name;
 * 3. private int capacity;
 * 4. private final List<String> animalIds = new ArrayList<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractAnimalHousing(String housingId, String name, int initialCapacity)
 *    Logika Implementasi:
 *      if (initialCapacity <= 0) {
 *          throw new IllegalArgumentException("Kapasitas harus positif");
 *      }
 *      this.housingId = housingId;
 *      this.name = name;
 *      this.capacity = initialCapacity;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getHousingId()
 *    Logika Implementasi:
 *      return housingId;
 * 
 * 2. public String getName()
 *    Logika Implementasi:
 *      return name;
 * 
 * 3. public int getCapacity()
 *    Logika Implementasi:
 *      return capacity;
 * 
 * 4. public int getOccupiedCount()
 *    Logika Implementasi:
 *      return animalIds.size();
 * 
 * 5. public List<String> getAnimalIds()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(animalIds);
 * 
 * 6. public void expandCapacity(int extra)
 *    Logika Implementasi:
 *      if (extra > 0) {
 *          this.capacity += extra;
 *      }
 * 
 * 7. public OperationResult<Void> addAnimal(String animalId, String species)
 *    Logika Implementasi:
 *      if (!supportsSpecies(species)) {
 *          return OperationResult.failed(ResultCode.NOT_ALLOWED, name + " tidak dapat menampung spesies: " + species);
 *      }
 *      if (animalIds.size() >= capacity) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, name + " sudah penuh (Kapasitas: " + capacity + ")");
 *      }
 *      if (animalIds.contains(animalId)) {
 *          return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Hewan sudah berada di kandang ini");
 *      }
 *      animalIds.add(animalId);
 *      return OperationResult.ok();
 * 
 * 8. public OperationResult<Void> removeAnimal(String animalId)
 *    Logika Implementasi:
 *      if (!animalIds.remove(animalId)) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Hewan tidak ada di kandang ini: " + animalId);
 *      }
 *      return OperationResult.ok();
 * 
 * 9. public abstract boolean supportsSpecies(String species)
 *    Keterangan / Tujuan: Memeriksa apakah kandang mendukung spesies tertentu (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

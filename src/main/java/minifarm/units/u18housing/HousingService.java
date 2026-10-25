package minifarm.units.u18housing;

import minifarm.core.api.HousingCapacityPort;
import minifarm.core.api.HousingPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): HousingService
 * ================================================================================================
 * Modul Unit: U18HOUSING
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U18: Housing dan Kapasitas Hewan.
 * Mengimplementasikan HousingPort dan HousingCapacityPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class HousingService
 * - Interface yang Diimplementasikan: implements HousingPort, HousingCapacityPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AbstractAnimalHousing> housings = new LinkedHashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public HousingService()
 *    Logika Implementasi:
 *      Coop coop = new Coop();
 *      // Masukkan 2 ayam awal
 *      coop.addAnimal("chicken_1", "chicken");
 *      coop.addAnimal("chicken_2", "chicken");
 *      housings.put(coop.getHousingId(), coop);
 *      
 *      Barn barn = new Barn();
 *      housings.put(barn.getHousingId(), barn);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void registerHousing(AbstractAnimalHousing housing)
 *    Logika Implementasi:
 *      if (housing != null) {
 *          housings.put(housing.getHousingId(), housing);
 *      }
 * 
 * 2. public AbstractAnimalHousing getHousingEntity(String housingId)
 *    Logika Implementasi:
 *      if (housingId == null) return null;
 *      return housings.get(housingId.toLowerCase());
 * 
 * 3. @Override public int getCapacity(String housingId)
 *    Logika Implementasi:
 *      AbstractAnimalHousing h = getHousingEntity(housingId);
 *      return h != null ? h.getCapacity() : 0;
 * 
 * 4. @Override public int getOccupiedCount(String housingId)
 *    Logika Implementasi:
 *      AbstractAnimalHousing h = getHousingEntity(housingId);
 *      return h != null ? h.getOccupiedCount() : 0;
 * 
 * 5. @Override public boolean canAcceptSpecies(String housingId, String species)
 *    Logika Implementasi:
 *      AbstractAnimalHousing h = getHousingEntity(housingId);
 *      return h != null && h.supportsSpecies(species);
 * 
 * 6. @Override public OperationResult<Void> placeAnimal(String housingId, String animalId)
 *    Logika Implementasi:
 *      // TODO U18: Tempatkan hewan ke dalam kandang
 *      AbstractAnimalHousing h = getHousingEntity(housingId);
 *      if (h == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Kandang tidak ditemukan: " + housingId);
 *      }
 *      return h.addAnimal(animalId, "chicken");
 * 
 * 7. @Override public OperationResult<Void> removeAnimal(String housingId, String animalId)
 *    Logika Implementasi:
 *      AbstractAnimalHousing h = getHousingEntity(housingId);
 *      if (h == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Kandang tidak ditemukan: " + housingId);
 *      }
 *      return h.removeAnimal(animalId);
 * 
 * 8. @Override public List<String> getAnimalIdsInHousing(String housingId)
 *    Logika Implementasi:
 *      AbstractAnimalHousing h = getHousingEntity(housingId);
 *      return h != null ? h.getAnimalIds() : Collections.emptyList();
 * 
 * 9. @Override public OperationResult<Void> expandCapacity(String housingId, int additionalCapacity)
 *    Logika Implementasi:
 *      // TODO U18: Perbesar kapasitas kandang
 *      AbstractAnimalHousing h = getHousingEntity(housingId);
 *      if (h == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Kandang tidak ditemukan");
 *      }
 *      h.expandCapacity(additionalCapacity);
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

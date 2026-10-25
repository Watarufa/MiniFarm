package minifarm.units.u15animal;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.FarmAnimalPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AnimalService
 * ================================================================================================
 * Modul Unit: U15ANIMAL
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U15: Model Hewan Ternak.
 * Mengimplementasikan FarmAnimalPort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AnimalService
 * - Interface yang Diimplementasikan: implements FarmAnimalPort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AbstractFarmAnimal> animals = new LinkedHashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AnimalService()
 *    Logika Implementasi:
 *      // Data awal: 2 ayam
 *      register(new Chicken("chicken_1", "Clucky"));
 *      register(new Chicken("chicken_2", "Penny"));
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void register(AbstractFarmAnimal animal)
 *    Logika Implementasi:
 *      if (animal != null) {
 *          animals.put(animal.getId(), animal);
 *      }
 * 
 * 2. public AbstractFarmAnimal getAnimalEntity(String animalId)
 *    Logika Implementasi:
 *      if (animalId == null) return null;
 *      return animals.get(animalId);
 * 
 * 3. @Override public List<AnimalSnapshot> getAllAnimals()
 *    Logika Implementasi:
 *      List<AnimalSnapshot> list = new ArrayList<>();
 *      for (AbstractFarmAnimal a : animals.values()) {
 *          list.add(a.toSnapshot());
 *      }
 *      return Collections.unmodifiableList(list);
 * 
 * 4. @Override public Optional<AnimalSnapshot> getAnimal(String animalId)
 *    Logika Implementasi:
 *      AbstractFarmAnimal a = getAnimalEntity(animalId);
 *      return a != null ? Optional.of(a.toSnapshot()) : Optional.empty();
 * 
 * 5. @Override public OperationResult<Void> feedAnimal(String animalId, String feedItemId)
 *    Logika Implementasi:
 *      // TODO U15:
 *      // 1. Cari hewan berdasarkan animalId.
 *      // 2. Validasi pakan: apakah feedItemId cocok dengan animal.getRequiredFeedItemId().
 *      // 3. Jika cocok, set status animal.setFed(true).
 *      AbstractFarmAnimal animal = getAnimalEntity(animalId);
 *      if (animal == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Hewan tidak ditemukan: " + animalId);
 *      }
 *      if (animal.isFed()) {
 *          return OperationResult.failed(ResultCode.ALREADY_COMPLETED, animal.getName() + " sudah kenyang hari ini");
 *      }
 *      if (!animal.getRequiredFeedItemId().equalsIgnoreCase(feedItemId)) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Pakan tidak cocok. Butuh: " + animal.getRequiredFeedItemId());
 *      }
 *      
 *      animal.setFed(true);
 *      return OperationResult.ok();
 * 
 * 6. @Override public OperationResult<Void> careAnimal(String animalId, String careType)
 *    Logika Implementasi:
 *      AbstractFarmAnimal animal = getAnimalEntity(animalId);
 *      if (animal == null) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Hewan tidak ditemukan: " + animalId);
 *      }
 *      animal.setClean(true);
 *      animal.applyHealthChange(5);
 *      return OperationResult.ok();
 * 
 * 7. public void resetDailyAnimalState()
 *    Logika Implementasi:
 *      for (AbstractFarmAnimal a : animals.values()) {
 *          a.setFed(false);
 *      }
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

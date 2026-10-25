package minifarm.units.u16animalcare;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.FarmAnimalPort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;
import minifarm.core.events.AnimalFed;
import minifarm.core.events.EventBus;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AnimalCareService
 * ================================================================================================
 * Modul Unit: U16ANIMALCARE
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U16: Perawatan dan Pemberian Pakan Hewan.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AnimalCareService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AnimalCareService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 * 
 * 2. Constructor: public AnimalCareService()
 *    Logika Implementasi:
 *      this(null);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public OperationResult<Void> feedAnimal( String animalId, String feedItemId, int day, FarmAnimalPort animalPort, InventoryPort inventoryPort, EnergyPort energyPort )
 *    Logika Implementasi:
 *      // TODO U16: Eksekusi FeedAction dan publikasikan event AnimalFed jika berhasil
 *      FeedAction action = new FeedAction(feedItemId);
 *      OperationResult<Void> result = action.execute(animalId, animalPort, inventoryPort, energyPort);
 *      if (result.isSuccess() && eventBus != null) {
 *          eventBus.publish(new AnimalFed(day, animalId, feedItemId));
 *      }
 *      return result;
 * 
 * 2. public OperationResult<Void> performCare( AbstractAnimalCareAction action, String animalId, FarmAnimalPort animalPort, InventoryPort inventoryPort, EnergyPort energyPort )
 *    Logika Implementasi:
 *      if (action == null) {
 *          return OperationResult.ok();
 *      }
 *      return action.execute(animalId, animalPort, inventoryPort, energyPort);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

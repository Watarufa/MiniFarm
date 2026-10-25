package minifarm.units.u16animalcare;

import minifarm.core.api.*;
import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): FeedAction
 * ================================================================================================
 * Modul Unit: U16ANIMALCARE
 * 
 * Deskripsi Kelas:
 * Aksi memberi makan hewan (Feed): konsumsi 1 pakan dari inventaris dan 3 energi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class FeedAction
 * - Superclass (Pewarisan) : extends AbstractAnimalCareAction
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String feedItemId;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public FeedAction(String feedItemId)
 *    Logika Implementasi:
 *      super("Feed Animal", GameConfig.ENERGY_COST_ANIMAL_CARE);
 *      this.feedItemId = feedItemId != null ? feedItemId : GameConfig.ITEM_ANIMAL_FEED;
 * 
 * 2. Constructor: public FeedAction()
 *    Logika Implementasi:
 *      this(GameConfig.ITEM_ANIMAL_FEED);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> execute( String animalId, FarmAnimalPort animalPort, InventoryPort inventoryPort, EnergyPort energyPort )
 *    Logika Implementasi:
 *      // TODO U16:
 *      // 1. Validasi energi (energyPort.getCurrentEnergy() >= 3).
 *      // 2. Validasi stok pakan di inventory (inventoryPort.hasItem(feedItemId, 1)).
 *      // 3. Beri pakan ke hewan (animalPort.feedAnimal(animalId, feedItemId)).
 *      // 4. Jika sukses, potong 1 item pakan dan kurangi energi secara atomik!
 *      if (energyPort.getCurrentEnergy() < getEnergyCost()) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak cukup untuk memberi pakan");
 *      }
 *      if (!inventoryPort.hasItem(feedItemId, 1)) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ITEMS, "Pakan '" + feedItemId + "' tidak ada di inventaris");
 *      }
 *      
 *      OperationResult<Void> feedRes = animalPort.feedAnimal(animalId, feedItemId);
 *      if (feedRes.isFailure()) {
 *          return feedRes;
 *      }
 *      
 *      inventoryPort.removeItem(feedItemId, 1);
 *      energyPort.consumeEnergy(getEnergyCost());
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

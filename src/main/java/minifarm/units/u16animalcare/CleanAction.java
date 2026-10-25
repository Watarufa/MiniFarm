package minifarm.units.u16animalcare;

import minifarm.core.api.*;
import minifarm.core.config.GameConfig;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CleanAction
 * ================================================================================================
 * Modul Unit: U16ANIMALCARE
 * 
 * Deskripsi Kelas:
 * Aksi membersihkan kandang / hewan (Clean): konsumsi 3 energi.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CleanAction
 * - Superclass (Pewarisan) : extends AbstractAnimalCareAction
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public CleanAction()
 *    Logika Implementasi:
 *      super("Clean Animal", GameConfig.ENERGY_COST_ANIMAL_CARE);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> execute( String animalId, FarmAnimalPort animalPort, InventoryPort inventoryPort, EnergyPort energyPort )
 *    Logika Implementasi:
 *      if (energyPort.getCurrentEnergy() < getEnergyCost()) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_ENERGY, "Energi tidak cukup untuk membersihkan hewan");
 *      }
 *      OperationResult<Void> careRes = animalPort.careAnimal(animalId, "clean");
 *      if (careRes.isFailure()) {
 *          return careRes;
 *      }
 *      
 *      energyPort.consumeEnergy(getEnergyCost());
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

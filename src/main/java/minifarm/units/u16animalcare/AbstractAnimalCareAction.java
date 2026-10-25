package minifarm.units.u16animalcare;

import minifarm.core.api.EnergyPort;
import minifarm.core.api.FarmAnimalPort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractAnimalCareAction
 * ================================================================================================
 * Modul Unit: U16ANIMALCARE
 * 
 * Deskripsi Kelas:
 * Kelas abstrak aksi perawatan hewan ternak (Polimorfik).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractAnimalCareAction
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String actionName;
 * 2. private final int energyCost;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractAnimalCareAction(String actionName, int energyCost)
 *    Logika Implementasi:
 *      this.actionName = actionName;
 *      this.energyCost = energyCost;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getActionName()
 *    Logika Implementasi:
 *      return actionName;
 * 
 * 2. public int getEnergyCost()
 *    Logika Implementasi:
 *      return energyCost;
 * 
 * 3. public abstract OperationResult<Void> execute( String animalId, FarmAnimalPort animalPort, InventoryPort inventoryPort, EnergyPort energyPort )
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

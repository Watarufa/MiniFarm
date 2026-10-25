package minifarm.units.u25quest;

import minifarm.core.events.CropHarvested;
import minifarm.core.events.DomainEvent;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): HarvestQuest
 * ================================================================================================
 * Modul Unit: U25QUEST
 * 
 * Deskripsi Kelas:
 * Quest memanen tanaman tertentu dalam jumlah target.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class HarvestQuest
 * - Superclass (Pewarisan) : extends AbstractQuest
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String requiredCropType;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public HarvestQuest(String questId, String title, String cropType, int target, long reward)
 *    Logika Implementasi:
 *      super(questId, title, target, reward);
 *      this.requiredCropType = cropType.toLowerCase();
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public boolean handleEvent(DomainEvent event)
 *    Logika Implementasi:
 *      if (event instanceof CropHarvested harvest) {
 *          if (harvest.getCropType().equalsIgnoreCase(requiredCropType)) {
 *              advanceProgress(harvest.getQuantity());
 *              return true;
 *          }
 *      }
 *      return false;
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

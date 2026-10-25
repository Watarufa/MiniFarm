package minifarm.units.u26achievement;

import minifarm.core.api.ExperiencePort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.WalletPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): XpReward
 * ================================================================================================
 * Modul Unit: U26ACHIEVEMENT
 * 
 * Deskripsi Kelas:
 * Hadiah berupa Poin Pengalaman (XP).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class XpReward
 * - Superclass (Pewarisan) : extends AbstractReward
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String skillCategory;
 * 2. private final int xpAmount;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public XpReward(String skillCategory, int xpAmount)
 *    Logika Implementasi:
 *      super(xpAmount + " XP [" + skillCategory + "]");
 *      this.skillCategory = skillCategory;
 *      this.xpAmount = xpAmount;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> grant(WalletPort wallet, InventoryPort inventory, ExperiencePort experience)
 *    Logika Implementasi:
 *      if (experience != null) {
 *          experience.addExperience(skillCategory, xpAmount);
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

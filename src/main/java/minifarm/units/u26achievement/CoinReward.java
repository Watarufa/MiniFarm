package minifarm.units.u26achievement;

import minifarm.core.api.ExperiencePort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.OperationResult;
import minifarm.core.api.WalletPort;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CoinReward
 * ================================================================================================
 * Modul Unit: U26ACHIEVEMENT
 * 
 * Deskripsi Kelas:
 * Hadiah berupa Koin.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CoinReward
 * - Superclass (Pewarisan) : extends AbstractReward
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final long coins;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public CoinReward(long coins)
 *    Logika Implementasi:
 *      super(coins + " Coins");
 *      this.coins = coins;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. @Override public OperationResult<Void> grant(WalletPort wallet, InventoryPort inventory, ExperiencePort experience)
 *    Logika Implementasi:
 *      if (wallet != null) {
 *          return wallet.credit(coins, "Achievement Reward: " + coins + " Koin");
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

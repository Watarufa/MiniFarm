package minifarm.units.u25quest;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.events.DomainEvent;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AbstractQuest
 * ================================================================================================
 * Modul Unit: U25QUEST
 * 
 * Deskripsi Kelas:
 * Kelas abstrak dasar model tugas/quest pertanian (Polimorfik).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public abstract class AbstractQuest
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final String questId;
 * 2. private final String title;
 * 3. private final int target;
 * 4. private int currentProgress;
 * 5. private boolean completed;
 * 6. private final long rewardCoins;
 * 7. private boolean rewardClaimed;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: protected AbstractQuest(String questId, String title, int target, long rewardCoins)
 *    Logika Implementasi:
 *      if (target <= 0) throw new IllegalArgumentException("Target quest harus > 0");
 *      this.questId = questId;
 *      this.title = title;
 *      this.target = target;
 *      this.currentProgress = 0;
 *      this.completed = false;
 *      this.rewardCoins = rewardCoins;
 *      this.rewardClaimed = false;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public String getQuestId()
 *    Logika Implementasi:
 *      return questId;
 * 
 * 2. public String getTitle()
 *    Logika Implementasi:
 *      return title;
 * 
 * 3. public int getTarget()
 *    Logika Implementasi:
 *      return target;
 * 
 * 4. public int getCurrentProgress()
 *    Logika Implementasi:
 *      return currentProgress;
 * 
 * 5. public boolean isCompleted()
 *    Logika Implementasi:
 *      return completed;
 * 
 * 6. public boolean isRewardClaimed()
 *    Logika Implementasi:
 *      return rewardClaimed;
 * 
 * 7. public long getRewardCoins()
 *    Logika Implementasi:
 *      return rewardCoins;
 * 
 * 8. public void advanceProgress(int amount)
 *    Logika Implementasi:
 *      if (completed || amount <= 0) return;
 *      this.currentProgress = Math.min(target, this.currentProgress + amount);
 *      if (this.currentProgress >= target) {
 *          this.completed = true;
 *      }
 * 
 * 9. public OperationResult<Void> claimReward(WalletPort walletPort)
 *    Logika Implementasi:
 *      if (!completed) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Quest belum selesai");
 *      }
 *      if (rewardClaimed) {
 *          return OperationResult.failed(ResultCode.ALREADY_COMPLETED, "Hadiah quest sudah pernah diklaim");
 *      }
 *      rewardClaimed = true;
 *      walletPort.credit(rewardCoins, "Reward Quest: " + title);
 *      return OperationResult.ok();
 * 
 * 10. public abstract boolean handleEvent(DomainEvent event)
 *    Keterangan / Tujuan: Memeriksa apakah quest ini merespons event domain yang terjadi (Polimorfik).
 *    (Merupakan method abstract / method interface tanpa body)
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

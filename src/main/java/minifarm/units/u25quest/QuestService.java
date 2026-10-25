package minifarm.units.u25quest;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.events.DomainEvent;
import minifarm.core.events.EventBus;
import minifarm.core.events.QuestCompleted;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): QuestService
 * ================================================================================================
 * Modul Unit: U25QUEST
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U25: Quest dan Objektif.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class QuestService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AbstractQuest> quests = new LinkedHashMap<>();
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public QuestService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 *      // Quest bawaan MiniFarm
 *      registerQuest(new HarvestQuest("quest_wheat", "Panen Pertama Gandum", "wheat", 2, 50L));
 *      registerQuest(new AnimalProductQuest("quest_egg", "Koleksi Telur Segar", "egg", 2, 40L));
 *      registerQuest(new SaleValueQuest("quest_sales", "Pebisnis Pemula", 50, 60L));
 *      
 *      // Daftarkan listener ke event bus jika tersedia
 *      if (eventBus != null) {
 *          eventBus.subscribe(DomainEvent.class, this::onEvent);
 *      }
 * 
 * 2. Constructor: public QuestService()
 *    Logika Implementasi:
 *      this(null);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void registerQuest(AbstractQuest quest)
 *    Logika Implementasi:
 *      if (quest != null) {
 *          quests.put(quest.getQuestId(), quest);
 *      }
 * 
 * 2. public void onEvent(DomainEvent event)
 *    Logika Implementasi:
 *      // TODO U25: Teruskan event ke setiap quest yang belum selesai
 *      for (AbstractQuest q : quests.values()) {
 *          if (!q.isCompleted()) {
 *              boolean updated = q.handleEvent(event);
 *              if (updated && q.isCompleted() && eventBus != null) {
 *                  eventBus.publish(new QuestCompleted(event.getDay(), q.getQuestId(), q.getTitle()));
 *              }
 *          }
 *      }
 * 
 * 3. public List<AbstractQuest> getAllQuests()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(new ArrayList<>(quests.values()));
 * 
 * 4. public Optional<AbstractQuest> getQuest(String questId)
 *    Logika Implementasi:
 *      if (questId == null) return Optional.empty();
 *      return Optional.ofNullable(quests.get(questId));
 * 
 * 5. public OperationResult<Void> claimReward(String questId, WalletPort walletPort)
 *    Logika Implementasi:
 *      // TODO U25: Klaim hadiah quest yang sudah selesai secara idempotent
 *      Optional<AbstractQuest> opt = getQuest(questId);
 *      if (opt.isEmpty()) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Quest tidak ditemukan: " + questId);
 *      }
 *      return opt.get().claimReward(walletPort);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

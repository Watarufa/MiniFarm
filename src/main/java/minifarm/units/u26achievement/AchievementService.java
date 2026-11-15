package minifarm.units.u26achievement;

import minifarm.core.api.ExperiencePort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.WalletPort;
import minifarm.core.events.AchievementUnlocked;
import minifarm.core.events.DomainEvent;
import minifarm.core.events.EventBus;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AchievementService
 * ================================================================================================
 * Modul Unit: U26ACHIEVEMENT
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U26: Achievement dan Sistem Reward.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AchievementService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AchievementEntry> achievements = new LinkedHashMap<>();
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * INNER CLASS / STRUKTUR DATA BANTUAN:
 * ------------------------------------------------------------------------------------------------
 * Header: public static class AchievementEntry
 * Implementasi yang diharapkan:
 *   private final String id;
 *   private final String name;
 *   private final AbstractAchievementCondition condition;
 *   private final AbstractReward reward;
 *   private boolean unlocked;
 *   
 *   public AchievementEntry(String id, String name, AbstractAchievementCondition condition, AbstractReward reward) {
 *       this.id = id;
 *       this.name = name;
 *       this.condition = condition;
 *       this.reward = reward;
 *       this.unlocked = false;
 *   }
 *   
 *   public String getId() { return id; }
 *   public String getName() { return name; }
 *   public AbstractAchievementCondition getCondition() { return condition; }
 *   public AbstractReward getReward() { return reward; }
 *   public boolean isUnlocked() { return unlocked; }
 *   public void setUnlocked(boolean unlocked) { this.unlocked = unlocked; }
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AchievementService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 *      register(new AchievementEntry("ach_first_harvest", "Panen Pertama!", new FirstHarvestCondition(), new CoinReward(50L)));
 *      register(new AchievementEntry("ach_first_sale", "Pedagang Handal!", new FirstSaleCondition(), new CoinReward(100L)));
 *      register(new AchievementEntry("ach_first_animal_product", "Peternak Hebat!", new AnimalProductCondition(), new XpReward("animal", 25)));
 *      
 *      if (eventBus != null) {
 *          eventBus.subscribe(DomainEvent.class, this::onEvent);
 *      }
 * 
 * 2. Constructor: public AchievementService()
 *    Logika Implementasi:
 *      this(null);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void register(AchievementEntry entry)
 *    Logika Implementasi:
 *      if (entry != null) achievements.put(entry.getId(), entry);
 * 
 * 2. public void onEvent(DomainEvent event)
 *    Logika Implementasi:
 *      // TODO U26:
 *      // Cek setiap achievement yang belum terbuka.
 *      // Jika condition.isMetBy(event) == true, buka achievement dan publikasikan AchievementUnlocked
 *      for (AchievementEntry ach : achievements.values()) {
 *          if (!ach.isUnlocked() && ach.getCondition().isMetBy(event)) {
 *              ach.setUnlocked(true);
 *              if (eventBus != null) {
 *                  eventBus.publish(new AchievementUnlocked(event.getDay(), ach.getId(), ach.getName()));
 *              }
 *          }
 *      }
 * 
 * 3. public void applyPendingRewards(WalletPort wallet, InventoryPort inventory, ExperiencePort experience)
 *    Logika Implementasi:
 *      for (AchievementEntry ach : achievements.values()) {
 *          if (ach.isUnlocked()) {
 *              ach.getReward().grant(wallet, inventory, experience);
 *          }
 *      }
 * 
 * 4. public List<AchievementEntry> getAllAchievements()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(new ArrayList<>(achievements.values()));
 * 
 * 5. public Optional<AchievementEntry> getAchievement(String id)
 *    Logika Implementasi:
 *      if (id == null) return Optional.empty();
 *      return Optional.ofNullable(achievements.get(id));
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */


// Pintu utama fitur achievement
public class AchievementService {

    // LinkedHashMap supaya urutan sesuai saat didaftarkan
    private final Map<String, AchievementEntry> achievements = new LinkedHashMap<>();

    // Jalur pengiriman dan penerimaan event, bisa null
    private final EventBus eventBus;

    // Data untuk satu achievement
    public static class AchievementEntry {
        private final String id;
        private final String name;
        private final AbstractAchievementCondition condition;
        private final AbstractReward reward;

        // Penanda sudah terbuka atau belum
        private boolean unlocked;

        public AchievementEntry(String id, String name, AbstractAchievementCondition condition, AbstractReward reward) {
            this.id = id;
            this.name = name;
            this.condition = condition;
            this.reward = reward;
            // Awalnya selalu belum terbuka
            this.unlocked = false;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public AbstractAchievementCondition getCondition() { return condition; }
        public AbstractReward getReward() { return reward; }
        public boolean isUnlocked() { return unlocked; }
        public void setUnlocked(boolean unlocked) { this.unlocked = unlocked; }
    }

    public AchievementService(EventBus eventBus) {
        this.eventBus = eventBus;

        // Tiga achievement bawaan
        register(new AchievementEntry("ach_first_harvest", "Panen Pertama!", new FirstHarvestCondition(), new CoinReward(50L)));
        register(new AchievementEntry("ach_first_sale", "Pedagang Handal!", new FirstSaleCondition(), new CoinReward(100L)));
        register(new AchievementEntry("ach_first_animal_product", "Peternak Hebat!", new AnimalProductCondition(), new XpReward("animal", 25)));

        // Dengarkan semua event kalau event bus tersedia
        if (eventBus != null) {
            eventBus.subscribe(DomainEvent.class, this::onEvent);
        }
    }

    // Constructor tanpa event bus
    public AchievementService() {
        this(null);
    }

    // Tambah achievement, yang null diabaikan
    public void register(AchievementEntry entry) {
        if (entry != null) achievements.put(entry.getId(), entry);
    }

    // Dipanggil setiap ada event baru
    public void onEvent(DomainEvent event) {
        for (AchievementEntry ach : achievements.values()) {
            // Hanya achievement yang belum terbuka, jadi tidak terbuka dua kali
            if (!ach.isUnlocked() && ach.getCondition().isMetBy(event)) {
                ach.setUnlocked(true);
                // Umumkan bahwa achievement baru terbuka
                if (eventBus != null) {
                    eventBus.publish(new AchievementUnlocked(event.getDay(), ach.getId(), ach.getName()));
                }
            }
        }
    }

    // Beri hadiah untuk semua achievement yang sudah terbuka
    public void applyPendingRewards(WalletPort wallet, InventoryPort inventory, ExperiencePort experience) {
        for (AchievementEntry ach : achievements.values()) {
            if (ach.isUnlocked()) {
                // Tiap hadiah tahu cara memberikan dirinya sendiri
                ach.getReward().grant(wallet, inventory, experience);
            }
        }
    }

    public List<AchievementEntry> getAllAchievements() {
        // Daftar read only agar data asli aman
        return Collections.unmodifiableList(new ArrayList<>(achievements.values()));
    }

    public Optional<AchievementEntry> getAchievement(String id) {
        // Optional dipakai karena hasilnya bisa tidak ditemukan
        if (id == null) return Optional.empty();
        return Optional.ofNullable(achievements.get(id));
    }
}
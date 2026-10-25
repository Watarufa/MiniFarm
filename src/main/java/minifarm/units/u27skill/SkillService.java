package minifarm.units.u27skill;

import minifarm.core.api.ExperiencePort;
import minifarm.core.events.CropHarvested;
import minifarm.core.events.DomainEvent;
import minifarm.core.events.EventBus;
import minifarm.core.events.ItemSold;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SkillService
 * ================================================================================================
 * Modul Unit: U27SKILL
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U27: Skill dan Pengalaman.
 * Mengimplementasikan ExperiencePort.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SkillService
 * - Interface yang Diimplementasikan: implements ExperiencePort
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AbstractFarmSkill> skills = new LinkedHashMap<>();
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SkillService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 *      skills.put("crop", new CropSkill());
 *      skills.put("animal", new AnimalSkill());
 *      skills.put("trade", new TradingSkill());
 *      
 *      if (eventBus != null) {
 *          eventBus.subscribe(DomainEvent.class, this::onEvent);
 *      }
 * 
 * 2. Constructor: public SkillService()
 *    Logika Implementasi:
 *      this(null);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void onEvent(DomainEvent event)
 *    Logika Implementasi:
 *      // TODO U27:
 *      // Jika CropHarvested -> tambah XP ke skill "crop" (misal 10 XP)
 *      // Jika ItemSold -> tambah XP ke skill "trade" (misal 5 XP)
 *      if (event instanceof CropHarvested) {
 *          addExperience("crop", 10);
 *      } else if (event instanceof ItemSold) {
 *          addExperience("trade", 5);
 *      }
 * 
 * 2. @Override public int getLevel(String skillCategory)
 *    Logika Implementasi:
 *      AbstractFarmSkill skill = skills.get(skillCategory.toLowerCase());
 *      return skill != null ? skill.getLevel() : 1;
 * 
 * 3. @Override public int getExperience(String skillCategory)
 *    Logika Implementasi:
 *      AbstractFarmSkill skill = skills.get(skillCategory.toLowerCase());
 *      return skill != null ? skill.getCurrentXp() : 0;
 * 
 * 4. @Override public void addExperience(String skillCategory, int xpAmount)
 *    Logika Implementasi:
 *      AbstractFarmSkill skill = skills.get(skillCategory.toLowerCase());
 *      if (skill != null) {
 *          skill.addXp(xpAmount);
 *      }
 * 
 * 5. public List<AbstractFarmSkill> getAllSkills()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(new ArrayList<>(skills.values()));
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.core.api;

/**
 * Port integrasi domain untuk penambahan XP dan pengecekan level keahlian.
 */
public interface ExperiencePort {
    int getLevel(String skillCategory);
    int getExperience(String skillCategory);
    void addExperience(String skillCategory, int xpAmount);
}


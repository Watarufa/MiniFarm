package minifarm.core.api;

import java.util.Objects;

/**
 * Snapshot immutable status hewan ternak.
 */
public final class AnimalSnapshot {
    private final String id;
    private final String species;
    private final String name;
    private final int health;
    private final boolean fed;
    private final boolean clean;

    public AnimalSnapshot(String id, String species, String name, int health, boolean fed, boolean clean) {
        this.id = Objects.requireNonNull(id, "id tidak boleh null");
        this.species = Objects.requireNonNull(species, "species tidak boleh null");
        this.name = Objects.requireNonNull(name, "name tidak boleh null");
        this.health = Math.max(0, Math.min(100, health));
        this.fed = fed;
        this.clean = clean;
    }

    public String getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isFed() {
        return fed;
    }

    public boolean isClean() {
        return clean;
    }

    @Override
    public String toString() {
        return name + " [" + species + "] (HP: " + health + ", Makan: " + fed + ", Bersih: " + clean + ")";
    }
}


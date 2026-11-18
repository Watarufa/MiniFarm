package minifarm.units.u02crop;

import minifarm.core.api.CropSnapshot;
import minifarm.core.api.CropSnapshotProvider;

/**
 * Kelas abstrak dasar untuk semua jenis tanaman di MiniFarm.
 * Mendemonstrasikan Enkapsulasi, Abstraksi, dan Polimorfisme.
 */
public abstract class AbstractCrop implements CropSnapshotProvider {

    private final String cropId;
    private final String cropType;
    private int growthDay;
    private int health; // Rentang 0 - 100

    protected AbstractCrop(String cropId, String cropType) {
        if (cropId == null || cropId.trim().isEmpty()) {
            throw new IllegalArgumentException("cropId tidak boleh kosong");
        }
        if (cropType == null || cropType.trim().isEmpty()) {
            throw new IllegalArgumentException("cropType tidak boleh kosong");
        }
        this.cropId = cropId.trim();
        this.cropType = cropType.trim().toLowerCase();
        this.growthDay = 0;
        this.health = 100;
    }

    public String getCropId() {
        return cropId;
    }

    public String getCropType() {
        return cropType;
    }

    public int getGrowthDay() {
        return growthDay;
    }

    public int getHealth() {
        return health;
    }

    public boolean isMature() {
        return growthDay >= daysToMature();
    }

    public boolean isDead() {
        return health <= 0;
    }

    // Menambah satu hari pertumbuhan jika tanaman masih hidup dan belum matang
    public void grow() {
        if (!isDead() && !isMature()) {
            this.growthDay++;
        }
    }

    public void damage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0 && !isDead()) {
            this.health = Math.min(100, this.health + amount);
        }
    }

    @Override
    public CropSnapshot toSnapshot() {
        return new CropSnapshot(cropId, cropType, growthDay, daysToMature(), health, isMature());
    }

    // Jumlah hari tumbuh yang dibutuhkan hingga tanaman siap panen (Polimorfik)
    public abstract int daysToMature();

    // Jumlah panen dasar yang dihasilkan saat matang (Polimorfik)
    public abstract int baseYield();

    @Override
    public String toString() {
        return cropType + " (Hari " + growthDay + "/" + daysToMature() + ", HP: " + health + ")";
    }
}
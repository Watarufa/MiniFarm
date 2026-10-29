package minifarm.units.u01plot;

import minifarm.core.api.CropSnapshot;

import java.util.Optional;

/**
 * Kelas abstrak dasar yang merepresentasikan satu petak lahan pertanian (Farm Plot).
 * Mendemonstrasikan Enkapsulasi dan Abstraksi.
 */
public abstract class AbstractFarmPlot {
    private final int index;
    private Object crop; // Objek tanaman yang menempati petak (null jika kosong)
    private boolean moist; // Status kelembapan harian

    protected AbstractFarmPlot(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index petak tidak boleh negatif");
        }
        this.index = index;
        this.crop = null;
        this.moist = false;
    }

    public int getIndex() {
        return index;
    }

    public boolean isOccupied() {
        return crop != null;
    }

    public boolean isMoist() {
        return moist;
    }

    public void setMoist(boolean moist) {
        this.moist = moist;
    }

    public Object getCrop() {
        return crop;
    }

    public void placeCrop(Object crop) {
        if (isOccupied()) {
            throw new IllegalStateException("Petak sudah terisi tanaman");
        }
        if (crop == null) {
            throw new IllegalArgumentException("Tanaman tidak boleh null");
        }
        this.crop = crop;
    }

    public Object removeCrop() {
        if (!isOccupied()) {
            throw new IllegalStateException("Petak sedang kosong");
        }
        Object removed = this.crop;
        this.crop = null;
        return removed;
    }

    public void clear() {
        this.crop = null;
    }

    /**
     * Perilaku polimorfik: menentukan apakah petak ini terpengaruh oleh air hujan alami.
     */
    public abstract boolean receivesRain();

    /**
     * Menerapkan efek cuaca pada petak.
     */
    public abstract void applyWeather(boolean isRaining);

    /**
     * Mengambil snapshot tanaman (jika ada).
     */
    public Optional<CropSnapshot> getCropSnapshot() {
        if (crop == null) return Optional.empty();
        if (crop instanceof minifarm.core.api.CropSnapshotProvider csp) {
            return Optional.of(csp.toSnapshot());
        }
        return Optional.of(new CropSnapshot("crop_" + index, crop.toString(), 0, 2, 100, false));
    }
}


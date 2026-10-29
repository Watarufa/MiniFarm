package minifarm.units.u01plot;

/**
 * Petak lahan luar ruang (Outdoor).
 * Petak ini langsung terkena hujan alami saat cuaca RAINY.
 */
public class OutdoorCropPlot extends AbstractFarmPlot {

    public OutdoorCropPlot(int index) {
        super(index);
    }

    @Override
    public boolean receivesRain() {
        return true;
    }

    @Override
    public void applyWeather(boolean isRaining) {
        // TODO U01: Jika isRaining bernilai true, ubah status kelembapan petak (setMoist) menjadi true
        if (isRaining) {
            setMoist(true);
        }
    }

    @Override
    public String toString() {
        return "OutdoorPlot #" + getIndex() + (isOccupied() ? " [Terisi]" : " [Kosong]") + (isMoist() ? " [Lembap]" : "");
    }
}


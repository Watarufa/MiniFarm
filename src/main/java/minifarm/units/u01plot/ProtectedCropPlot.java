package minifarm.units.u01plot;

/**
 * Petak lahan berpelindung / rumah kaca (Protected Plot).
 * Petak ini terlindung dari cuaca luar dan TIDAK menerima hujan otomatis.
 */
public class ProtectedCropPlot extends AbstractFarmPlot {

    public ProtectedCropPlot(int index) {
        super(index);
    }

    @Override
    public boolean receivesRain() {
        return false;
    }

    @Override
    public void applyWeather(boolean isRaining) {
        // Protected plot terlindung dari air hujan, tidak otomatis lembap saat hujan
    }

    @Override
    public String toString() {
        return "ProtectedPlot #" + getIndex() + (isOccupied() ? " [Terisi]" : " [Kosong]") + (isMoist() ? " [Lembap]" : "");
    }
}


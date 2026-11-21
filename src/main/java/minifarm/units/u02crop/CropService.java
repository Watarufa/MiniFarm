package minifarm.units.u02crop;

import minifarm.core.api.CropSnapshot;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.UUID;

/**
 * Public Facade untuk Unit U02: Siklus Hidup Tanaman.
 */
public class CropService {

    // Membuat instance tanaman baru berdasarkan jenisnya
    public AbstractCrop createCrop(String cropType) {
        if (cropType == null) {
            throw new IllegalArgumentException("Jenis tanaman tidak boleh null");
        }
        String cropId = "crop_" + UUID.randomUUID().toString().substring(0, 8);
        return switch (cropType.trim().toLowerCase()) {
            case "wheat" -> new WheatCrop(cropId);
            case "corn" -> new CornCrop(cropId);
            case "tomato" -> new TomatoCrop(cropId);
            default -> throw new IllegalArgumentException("Jenis tanaman tidak dikenal: " + cropType);
        };
    }

    // Memproses pertumbuhan tanaman harian.
    // Tanaman hanya tumbuh jika kondisi petak lembap (isMoist = true) dan tanaman masih hidup.
    public OperationResult<Void> processCropGrowth(AbstractCrop crop, boolean isMoist) {
        if (crop == null) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Tanaman null");
        }
        if (crop.isDead()) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Tanaman telah mati");
        }
        if (!isMoist) {
            // Tanaman tidak tumbuh tanpa kelembapan
            return OperationResult.ok("Tanaman tidak tumbuh karena tanah kering", null);
        }

        crop.grow();
        return OperationResult.ok();
    }

    public CropSnapshot getSnapshot(AbstractCrop crop) {
        if (crop == null) throw new IllegalArgumentException("Crop tidak boleh null");
        return crop.toSnapshot();
    }
}
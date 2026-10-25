package minifarm.units.u02crop;

import minifarm.core.api.CropSnapshot;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.UUID;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): CropService
 * ================================================================================================
 * Modul Unit: U02CROP
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U02: Siklus Hidup Tanaman.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class CropService
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public AbstractCrop createCrop(String cropType)
 *    Keterangan / Tujuan: Membuat instance tanaman baru berdasarkan jenisnya.
 *    Logika Implementasi:
 *      String cropId = "crop_" + UUID.randomUUID().toString().substring(0, 8);
 *      return switch (cropType.toLowerCase()) {
 *          case "wheat" -> new WheatCrop(cropId);
 *          case "corn" -> new CornCrop(cropId);
 *          case "tomato" -> new TomatoCrop(cropId);
 *          default -> throw new IllegalArgumentException("Jenis tanaman tidak dikenal: " + cropType);
 *      };
 * 
 * 2. public OperationResult<Void> processCropGrowth(AbstractCrop crop, boolean isMoist)
 *    Keterangan / Tujuan: Memproses pertumbuhan tanaman harian. Tanaman hanya tumbuh jika kondisi petak lembap (isMoist = true) dan tanaman masih hidup.
 *    Logika Implementasi:
 *      if (crop == null) {
 *          return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Tanaman null");
 *      }
 *      if (crop.isDead()) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Tanaman telah mati");
 *      }
 *      if (!isMoist) {
 *          // Tanaman tidak tumbuh tanpa kelembapan
 *          return OperationResult.ok("Tanaman tidak tumbuh karena tanah kering", null);
 *      }
 *      
 *      // TODO U02: Panggil crop.grow() jika syarat terpenuhi
 *      crop.grow();
 *      return OperationResult.ok();
 * 
 * 3. public CropSnapshot getSnapshot(AbstractCrop crop)
 *    Logika Implementasi:
 *      if (crop == null) throw new IllegalArgumentException("Crop tidak boleh null");
 *      return crop.toSnapshot();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

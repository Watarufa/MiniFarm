package minifarm.units.u03seed;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): SeedCatalog
 * ================================================================================================
 * Modul Unit: U03SEED
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U03: Jenis Benih dan Katalog Benih.
 * Berfungsi sebagai contoh referensi implementasi lengkap (Role Model).
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class SeedCatalog
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, PlantableSeed> catalog = new LinkedHashMap<>();
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public SeedCatalog()
 *    Logika Implementasi:
 *      // Registrasi benih default MiniFarm
 *      registerSeed(new WheatSeed());
 *      registerSeed(new CornSeed());
 *      registerSeed(new TomatoSeed());
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void registerSeed(PlantableSeed seed)
 *    Keterangan / Tujuan: Mendaftarkan jenis benih baru ke dalam katalog.
 *    Logika Implementasi:
 *      if (seed == null) {
 *          throw new IllegalArgumentException("Seed tidak boleh null");
 *      }
 *      catalog.put(seed.getSeedId(), seed);
 * 
 * 2. public Optional<PlantableSeed> getSeed(String seedId)
 *    Keterangan / Tujuan: Mencari benih berdasarkan seedId.
 *    Logika Implementasi:
 *      if (seedId == null) {
 *          return Optional.empty();
 *      }
 *      return Optional.ofNullable(catalog.get(seedId.trim().toLowerCase()));
 * 
 * 3. public List<PlantableSeed> getAllSeeds()
 *    Keterangan / Tujuan: Mengembalikan daftar semua benih yang terdaftar dalam bentuk list unmodifiable.
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(new ArrayList<>(catalog.values()));
 * 
 * 4. public boolean containsSeed(String seedId)
 *    Keterangan / Tujuan: Memeriksa apakah seed ID terdaftar di katalog.
 *    Logika Implementasi:
 *      if (seedId == null) return false;
 *      return catalog.containsKey(seedId.trim().toLowerCase());
 * 
 * 5. public OperationResult<PlantableSeed> findSeed(String seedId)
 *    Keterangan / Tujuan: Mengambil metadata benih secara aman tanpa mutasi.
 *    Logika Implementasi:
 *      Optional<PlantableSeed> seedOpt = getSeed(seedId);
 *      if (seedOpt.isEmpty()) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Benih tidak ditemukan: " + seedId);
 *      }
 *      return OperationResult.ok(seedOpt.get());
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

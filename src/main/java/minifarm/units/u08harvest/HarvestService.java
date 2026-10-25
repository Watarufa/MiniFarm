package minifarm.units.u08harvest;

import minifarm.core.api.*;
import minifarm.core.config.GameConfig;
import minifarm.core.events.CropHarvested;
import minifarm.core.events.EventBus;
import java.util.Optional;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): HarvestService
 * ================================================================================================
 * Modul Unit: U08HARVEST
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U08: Proses Panen.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class HarvestService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private AbstractHarvestStrategy defaultStrategy;
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public HarvestService(AbstractHarvestStrategy defaultStrategy, EventBus eventBus)
 *    Logika Implementasi:
 *      this.defaultStrategy = defaultStrategy != null ? defaultStrategy : new ManualHarvestStrategy();
 *      this.eventBus = eventBus;
 * 
 * 2. Constructor: public HarvestService(EventBus eventBus)
 *    Logika Implementasi:
 *      this(new ManualHarvestStrategy(), eventBus);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void setStrategy(AbstractHarvestStrategy strategy)
 *    Logika Implementasi:
 *      if (strategy != null) {
 *          this.defaultStrategy = strategy;
 *      }
 * 
 * 2. public OperationResult<Integer> harvest( int plotIndex, int day, CropSlotPort slotPort, SoilPort soilPort, InventoryPort inventoryPort, EnergyPort energyPort, ToolEffectPort toolPort )
 *    Keterangan / Tujuan: Memanen tanaman dari petak secara atomik.
 *    Logika Implementasi:
 *      // TODO U08:
 *      // 1. Cek snapshot tanaman di slotPort.getCropSnapshot(plotIndex).
 *      // 2. Validasi tanaman: harus ada, masih hidup (health > 0), dan matang (isMature() == true).
 *      // 3. Validasi energi & alat melalui defaultStrategy.validateRequirements.
 *      // 4. Hitung hasil panen akhir (defaultStrategy.calculateFinalYield) termasuk bonus tanah kesuburan >= 80.
 *      // 5. Cek apakah inventory muat menerima hasil panen.
 *      // 6. Jika semua valid:
 *      //    - Tambahkan hasil ke inventaris
 *      //    - Kosongkan petak (slotPort.takeCrop)
 *      //    - Potong energi (energyPort.consumeEnergy)
 *      //    - Publikasikan event CropHarvested
 *      // 7. Jika salah satu gagal, pastikan state tetap utuh (atomik)!
 *      Optional<CropSnapshot> cropOpt = slotPort.getCropSnapshot(plotIndex);
 *      if (cropOpt.isEmpty()) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Petak kosong, tidak ada tanaman untuk dipanen");
 *      }
 *      CropSnapshot crop = cropOpt.get();
 *      if (crop.getHealth() <= 0) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Tanaman telah layu/mati dan tidak bisa dipanen");
 *      }
 *      if (!crop.isMature()) {
 *          return OperationResult.failed(ResultCode.INVALID_STATE, "Tanaman belum matang (Hari " + crop.getGrowthDay() + "/" + crop.getDaysToMature() + ")");
 *      }
 *      
 *      OperationResult<Void> reqCheck = defaultStrategy.validateRequirements(energyPort, toolPort);
 *      if (reqCheck.isFailure()) {
 *          return OperationResult.failed(reqCheck.getCode(), reqCheck.getMessage());
 *      }
 *      
 *      boolean soilBonus = soilPort != null && soilPort.getSoilSnapshot(plotIndex).getFertility() >= 80;
 *      
 *      // Tentukan base yield berdasarkan jenis tanaman (Corn: 3, Tomato: 2, Wheat: 2)
 *      int baseYield = switch (crop.getCropType().toLowerCase()) {
 *          case "corn" -> GameConfig.CORN_BASE_YIELD;
 *          case "tomato" -> GameConfig.TOMATO_BASE_YIELD;
 *          default -> GameConfig.WHEAT_BASE_YIELD;
 *      };
 *      
 *      int yieldCount = defaultStrategy.calculateFinalYield(baseYield, soilBonus, toolPort);
 *      
 *      // Uji coba penambahan ke inventory secara atomik
 *      if (inventoryPort.getAvailableSlots() <= 0 && !inventoryPort.hasItem(crop.getCropType(), 1)) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Slot inventaris penuh, panen dibatalkan");
 *      }
 *      
 *      OperationResult<Void> addRes = inventoryPort.addItem(crop.getCropType(), yieldCount);
 *      if (addRes.isFailure()) {
 *          return OperationResult.failed(addRes.getCode(), addRes.getMessage());
 *      }
 *      
 *      slotPort.takeCrop(plotIndex);
 *      energyPort.consumeEnergy(defaultStrategy.getEnergyCost());
 *      
 *      if (eventBus != null) {
 *          eventBus.publish(new CropHarvested(day, plotIndex, crop.getCropType(), yieldCount));
 *      }
 *      
 *      return OperationResult.ok("Panen berhasil: " + yieldCount + " " + crop.getCropType(), yieldCount);
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

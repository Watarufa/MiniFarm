package minifarm.units.u33upgrade;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.WalletPort;
import minifarm.core.events.EventBus;
import minifarm.core.events.FarmUpgradePurchased;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): FarmUpgradeService
 * ================================================================================================
 * Modul Unit: U33UPGRADE
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U33: Ekspansi dan Upgrade Pertanian.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class FarmUpgradeService
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AbstractFarmUpgrade> upgrades = new LinkedHashMap<>();
 * 2. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public FarmUpgradeService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void registerUpgrade(AbstractFarmUpgrade upgrade)
 *    Logika Implementasi:
 *      if (upgrade != null) {
 *          upgrades.put(upgrade.getUpgradeId(), upgrade);
 *      }
 * 
 * 2. public List<AbstractFarmUpgrade> getAllUpgrades()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(new ArrayList<>(upgrades.values()));
 * 
 * 3. public Optional<AbstractFarmUpgrade> getUpgrade(String upgradeId)
 *    Logika Implementasi:
 *      if (upgradeId == null) return Optional.empty();
 *      return Optional.ofNullable(upgrades.get(upgradeId));
 * 
 * 4. public OperationResult<Void> purchaseUpgrade(String upgradeId, int day, WalletPort walletPort)
 *    Keterangan / Tujuan: Membeli dan mengeksekusi upgrade fasilitas secara atomik.
 *    Logika Implementasi:
 *      // TODO U33:
 *      // 1. Ambil upgrade berdasarkan upgradeId.
 *      // 2. Validasi apakah isMaxLevel(). Jika ya, kembalikan CAPACITY_EXCEEDED.
 *      // 3. Validasi saldo walletPort.getBalance() >= cost.
 *      // 4. Lakukan debit wallet dan terapkan upgrade.apply() secara atomik.
 *      // 5. Publikasikan event FarmUpgradePurchased jika berhasil.
 *      Optional<AbstractFarmUpgrade> upOpt = getUpgrade(upgradeId);
 *      if (upOpt.isEmpty()) {
 *          return OperationResult.failed(ResultCode.NOT_FOUND, "Upgrade tidak ditemukan: " + upgradeId);
 *      }
 *      AbstractFarmUpgrade upgrade = upOpt.get();
 *      
 *      if (upgrade.isMaxLevel()) {
 *          return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Fasilitas sudah mencapai level maksimum");
 *      }
 *      
 *      long cost = upgrade.calculateCost();
 *      if (walletPort.getBalance() < cost) {
 *          return OperationResult.failed(ResultCode.INSUFFICIENT_FUNDS, "Saldo koin tidak cukup untuk upgrade (Butuh: " + cost + " G)");
 *      }
 *      
 *      OperationResult<Void> debitRes = walletPort.debit(cost, "Beli upgrade " + upgrade.getUpgradeName());
 *      if (debitRes.isFailure()) {
 *          return debitRes;
 *      }
 *      
 *      OperationResult<Void> applyRes = upgrade.apply();
 *      if (applyRes.isFailure()) {
 *          // Kompensasi jika apply gagal
 *          walletPort.credit(cost, "Refund gagal upgrade " + upgrade.getUpgradeName());
 *          return applyRes;
 *      }
 *      
 *      if (eventBus != null) {
 *          eventBus.publish(new FarmUpgradePurchased(day, upgrade.getUpgradeId(), cost));
 *      }
 *      
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

package minifarm.units.u17animalproduction;

import minifarm.core.api.*;
import minifarm.core.events.AnimalProductCollected;
import minifarm.core.events.EventBus;
import java.util.*;

/*
 * ================================================================================================
 * PETUNJUK SPESIFIKASI KELAS (KOSONGAN - KETIK SENDIRI DARI NOL): AnimalProductionService
 * ================================================================================================
 * Modul Unit: U17ANIMALPRODUCTION
 * 
 * Deskripsi Kelas:
 * Public Facade untuk Unit U17: Produksi dan Pengumpulan Produk Hewan.
 * Mengimplementasikan DailyTickParticipant.
 * 
 * ------------------------------------------------------------------------------------------------
 * 1. DEKLARASI KELAS / INTERFACE:
 * ------------------------------------------------------------------------------------------------
 * - Deklarasikan: public class AnimalProductionService
 * - Interface yang Diimplementasikan: implements DailyTickParticipant
 * 
 * ------------------------------------------------------------------------------------------------
 * 2. ATRIBUT / FIELDS YANG HARUS DIDEKLARASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. private final Map<String, AbstractAnimalProductionRule> rules = new HashMap<>();
 * 2. private final List<ItemStack> pendingOutputs = new ArrayList<>();
 * 3. private final EventBus eventBus;
 * 
 * ------------------------------------------------------------------------------------------------
 * 3. CONSTRUCTOR YANG HARUS DIBUAT:
 * ------------------------------------------------------------------------------------------------
 * 1. Constructor: public AnimalProductionService(EventBus eventBus)
 *    Logika Implementasi:
 *      this.eventBus = eventBus;
 *      registerRule(new EggProductionRule());
 *      registerRule(new MilkProductionRule());
 *      registerRule(new WoolProductionRule());
 * 
 * 2. Constructor: public AnimalProductionService()
 *    Logika Implementasi:
 *      this(null);
 * 
 * ------------------------------------------------------------------------------------------------
 * 4. METHOD-METHOD YANG HARUS DIIMPLEMENTASIKAN:
 * ------------------------------------------------------------------------------------------------
 * 1. public void registerRule(AbstractAnimalProductionRule rule)
 *    Logika Implementasi:
 *      if (rule != null) {
 *          rules.put(rule.getSpecies(), rule);
 *      }
 * 
 * 2. @Override public String getParticipantName()
 *    Logika Implementasi:
 *      return "AnimalProductionService";
 * 
 * 3. @Override public int getExecutionOrder()
 *    Logika Implementasi:
 *      return 40;
 * 
 * 4. @Override public void onDayAdvance(DayContext context)
 *    Logika Implementasi:
 *      // Pemrosesan otomatis via Advance Day dipicu melalui triggerProduction
 * 
 * 5. public void processDailyProduction(int day, FarmAnimalPort animalPort, InventoryPort inventoryPort)
 *    Keterangan / Tujuan: Memproses produksi untuk semua hewan terdaftar. Jika inventaris penuh, produk disimpan di pendingOutputs agar tidak hilang diam-diam!
 *    Logika Implementasi:
 *      // TODO U17:
 *      // 1. Ambil seluruh hewan dari animalPort.getAllAnimals().
 *      // 2. Untuk setiap hewan, cari rule yang cocok berdasarkan species.
 *      // 3. Jika rule menghasilkan produk:
 *      //    - Coba masukkan ke inventoryPort.
 *      //    - Jika inventory penuh, masukkan ke pendingOutputs.
 *      //    - Publikasikan event AnimalProductCollected jika masuk ke inventory.
 *      if (animalPort == null) return;
 *      
 *      for (AnimalSnapshot animal : animalPort.getAllAnimals()) {
 *          AbstractAnimalProductionRule rule = rules.get(animal.getSpecies().toLowerCase());
 *          if (rule != null) {
 *              Optional<ItemStack> productOpt = rule.calculateDailyProduction(animal);
 *              if (productOpt.isPresent()) {
 *                  ItemStack product = productOpt.get();
 *                  if (inventoryPort != null && inventoryPort.hasItem(product.getItemId(), 1)) {
 *                      inventoryPort.addItem(product.getItemId(), product.getQuantity());
 *                      if (eventBus != null) {
 *                          eventBus.publish(new AnimalProductCollected(day, animal.getId(), product.getItemId(), product.getQuantity()));
 *                      }
 *                  } else if (inventoryPort != null && inventoryPort.getAvailableSlots() > 0) {
 *                      inventoryPort.addItem(product.getItemId(), product.getQuantity());
 *                      if (eventBus != null) {
 *                          eventBus.publish(new AnimalProductCollected(day, animal.getId(), product.getItemId(), product.getQuantity()));
 *                      }
 *                  } else {
 *                      // Inventaris penuh: simpan ke pending output
 *                      pendingOutputs.add(product);
 *                  }
 *              }
 *          }
 *      }
 * 
 * 6. public List<ItemStack> getPendingOutputs()
 *    Logika Implementasi:
 *      return Collections.unmodifiableList(pendingOutputs);
 * 
 * 7. public OperationResult<Void> claimPendingOutputs(InventoryPort inventoryPort, int day)
 *    Logika Implementasi:
 *      if (pendingOutputs.isEmpty()) {
 *          return OperationResult.ok();
 *      }
 *      Iterator<ItemStack> it = pendingOutputs.iterator();
 *      while (it.hasNext()) {
 *          ItemStack stack = it.next();
 *          if (inventoryPort.getAvailableSlots() > 0 || inventoryPort.hasItem(stack.getItemId(), 1)) {
 *              inventoryPort.addItem(stack.getItemId(), stack.getQuantity());
 *              it.remove();
 *              if (eventBus != null) {
 *                  eventBus.publish(new AnimalProductCollected(day, "pending", stack.getItemId(), stack.getQuantity()));
 *              }
 *          }
 *      }
 *      return OperationResult.ok();
 * 
 * ================================================================================================
 * SILAKAN KETIK IMPLEMENTASI KELAS ANDA DI BAWAH INI SECARA MANDIRI DARI NOL:
 * ================================================================================================
 */

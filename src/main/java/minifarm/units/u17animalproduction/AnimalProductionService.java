package minifarm.units.u17animalproduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import minifarm.core.api.AnimalSnapshot;
import minifarm.core.api.DailyTickParticipant;
import minifarm.core.api.DayContext;
import minifarm.core.api.FarmAnimalPort;
import minifarm.core.api.InventoryPort;
import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.events.AnimalProductCollected;
import minifarm.core.events.EventBus;

// pintu masuk / facade unit U17 buat produksi dan mengumpulkan produk hewan
// implements DailyTickParticipant: service ikut masuk alur pergantian hari
public class AnimalProductionService implements DailyTickParticipant {

    // map ini nyimpan aturan berdasarkan jenis hewan
    private final Map<String, AbstractAnimalProductionRule> rules = new HashMap<>();
    // produk yg belum muat di inventaris disimpen di sini biar ga hilang
    private final List<ItemStack> pendingOutputs = new ArrayList<>();
    private final EventBus eventBus;

    public AnimalProductionService(EventBus eventBus) {
        this.eventBus = eventBus;
        // mendaftarkan aturan bawaan untuk ayam, sapi dan domba
        registerRule(new EggProductionRule());
        registerRule(new MilkProductionRule());
        registerRule(new WoolProductionRule());
    }

    public AnimalProductionService() {
        // constructor tanpa event bus tetep bisa dipake
        this(null);
    }

    public void registerRule(AbstractAnimalProductionRule rule) {
        // abaikan null supaya isi map tetap valid
        if (rule != null) {
            rules.put(rule.getSpecies(), rule);
        }
    }

    // nama yg dipake scheduler buat ngenalin participant 
    @Override
    public String getParticipantName() {
        return "AnimalProductionService";
    }

    // urutan 40 mengikuti urutan pemrosesan yg ditentukan unit ini
    @Override
    public int getExecutionOrder() {
        return 40;
    }

    // produksi diproses lewat triggerProduction karena port hewan dan inventaris ada di sana
    @Override
    public void onDayAdvance(DayContext context) {
        // belum ada aksi langsung di sini; pemanggil mengirim port lewat processDailyProduction
    }

    public void processDailyProduction(int day, FarmAnimalPort animalPort, InventoryPort inventoryPort) {
        // tanpa port hewan ga ada daftar ternak yg bisa diproses
        if (animalPort == null) {
            return;
        }

        List<AnimalSnapshot> animals = animalPort.getAllAnimals();
        if (animals == null) {
            return;
        }

        for (AnimalSnapshot animal : animals) {
            // lewati data kosong / tanpa spesies
            if (animal == null || animal.getSpecies() == null) {
                continue;
            }

            AbstractAnimalProductionRule rule = rules.get(animal.getSpecies().trim().toLowerCase(Locale.ROOT));
            if (rule == null) {
                continue; // belum ada aturan untuk jenis hewan ini
            }

            Optional<ItemStack> productOpt = rule.calculateDailyProduction(animal);
            if (!productOpt.isPresent()) {
                continue; // hewan belum memenuhi syarat produksi
            }

            ItemStack product = productOpt.get();
            // kalau inventaris bisa menerima produk, simpan dan kabari lewat event
            if (inventoryPort != null && inventoryPort.addItem(product.getItemId(), product.getQuantity()).isSuccess()) {
                publishCollectedEvent(day, animal.getId(), product);
            } else {
                // inventaris penuh / gagal menerima item, simpan buat diklaim nanti
                pendingOutputs.add(product);
            }
        }
    }

    public List<ItemStack> getPendingOutputs() {
        // caller boleh baca listnya, tapi ga bisa mengubah list internal service
        return Collections.unmodifiableList(pendingOutputs);
    }

    public OperationResult<Void> claimPendingOutputs(InventoryPort inventoryPort, int day) {
        if (inventoryPort == null) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Inventory tidak boleh null");
        }

        Iterator<ItemStack> it = pendingOutputs.iterator();
        while (it.hasNext()) {
            ItemStack stack = it.next();
            // hapus dari pending dan kirim event cuma klo inventaris berhasil nerima
            if (inventoryPort.addItem(stack.getItemId(), stack.getQuantity()).isSuccess()) {
                it.remove();
                publishCollectedEvent(day, "pending", stack);
            }
        }
        return OperationResult.ok();
    }

    private void publishCollectedEvent(int day, String animalId, ItemStack product) {
        // event bus opsional, jadi service tetep bisa dipakai tanpa event
        if (eventBus != null) {
            eventBus.publish(new AnimalProductCollected(day, animalId, product.getItemId(), product.getQuantity()));
        }
    }
}


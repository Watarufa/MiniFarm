package minifarm.app;

import minifarm.core.api.CropSnapshot;
import minifarm.core.api.ItemStack;
import minifarm.core.api.OperationResult;
import minifarm.core.api.WeatherSnapshot;
import minifarm.ui.AnsiColor;
import minifarm.ui.AsciiArt;
import minifarm.ui.ConsoleMenu;
import minifarm.ui.ConsoleRenderer;
import minifarm.ui.InputReader;
import minifarm.units.u01plot.AbstractFarmPlot;
import minifarm.units.u02crop.AbstractCrop;
import minifarm.units.u03seed.PlantableSeed;
import minifarm.units.u09item.FarmItem;
import minifarm.units.u15animal.AbstractFarmAnimal;
import minifarm.units.u16animalcare.CleanAction;
import minifarm.units.u18housing.AbstractAnimalHousing;
import minifarm.units.u19storage.AbstractFarmStorage;
import minifarm.units.u25quest.AbstractQuest;
import minifarm.units.u26achievement.AchievementService;
import minifarm.units.u27skill.AbstractFarmSkill;
import minifarm.units.u28crafting.AbstractCraftingRecipe;
import minifarm.units.u29order.AbstractDeliveryOrder;
import minifarm.units.u31journal.AbstractFarmNotification;
import minifarm.units.u33upgrade.AbstractFarmUpgrade;
import minifarm.units.u33upgrade.ProtectedPlotUpgrade;

import java.util.*;

/**
 * Controller CLI MiniFarm yang dinamis, interaktif, penuh warna, dan terintegrasi penuh ke seluruh 33 unit.
 * Setiap aksi membersihkan terminal (clear screen), memperbarui state UI secara instan,
 * dan mendukung input yang fleksibel (bisa nomor urut, ID item, maupun teks nama).
 */
public class AppController {
    private final GameContext context;
    private final InputReader input;
    private boolean running = true;
    private String feedbackMessage = "";

    public AppController(GameContext context, InputReader input) {
        this.context = context;
        this.input = input;
    }

    public void start() {
        while (running) {
            ConsoleRenderer.clearScreen();
            ConsoleRenderer.printBanner();
            displayStatus();
            ConsoleMenu.printMainMenu();
            int choice = input.readInt("\nPilih menu [0-10]: ", 0, 10);
            handleMenuChoice(choice);
        }

        ConsoleRenderer.clearScreen();
        System.out.println(AnsiColor.success("\nTerima kasih telah bermain di MiniFarm Simulator! Sampai jumpa!"));
    }

    private void displayStatus() {
        ConsoleRenderer.printStatus(
                context.getDayCycleService().getCurrentDay(),
                context.getDayCycleService().getCurrentWeather().getWeatherType(),
                context.getEnergyService().getCurrentEnergy(),
                context.getEnergyService().getMaxEnergy(),
                context.getWalletService().getBalance(),
                context.getPlotService().getOccupiedPlotCount(),
                context.getPlotService().getPlotCount(),
                feedbackMessage
        );
        feedbackMessage = ""; // Reset feedback setelah ditampilkan ke layar
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> loopFarmMenu();
            case 2 -> loopInventoryAndStorageMenu();
            case 3 -> loopShopMenu();
            case 4 -> loopMarketMenu();
            case 5 -> loopRanchMenu();
            case 6 -> loopCraftingMenu();
            case 7 -> loopQuestsAndAchievementsMenu();
            case 8 -> loopProfileSkillsAndJournalMenu();
            case 9 -> loopUpgradesMenu();
            case 10 -> handleAdvanceDay();
            case 0 -> running = false;
        }
    }

    // =========================================================================
    // 1. FARM & CROPS SUBMENU LOOP
    // =========================================================================
    private void loopFarmMenu() {
        boolean inFarm = true;
        while (inFarm) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Lahan Pertanian & Tanaman (Farm & Crops)");
            ConsoleRenderer.renderPlotGrid(context.getPlotService(), context.getSoilService());

            System.out.println("\n" + AnsiColor.header("PILIHAN AKSI LAHAN:"));
            printSubmenuItem(1, "Tanam Benih", "(Plant Seed - 5 Energi)");
            printSubmenuItem(2, "Siram Petak", "(Water Plot - 5 Energi, otomatis disiram jika cuaca RAINY)");
            printSubmenuItem(3, "Beri Pupuk", "(Apply Fertilizer - Tambah +20 Kesuburan Tanah)");
            printSubmenuItem(4, "Panen Tanaman", "(Harvest Mature Crop - 5 Energi)");
            printSubmenuItem(5, "Bersihkan Petak", "(Clear Plot - Kosongkan Petak Tanaman)");
            printSubmenuBackItem("Kembali ke Menu Utama");

            int act = input.readInt("\nPilih aksi lahan [0-5]: ", 0, 5);
            if (act == 0) {
                inFarm = false;
            } else if (act == 1) {
                actionPlantSeed();
            } else if (act == 2) {
                actionWaterPlot();
            } else if (act == 3) {
                actionFertilizePlot();
            } else if (act == 4) {
                actionHarvestPlot();
            } else if (act == 5) {
                actionClearPlot();
            }
        }
    }

    private void actionPlantSeed() {
        int maxIndex = context.getPlotService().getPlotCount() - 1;
        int plotIdx = input.readInt("Pilih nomor petak [0 - " + maxIndex + "]: ", 0, maxIndex);
        if (!context.getPlotService().isPlotEmpty(plotIdx)) {
            feedbackMessage = "[!] Petak #" + plotIdx + " sudah terisi tanaman!";
            return;
        }

        List<ItemStack> availableSeeds = new ArrayList<>();
        for (ItemStack s : context.getInventoryService().getItems()) {
            if (context.getSeedCatalog().containsSeed(s.getItemId())) {
                availableSeeds.add(s);
            }
        }

        if (availableSeeds.isEmpty()) {
            feedbackMessage = "[!] Anda tidak memiliki benih di inventaris. Silakan beli benih di Toko!";
            return;
        }

        System.out.println("\n" + AnsiColor.header("Daftar benih di tas Anda:"));
        for (int i = 0; i < availableSeeds.size(); i++) {
            ItemStack s = availableSeeds.get(i);
            System.out.printf("  %s %s: %s\n",
                    AnsiColor.yellow(" " + (i + 1) + "."),
                    AnsiColor.green(String.format("%-15s", s.getItemId())),
                    AnsiColor.gold(s.getQuantity() + " unit"));
        }

        String rawInput = input.readLine("Pilih nomor benih [1-" + availableSeeds.size() + "] atau ketik ID benih: ");
        String seedId = resolveSeedId(rawInput, availableSeeds);

        Optional<PlantableSeed> seedOpt = context.getSeedCatalog().getSeed(seedId);
        if (seedOpt.isEmpty()) {
            feedbackMessage = "[!] Benih tidak dikenal: " + rawInput;
            return;
        }
        if (!context.getInventoryService().hasItem(seedId, 1)) {
            feedbackMessage = "[!] Anda tidak memiliki stok benih " + seedId + "!";
            return;
        }
        if (context.getEnergyService().getCurrentEnergy() < 5) {
            feedbackMessage = "[!] Energi tidak cukup untuk menanam (butuh 5 energi)!";
            return;
        }

        AbstractCrop newCrop = context.getCropService().createCrop(seedOpt.get().getCropType());
        OperationResult<Void> placeRes = context.getPlotService().placeCrop(plotIdx, newCrop);
        if (placeRes.isSuccess()) {
            context.getInventoryService().removeItem(seedId, 1);
            context.getEnergyService().consumeEnergy(5);
            feedbackMessage = "[OK] Berhasil menanam " + seedOpt.get().getDisplayName() + " di petak #" + plotIdx;
        } else {
            feedbackMessage = "[!] Gagal menanam: " + placeRes.getMessage();
        }
    }

    private String resolveSeedId(String input, List<ItemStack> available) {
        if (input == null || input.isBlank()) return "";
        String trimmed = input.trim().toLowerCase();
        try {
            int num = Integer.parseInt(trimmed);
            if (num >= 1 && num <= available.size()) {
                return available.get(num - 1).getItemId();
            }
        } catch (NumberFormatException ignored) {}

        if (context.getSeedCatalog().containsSeed(trimmed)) {
            return trimmed;
        }
        if (context.getSeedCatalog().containsSeed(trimmed + "_seed")) {
            return trimmed + "_seed";
        }
        return trimmed;
    }

    private void actionWaterPlot() {
        int maxIndex = context.getPlotService().getPlotCount() - 1;
        int plotIdx = input.readInt("Pilih nomor petak untuk disiram [0 - " + maxIndex + "]: ", 0, maxIndex);
        OperationResult<Void> waterRes = context.getWateringService().waterPlot(
                plotIdx, context.getPlotService(), context.getEnergyService(), context.getToolService()
        );
        if (waterRes.isSuccess()) {
            feedbackMessage = "[OK] Petak #" + plotIdx + " berhasil disiram air!";
        } else {
            feedbackMessage = "[!] Gagal menyiram petak #" + plotIdx + ": " + waterRes.getMessage();
        }
    }

    private void actionFertilizePlot() {
        int maxIndex = context.getPlotService().getPlotCount() - 1;
        int plotIdx = input.readInt("Pilih nomor petak untuk dipupuk [0 - " + maxIndex + "]: ", 0, maxIndex);
        OperationResult<Void> fertRes = context.getSoilService().applyFertilizerFromInventory(
                plotIdx, context.getInventoryService()
        );
        if (fertRes.isSuccess()) {
            feedbackMessage = "[OK] Pupuk berhasil diaplikasikan ke petak #" + plotIdx + " (+20 Kesuburan)!";
        } else {
            feedbackMessage = "[!] Gagal memupuk: " + fertRes.getMessage();
        }
    }

    private void actionHarvestPlot() {
        int maxIndex = context.getPlotService().getPlotCount() - 1;
        int plotIdx = input.readInt("Pilih nomor petak untuk dipanen [0 - " + maxIndex + "]: ", 0, maxIndex);
        OperationResult<Integer> harvestRes = context.getHarvestService().harvest(
                plotIdx,
                context.getDayCycleService().getCurrentDay(),
                context.getPlotService(),
                context.getSoilService(),
                context.getInventoryService(),
                context.getEnergyService(),
                context.getToolService()
        );
        if (harvestRes.isSuccess()) {
            feedbackMessage = "[OK] " + harvestRes.getMessage() + " telah disimpan ke inventaris.";
        } else {
            feedbackMessage = "[!] Gagal memanen: " + harvestRes.getMessage();
        }
    }

    private void actionClearPlot() {
        int maxIndex = context.getPlotService().getPlotCount() - 1;
        int plotIdx = input.readInt("Pilih nomor petak yang ingin dikosongkan [0 - " + maxIndex + "]: ", 0, maxIndex);
        context.getPlotService().clearPlot(plotIdx);
        feedbackMessage = "[OK] Petak #" + plotIdx + " berhasil dibersihkan dan siap ditanami kembali.";
    }

    // =========================================================================
    // 2. INVENTORY & STORAGE SUBMENU LOOP
    // =========================================================================
    private void loopInventoryAndStorageMenu() {
        boolean inStorage = true;
        while (inStorage) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Inventaris Tas & Fasilitas Penyimpanan");
            System.out.println(AsciiArt.BARN_ART);

            // 1. Tampilkan Tas Pemain
            List<ItemStack> bagItems = context.getInventoryService().getItems();
            int usedBag = context.getInventoryService().getTotalCapacity() - context.getInventoryService().getAvailableSlots();
            int totalBag = context.getInventoryService().getTotalCapacity();
            System.out.println("\n" + AnsiColor.header("[ISI TAS PEMAIN]") + " " +
                    AnsiColor.gray("(Kapasitas: ") + AnsiColor.yellow(usedBag + "/" + totalBag) + AnsiColor.gray(" slot terpakai):"));
            
            if (bagItems.isEmpty()) {
                System.out.println("   " + AnsiColor.gray("(Tas kosong melompong)"));
            } else {
                for (int i = 0; i < bagItems.size(); i++) {
                    ItemStack s = bagItems.get(i);
                    System.out.printf("   %s %s: %s\n",
                            AnsiColor.yellow(String.format("%2d.", i + 1)),
                            AnsiColor.green(String.format("%-18s", s.getItemId())),
                            AnsiColor.gold(s.getQuantity() + " unit"));
                }
            }

            // 2. Tampilkan Gudang Barn
            AbstractFarmStorage barn = context.getStorageService().getStorage("barn_storage");
            List<ItemStack> barnItems = barn.getStoredItems();
            int usedBarn = barn.getCapacity() - barn.getAvailableSlots();
            System.out.println("\n" + AnsiColor.wrap("[GUDANG PERTANIAN - BARN]", AnsiColor.BOLD, AnsiColor.BRIGHT_RED) + " " +
                    AnsiColor.gray("(Kapasitas: ") + AnsiColor.yellow(usedBarn + "/" + barn.getCapacity()) + AnsiColor.gray(" slot):"));
            
            if (barnItems.isEmpty()) {
                System.out.println("   " + AnsiColor.gray("(Gudang Barn kosong)"));
            } else {
                for (int i = 0; i < barnItems.size(); i++) {
                    ItemStack s = barnItems.get(i);
                    System.out.printf("   %s %s: %s\n",
                            AnsiColor.yellow(String.format("%2d.", i + 1)),
                            AnsiColor.white(String.format("%-18s", s.getItemId())),
                            AnsiColor.gold(s.getQuantity() + " unit"));
                }
            }

            // 3. Tampilkan Silo
            AbstractFarmStorage silo = context.getStorageService().getStorage("silo_storage");
            List<ItemStack> siloItems = silo.getStoredItems();
            int usedSilo = silo.getCapacity() - silo.getAvailableSlots();
            System.out.println("\n" + AnsiColor.wrap("[SILO BIJI-BIJIAN & PAKAN]", AnsiColor.BOLD, AnsiColor.BRIGHT_BLUE) + " " +
                    AnsiColor.gray("(Kapasitas: ") + AnsiColor.yellow(usedSilo + "/" + silo.getCapacity()) + AnsiColor.gray(" slot):"));
            
            if (siloItems.isEmpty()) {
                System.out.println("   " + AnsiColor.gray("(Silo kosong)"));
            } else {
                for (int i = 0; i < siloItems.size(); i++) {
                    ItemStack s = siloItems.get(i);
                    System.out.printf("   %s %s: %s\n",
                            AnsiColor.yellow(String.format("%2d.", i + 1)),
                            AnsiColor.cyan(String.format("%-18s", s.getItemId())),
                            AnsiColor.gold(s.getQuantity() + " unit"));
                }
            }

            System.out.println("\n" + AnsiColor.header("PILIHAN AKSI PENYIMPANAN:"));
            printSubmenuItem(1, "Simpan Item ke Barn", "(Pindahkan dari Tas ke Gudang Serbaguna)");
            printSubmenuItem(2, "Ambil Item dari Barn", "(Pindahkan dari Gudang Barn ke Tas)");
            printSubmenuItem(3, "Simpan Item ke Silo", "(Pindahkan Benih/Pakan/Crop ke Silo)");
            printSubmenuItem(4, "Ambil Item dari Silo", "(Pindahkan dari Silo ke Tas)");
            printSubmenuBackItem("Kembali ke Menu Utama");

            int act = input.readInt("\nPilih aksi [0-4]: ", 0, 4);
            if (act == 0) {
                inStorage = false;
            } else if (act == 1) {
                transferStoragePrompt(bagItems, "barn_storage", true);
            } else if (act == 2) {
                transferStoragePrompt(barnItems, "barn_storage", false);
            } else if (act == 3) {
                transferStoragePrompt(bagItems, "silo_storage", true);
            } else if (act == 4) {
                transferStoragePrompt(siloItems, "silo_storage", false);
            }
        }
    }

    private void transferStoragePrompt(List<ItemStack> sourceList, String storageId, boolean toStorage) {
        if (sourceList.isEmpty()) {
            feedbackMessage = "[!] Tidak ada item yang tersedia untuk dipindahkan!";
            return;
        }
        String idInput = input.readLine("Pilih nomor item [1-" + sourceList.size() + "] atau ketik ID item: ");
        String resolvedId = resolveListId(idInput, sourceList);
        if (resolvedId == null || resolvedId.isBlank()) {
            feedbackMessage = "[!] Item tidak valid: " + idInput;
            return;
        }

        int maxQty = 1;
        for (ItemStack s : sourceList) {
            if (s.getItemId().equalsIgnoreCase(resolvedId)) {
                maxQty = s.getQuantity();
                break;
            }
        }

        String qtyStr = input.readLine("Jumlah unit (1 - " + maxQty + ", atau ketik 'all'): ");
        int qty = parseQuantity(qtyStr, maxQty);

        if (toStorage) {
            OperationResult<Void> res = context.getStorageService().transferToStorage(storageId, resolvedId, qty, context.getInventoryService());
            feedbackMessage = res.isSuccess() ? "[OK] Berhasil menyimpan " + qty + "x " + resolvedId + " ke " + storageId + "!" : "[!] " + res.getMessage();
        } else {
            OperationResult<Void> res = context.getStorageService().transferToInventory(storageId, resolvedId, qty, context.getInventoryService());
            feedbackMessage = res.isSuccess() ? "[OK] Berhasil mengambil " + qty + "x " + resolvedId + " ke tas!" : "[!] " + res.getMessage();
        }
    }

    // =========================================================================
    // 3. SHOP SUBMENU LOOP
    // =========================================================================
    private void loopShopMenu() {
        boolean inShop = true;
        while (inShop) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Toko Pertanian Pak Tani (Shop)");
            System.out.println(AsciiArt.SHOP_ART);

            System.out.println("Saldo Anda saat ini: " + AnsiColor.gold(context.getWalletService().getBalance() + " G"));

            List<Map.Entry<String, Long>> shopItems = new ArrayList<>();
            context.getShopCatalogService().getSections().forEach(sec -> {
                System.out.println("\n" + AnsiColor.header("[KATEGORI: " + sec.getSectionName().toUpperCase() + "]"));
                sec.getOfferings().forEach((id, price) -> {
                    shopItems.add(Map.entry(id, price));
                    int idx = shopItems.size();
                    System.out.printf("   %s %s: %s\n",
                            AnsiColor.yellow(String.format("%2d.", idx)),
                            AnsiColor.green(String.format("%-18s", id)),
                            AnsiColor.gold(String.format("%4d G per unit", price)));
                });
            });

            System.out.println("\n" + AnsiColor.header("PILIHAN AKSI TOKO:"));
            printSubmenuItem(1, "Beli Barang", "(Purchase Item - Koin terpotong otomatis)");
            printSubmenuBackItem("Kembali ke Menu Utama");

            int act = input.readInt("\nPilih aksi [0-1]: ", 0, 1);
            if (act == 0) {
                inShop = false;
            } else if (act == 1) {
                String idInput = input.readLine("Pilih nomor barang [1-" + shopItems.size() + "] atau ketik ID: ");
                String resolvedId = resolveShopId(idInput, shopItems);
                if (resolvedId == null || resolvedId.isBlank()) {
                    feedbackMessage = "[!] Barang tidak dikenal: " + idInput;
                    continue;
                }

                int qty = input.readInt("Jumlah yang ingin dibeli: ", 1, 99);
                OperationResult<Void> res = context.getPurchaseService().purchase(
                        resolvedId, qty, context.getDayCycleService().getCurrentDay(),
                        context.getShopCatalogService(), context.getWalletService(), context.getInventoryService()
                );
                feedbackMessage = res.isSuccess() ? "[OK] Berhasil membeli " + qty + "x " + resolvedId + "!" : "[!] " + res.getMessage();
            }
        }
    }

    private String resolveShopId(String input, List<Map.Entry<String, Long>> items) {
        if (input == null || input.isBlank()) return "";
        String trimmed = input.trim();
        try {
            int num = Integer.parseInt(trimmed);
            if (num >= 1 && num <= items.size()) {
                return items.get(num - 1).getKey();
            }
        } catch (NumberFormatException ignored) {}
        return trimmed;
    }

    // =========================================================================
    // 4. MARKET SUBMENU LOOP
    // =========================================================================
    private void loopMarketMenu() {
        boolean inMarket = true;
        while (inMarket) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Pasar Komoditas (Market - Jual Hasil)");
            System.out.println(AsciiArt.MARKET_ART);

            System.out.println(AnsiColor.header("Komoditas di tas Anda yang dapat dijual ke pasar:"));
            List<ItemStack> sellableItems = new ArrayList<>();
            for (ItemStack s : context.getInventoryService().getItems()) {
                Optional<FarmItem> defOpt = context.getItemCatalog().getItem(s.getItemId());
                if (defOpt.isPresent() && defOpt.get().canSell()) {
                    sellableItems.add(s);
                    int idx = sellableItems.size();
                    long unitPrice = defOpt.get().getBasePrice();
                    System.out.printf("   %s %s: %s %s\n",
                            AnsiColor.yellow(String.format("%2d.", idx)),
                            AnsiColor.green(String.format("%-15s", s.getItemId())),
                            AnsiColor.white(String.format("%3d unit", s.getQuantity())),
                            AnsiColor.gold(String.format("(Harga Pasar: %d G/unit)", unitPrice)));
                }
            }

            if (sellableItems.isEmpty()) {
                System.out.println("   " + AnsiColor.gray("(Tidak ada komoditas hasil panen/hewan yang dapat dijual saat ini)"));
            }

            System.out.println("\n" + AnsiColor.header("PILIHAN AKSI PASAR:"));
            printSubmenuItem(1, "Jual Komoditas", "(Sell Item - Peroleh Koin Emas)");
            printSubmenuBackItem("Kembali ke Menu Utama");

            int act = input.readInt("\nPilih aksi [0-1]: ", 0, 1);
            if (act == 0) {
                inMarket = false;
            } else if (act == 1) {
                if (sellableItems.isEmpty()) {
                    feedbackMessage = "[!] Tidak ada barang yang bisa dijual!";
                    continue;
                }
                String idInput = input.readLine("Pilih nomor komoditas [1-" + sellableItems.size() + "] atau ketik ID: ");
                String resolvedId = resolveListId(idInput, sellableItems);
                if (resolvedId == null || resolvedId.isBlank()) {
                    feedbackMessage = "[!] Komoditas tidak dikenal: " + idInput;
                    continue;
                }

                int maxQty = 1;
                for (ItemStack s : sellableItems) {
                    if (s.getItemId().equalsIgnoreCase(resolvedId)) {
                        maxQty = s.getQuantity();
                        break;
                    }
                }

                String qtyStr = input.readLine("Jumlah unit yang ingin dijual (1 - " + maxQty + ", atau ketik 'all'): ");
                int qty = parseQuantity(qtyStr, maxQty);

                OperationResult<Long> res = context.getSellingService().sellItem(
                        resolvedId, qty, context.getDayCycleService().getCurrentDay(),
                        context.getItemCatalog(), context.getPricingService(), context.getInventoryService(), context.getWalletService()
                );
                feedbackMessage = res.isSuccess() ? "[OK] " + res.getMessage() : "[!] " + res.getMessage();
            }
        }
    }

    // =========================================================================
    // 5. ANIMAL RANCH & HOUSING SUBMENU LOOP
    // =========================================================================
    private void loopRanchMenu() {
        boolean inRanch = true;
        while (inRanch) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Peternakan Hewan & Kandang (Ranch & Housing)");
            System.out.println(AsciiArt.CHICKEN_ART);

            // Tampilkan status kandang
            System.out.println("\n" + AnsiColor.header("[KANDANG TERSEDIA]:"));
            for (String hId : List.of("coop", "barn", "pasture")) {
                AbstractAnimalHousing h = context.getHousingService().getHousingEntity(hId);
                if (h != null) {
                    System.out.printf("  * %s | Kapasitas: %s | Penghuni: %s\n",
                            AnsiColor.cyan(String.format("%-16s", h.getName())),
                            AnsiColor.yellow(String.format("%d/%-2d", h.getOccupiedCount(), h.getCapacity())),
                            AnsiColor.white(h.getAnimalIds().isEmpty() ? "(Kosong)" : String.join(", ", h.getAnimalIds())));
                }
            }

            // Tampilkan daftar hewan
            System.out.println("\n" + AnsiColor.header("[STATUS TERNAK SAAT INI]:"));
            List<AbstractFarmAnimal> animalList = new ArrayList<>();
            for (var snap : context.getAnimalService().getAllAnimals()) {
                AbstractFarmAnimal ent = context.getAnimalService().getAnimalEntity(snap.getId());
                if (ent != null) animalList.add(ent);
            }

            for (int i = 0; i < animalList.size(); i++) {
                AbstractFarmAnimal a = animalList.get(i);
                String fedStr = a.isFed() ? AnsiColor.green("Kenyang (Fed)") : AnsiColor.red("Lapar (Unfed)");
                String cleanStr = a.isClean() ? AnsiColor.green("Ya") : AnsiColor.red("Tidak");
                String hpStr = a.getHealth() >= 70 ? AnsiColor.green(a.getHealth() + "/100") : AnsiColor.yellow(a.getHealth() + "/100");
                System.out.printf("  %s [%s] %s (%s) | HP: %s | Status: %-22s | Bersih: %s\n",
                        AnsiColor.yellow(String.format("%2d.", i + 1)),
                        AnsiColor.cyan(a.getId()),
                        AnsiColor.bold(AnsiColor.white(String.format("%-8s", a.getName()))),
                        AnsiColor.yellow(a.getSpecies()),
                        hpStr, fedStr, cleanStr);
            }

            // Tampilkan pending products jika ada
            List<ItemStack> pending = context.getAnimalProductionService().getPendingOutputs();
            if (!pending.isEmpty()) {
                System.out.println("\n" + AnsiColor.warning("[PRODUK TERTUNDA DI KANDANG] (Karena tas pemain penuh saat hari berganti):"));
                for (ItemStack p : pending) {
                    System.out.printf("   * %s x%d\n", AnsiColor.gold(p.getItemId()), p.getQuantity());
                }
            }

            System.out.println("\n" + AnsiColor.header("PILIHAN AKSI PETERNAKAN:"));
            printSubmenuItem(1, "Beri Pakan Hewan", "(Feed Animal - 3 Energi, butuh animal_feed)");
            printSubmenuItem(2, "Bersihkan & Rawat Hewan", "(Clean/Care Animal - 3 Energi)");
            printSubmenuItem(3, "Pindahkan Produk Tertunda ke Tas", "(Claim Pending Animal Products)");
            printSubmenuBackItem("Kembali ke Menu Utama");

            int act = input.readInt("\nPilih aksi [0-3]: ", 0, 3);
            if (act == 0) {
                inRanch = false;
            } else if (act == 1) {
                actionFeedAnimal(animalList);
            } else if (act == 2) {
                actionCleanAnimal(animalList);
            } else if (act == 3) {
                OperationResult<Void> res = context.getAnimalProductionService().claimPendingOutputs(
                        context.getInventoryService(), context.getDayCycleService().getCurrentDay()
                );
                feedbackMessage = res.isSuccess() ? "[OK] Seluruh produk tertunda berhasil dipindahkan ke tas!" : "[!] " + res.getMessage();
            }
        }
    }

    private void actionFeedAnimal(List<AbstractFarmAnimal> animalList) {
        String aInput = input.readLine("Pilih nomor hewan [1-" + animalList.size() + "], ketik ID/Nama, atau 'all': ");
        if ("all".equalsIgnoreCase(aInput) || "semua".equalsIgnoreCase(aInput)) {
            int fedCount = 0;
            for (AbstractFarmAnimal a : animalList) {
                if (!a.isFed()) {
                    OperationResult<Void> res = context.getAnimalCareService().feedAnimal(
                            a.getId(), "animal_feed", context.getDayCycleService().getCurrentDay(),
                            context.getAnimalService(), context.getInventoryService(), context.getEnergyService()
                    );
                    if (res.isSuccess()) {
                        fedCount++;
                    } else {
                        feedbackMessage = "[!] Berhenti: " + res.getMessage() + " (Telah memberi makan " + fedCount + " hewan)";
                        return;
                    }
                }
            }
            feedbackMessage = fedCount > 0 ? "[OK] Berhasil memberi pakan kepada " + fedCount + " hewan!" : "[!] Seluruh hewan sudah kenyang!";
            return;
        }

        String targetId = resolveAnimalId(aInput, animalList);
        if (targetId == null || targetId.isBlank()) {
            feedbackMessage = "[!] Hewan tidak dikenal: " + aInput;
            return;
        }

        OperationResult<Void> res = context.getAnimalCareService().feedAnimal(
                targetId, "animal_feed", context.getDayCycleService().getCurrentDay(),
                context.getAnimalService(), context.getInventoryService(), context.getEnergyService()
        );
        feedbackMessage = res.isSuccess() ? "[OK] " + targetId + " berhasil diberi pakan!" : "[!] " + res.getMessage();
    }

    private void actionCleanAnimal(List<AbstractFarmAnimal> animalList) {
        String aInput = input.readLine("Pilih nomor hewan [1-" + animalList.size() + "], ketik ID/Nama, atau 'all': ");
        if ("all".equalsIgnoreCase(aInput) || "semua".equalsIgnoreCase(aInput)) {
            int cleanCount = 0;
            for (AbstractFarmAnimal a : animalList) {
                if (!a.isClean()) {
                    OperationResult<Void> res = context.getAnimalCareService().performCare(
                            new CleanAction(), a.getId(),
                            context.getAnimalService(), context.getInventoryService(), context.getEnergyService()
                    );
                    if (res.isSuccess()) {
                        cleanCount++;
                    } else {
                        feedbackMessage = "[!] Berhenti: " + res.getMessage() + " (Telah merawat " + cleanCount + " hewan)";
                        return;
                    }
                }
            }
            feedbackMessage = cleanCount > 0 ? "[OK] Berhasil merawat dan membersihkan " + cleanCount + " hewan!" : "[!] Seluruh hewan sudah bersih!";
            return;
        }

        String targetId = resolveAnimalId(aInput, animalList);
        if (targetId == null || targetId.isBlank()) {
            feedbackMessage = "[!] Hewan tidak dikenal: " + aInput;
            return;
        }

        OperationResult<Void> res = context.getAnimalCareService().performCare(
                new CleanAction(), targetId,
                context.getAnimalService(), context.getInventoryService(), context.getEnergyService()
        );
        feedbackMessage = res.isSuccess() ? "[OK] " + targetId + " berhasil dirawat dan dibersihkan!" : "[!] " + res.getMessage();
    }

    private String resolveAnimalId(String input, List<AbstractFarmAnimal> list) {
        if (input == null || input.isBlank()) return "";
        String trimmed = input.trim();
        try {
            int num = Integer.parseInt(trimmed);
            if (num >= 1 && num <= list.size()) {
                return list.get(num - 1).getId();
            }
        } catch (NumberFormatException ignored) {}

        for (AbstractFarmAnimal a : list) {
            if (a.getId().equalsIgnoreCase(trimmed) || a.getName().equalsIgnoreCase(trimmed)) {
                return a.getId();
            }
        }
        return trimmed;
    }

    // =========================================================================
    // 6. CRAFTING SUBMENU LOOP
    // =========================================================================
    private void loopCraftingMenu() {
        boolean inCrafting = true;
        while (inCrafting) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Meja Kerja Pembuatan Barang (Crafting)");
            System.out.println(AsciiArt.CRAFT_ART);

            System.out.println("\n" + AnsiColor.header("[DAFTAR RESEP TERSEDIA]:"));
            List<AbstractCraftingRecipe> recipeList = context.getCraftingService().getAllRecipes();
            for (int i = 0; i < recipeList.size(); i++) {
                AbstractCraftingRecipe r = recipeList.get(i);
                System.out.printf("  %s [%s] %s\n     Bahan : %s\n     Hasil : %s %s\n",
                        AnsiColor.yellow(String.format("%2d.", i + 1)),
                        AnsiColor.magenta(String.format("%-16s", r.getRecipeId())),
                        AnsiColor.bold(AnsiColor.white(String.format("%-20s", r.getRecipeName()))),
                        AnsiColor.yellow(r.getRequiredIngredients().toString()),
                        AnsiColor.green(r.getOutputItem().toString()),
                        AnsiColor.cyan("(Biaya " + r.getEnergyCost() + " Energi)"));
            }

            System.out.println("\n" + AnsiColor.header("PILIHAN AKSI CRAFTING:"));
            printSubmenuItem(1, "Buat Barang Sesuai Resep", "(Craft Item)");
            printSubmenuBackItem("Kembali ke Menu Utama");

            int act = input.readInt("\nPilih aksi [0-1]: ", 0, 1);
            if (act == 0) {
                inCrafting = false;
            } else if (act == 1) {
                String rInput = input.readLine("Pilih nomor resep [1-" + recipeList.size() + "] atau ketik ID resep: ");
                String resolvedRId = resolveRecipeId(rInput, recipeList);
                if (resolvedRId == null || resolvedRId.isBlank()) {
                    feedbackMessage = "[!] Resep tidak dikenal: " + rInput;
                    continue;
                }

                OperationResult<ItemStack> res = context.getCraftingService().craft(
                        resolvedRId, context.getDayCycleService().getCurrentDay(), context.getInventoryService(), context.getEnergyService()
                );
                feedbackMessage = res.isSuccess() ? "[OK] " + res.getMessage() : "[!] " + res.getMessage();
            }
        }
    }

    private String resolveRecipeId(String input, List<AbstractCraftingRecipe> list) {
        if (input == null || input.isBlank()) return "";
        String trimmed = input.trim();
        try {
            int num = Integer.parseInt(trimmed);
            if (num >= 1 && num <= list.size()) {
                return list.get(num - 1).getRecipeId();
            }
        } catch (NumberFormatException ignored) {}

        for (AbstractCraftingRecipe r : list) {
            if (r.getRecipeId().equalsIgnoreCase(trimmed) || r.getRecipeName().equalsIgnoreCase(trimmed)) {
                return r.getRecipeId();
            }
        }
        return trimmed;
    }

    // =========================================================================
    // 7. QUESTS, ACHIEVEMENTS & ORDERS SUBMENU LOOP
    // =========================================================================
    private void loopQuestsAndAchievementsMenu() {
        boolean inQA = true;
        while (inQA) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Tugas, Pencapaian & Pesanan Pengiriman");
            System.out.println(AsciiArt.TROPHY_ART);

            // 1. Quests
            System.out.println("\n" + AnsiColor.header("[PAPAN TUGAS - QUESTS]:"));
            List<AbstractQuest> questList = context.getQuestService().getAllQuests();
            for (int i = 0; i < questList.size(); i++) {
                AbstractQuest q = questList.get(i);
                String bar = ConsoleRenderer.renderProgressBar(q.getCurrentProgress(), q.getTarget(), 6);
                String status = q.isCompleted() 
                        ? (q.isRewardClaimed() ? AnsiColor.gray("[SUDAH KLAIM]") : AnsiColor.success("[SIAP KLAIM!]")) 
                        : AnsiColor.yellow("[DALAM PROGRES]");
                System.out.printf("   %s [%s] %-22s %s (%d/%d) | Hadiah: %s | %s\n",
                        AnsiColor.yellow(String.format("%2d.", i + 1)),
                        AnsiColor.cyan(String.format("%-12s", q.getQuestId())),
                        AnsiColor.bold(AnsiColor.white(q.getTitle())),
                        bar, q.getCurrentProgress(), q.getTarget(),
                        AnsiColor.gold(q.getRewardCoins() + " G"), status);
            }

            // 2. Achievements
            System.out.println("\n" + AnsiColor.header("[PENCAPAIAN - ACHIEVEMENTS]:"));
            for (AchievementService.AchievementEntry a : context.getAchievementService().getAllAchievements()) {
                String badge = a.isUnlocked() 
                        ? AnsiColor.gold("[DIBUKA / UNLOCKED]") 
                        : AnsiColor.gray("[TERKUNCI / LOCKED]");
                System.out.printf("   * %s : %-30s | Hadiah: %-15s %s\n",
                        AnsiColor.bold(AnsiColor.yellow(String.format("%-22s", a.getName()))),
                        AnsiColor.white(a.getCondition().getDescription()),
                        AnsiColor.green(a.getReward().getDescription()),
                        badge);
            }

            // 3. Delivery Orders
            System.out.println("\n" + AnsiColor.header("[PESANAN PENGIRIMAN - DELIVERY ORDERS]:"));
            List<AbstractDeliveryOrder> orderList = context.getDeliveryOrderService().getAllOrders();
            for (int i = 0; i < orderList.size(); i++) {
                AbstractDeliveryOrder o = orderList.get(i);
                String status = o.isCompleted() ? AnsiColor.green("[SELESAI]") : AnsiColor.yellow("[TERBUKA]");
                System.out.printf("   %s [%s] Pelanggan: %-18s | Butuh: %-20s | Imbalan: %s | %s\n",
                        AnsiColor.yellow(String.format("%2d.", i + 1)),
                        AnsiColor.cyan(String.format("%-14s", o.getOrderId())),
                        AnsiColor.white(o.getCustomerName()),
                        AnsiColor.yellow(o.getRequiredItems().toString()),
                        AnsiColor.gold(o.getRewardCoins() + " G"),
                        status);
            }

            System.out.println("\n" + AnsiColor.header("PILIHAN AKSI:"));
            printSubmenuItem(1, "Klaim Hadiah Quest", "(Claim Completed Quest Coins)");
            printSubmenuItem(2, "Penuhi Pesanan Pengiriman", "(Fulfill Delivery Order)");
            printSubmenuBackItem("Kembali ke Menu Utama");

            int act = input.readInt("\nPilih aksi [0-2]: ", 0, 2);
            if (act == 0) {
                inQA = false;
            } else if (act == 1) {
                String qInput = input.readLine("Pilih nomor quest [1-" + questList.size() + "] atau ketik ID Quest: ");
                String resolvedQId = resolveQuestId(qInput, questList);
                if (resolvedQId == null || resolvedQId.isBlank()) {
                    feedbackMessage = "[!] Quest tidak dikenal: " + qInput;
                    continue;
                }
                OperationResult<Void> res = context.getQuestService().claimReward(resolvedQId, context.getWalletService());
                feedbackMessage = res.isSuccess() ? "[OK] Hadiah koin quest berhasil masuk ke dompet Anda!" : "[!] " + res.getMessage();
            } else if (act == 2) {
                String oInput = input.readLine("Pilih nomor pesanan [1-" + orderList.size() + "] atau ketik ID: ");
                String resolvedOId = resolveOrderId(oInput, orderList);
                if (resolvedOId == null || resolvedOId.isBlank()) {
                    feedbackMessage = "[!] Pesanan tidak dikenal: " + oInput;
                    continue;
                }
                OperationResult<Void> res = context.getDeliveryOrderService().fulfillOrder(
                        resolvedOId, context.getDayCycleService().getCurrentDay(), context.getInventoryService(), context.getWalletService()
                );
                feedbackMessage = res.isSuccess() ? "[OK] Pesanan berhasil diantarkan! Koin imbalan telah diterima." : "[!] " + res.getMessage();
            }
        }
    }

    private String resolveQuestId(String input, List<AbstractQuest> list) {
        if (input == null || input.isBlank()) return "";
        String trimmed = input.trim();
        try {
            int num = Integer.parseInt(trimmed);
            if (num >= 1 && num <= list.size()) {
                return list.get(num - 1).getQuestId();
            }
        } catch (NumberFormatException ignored) {}
        return trimmed;
    }

    private String resolveOrderId(String input, List<AbstractDeliveryOrder> list) {
        if (input == null || input.isBlank()) return "";
        String trimmed = input.trim();
        try {
            int num = Integer.parseInt(trimmed);
            if (num >= 1 && num <= list.size()) {
                return list.get(num - 1).getOrderId();
            }
        } catch (NumberFormatException ignored) {}
        return trimmed;
    }

    // =========================================================================
    // 8. PROFILE, SKILLS & JOURNAL SUBMENU LOOP
    // =========================================================================
    private void loopProfileSkillsAndJournalMenu() {
        boolean inProfile = true;
        while (inProfile) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Profil Petani, Keahlian & Jurnal Aktivitas");

            // Profil Petani
            System.out.println(AnsiColor.header("[PROFIL PETANI]:"));
            System.out.println("   Nama Petani  : " + AnsiColor.bold(AnsiColor.white(context.getFarmerProfileService().getProfile().getName())));
            System.out.println("   Spesialisasi : " + AnsiColor.cyan(context.getFarmerProfileService().getProfile().getSpecialization()));

            // Skills & Level
            System.out.println("\n" + AnsiColor.header("[KEAHLIAN & PENGALAMAN - SKILLS & XP]:"));
            for (AbstractFarmSkill sk : context.getSkillService().getAllSkills()) {
                int nextXp = sk.getThresholdForNextLevel(sk.getLevel());
                String bar = ConsoleRenderer.renderProgressBar(sk.getCurrentXp(), nextXp, 8);
                System.out.printf("   * %s : %s | XP: %s (%d/%d XP)\n",
                        AnsiColor.bold(AnsiColor.white(String.format("%-20s", sk.getDisplayName()))),
                        AnsiColor.gold("Level " + sk.getLevel()),
                        bar, sk.getCurrentXp(), nextXp);
            }

            // Statistik
            System.out.println("\n" + AnsiColor.header("[STATISTIK PERTANIAN]:"));
            for (String line : context.getStatisticsService().getSummaryLines()) {
                System.out.println("   - " + AnsiColor.white(line));
            }

            // Jurnal aktivitas terbaru
            System.out.println("\n" + AnsiColor.header("[CATATAN JURNAL TERBARU] (5 Terakhir):"));
            List<AbstractFarmNotification> recent = context.getJournalService().getRecentEntries(5);
            if (recent.isEmpty()) {
                System.out.println("   " + AnsiColor.gray("(Belum ada catatan aktivitas)"));
            } else {
                for (AbstractFarmNotification note : recent) {
                    System.out.println("   " + AnsiColor.gray(note.format()));
                }
            }

            System.out.println("\n" + AnsiColor.header("PILIHAN:"));
            printSubmenuBackItem("Kembali ke Menu Utama");
            input.readInt("Pilih: ", 0, 0);
            inProfile = false;
        }
    }

    // =========================================================================
    // 9. UPGRADES SUBMENU LOOP
    // =========================================================================
    private void loopUpgradesMenu() {
        boolean inUpgrades = true;
        while (inUpgrades) {
            ConsoleRenderer.clearScreen();
            displayStatus();
            ConsoleRenderer.printHeader("Peningkatan Fasilitas Pertanian (Farm Upgrades)");

            System.out.println(AnsiColor.header("[DAFTAR UPGRADE FASILITAS]:"));
            List<AbstractFarmUpgrade> upgradeList = context.getFarmUpgradeService().getAllUpgrades();
            for (int i = 0; i < upgradeList.size(); i++) {
                AbstractFarmUpgrade u = upgradeList.get(i);
                String maxTag = u.isMaxLevel() ? AnsiColor.gray("[MAKSIMAL]") : AnsiColor.green("[TERSEDIA]");
                System.out.printf("  %s [%s] %-28s | Biaya: %s | %s\n",
                        AnsiColor.yellow(String.format("%2d.", i + 1)),
                        AnsiColor.magenta(String.format("%-24s", u.getUpgradeId())),
                        AnsiColor.bold(AnsiColor.white(u.getUpgradeName())),
                        AnsiColor.gold(String.format("%5d G", u.calculateCost())),
                        maxTag);
            }

            System.out.println("\n" + AnsiColor.header("PILIHAN AKSI UPGRADE:"));
            printSubmenuItem(1, "Beli Upgrade Fasilitas", "(Tingkatkan Lahan, Gudang atau Rumah Kaca)");
            printSubmenuBackItem("Kembali ke Menu Utama");

            int act = input.readInt("\nPilih aksi [0-1]: ", 0, 1);
            if (act == 0) {
                inUpgrades = false;
            } else if (act == 1) {
                String upInput = input.readLine("Pilih nomor upgrade [1-" + upgradeList.size() + "] atau ketik ID: ");
                String upId = resolveUpgradeId(upInput, upgradeList);
                if (upId == null || upId.isBlank()) {
                    feedbackMessage = "[!] Upgrade tidak dikenal: " + upInput;
                    continue;
                }

                if ("upgrade_protected_plot".equalsIgnoreCase(upId)) {
                    int pIdx = input.readInt("Pilih nomor petak kosong yang ingin diubah jadi Rumah Kaca: ", 0, context.getPlotService().getPlotCount() - 1);
                    Optional<AbstractFarmUpgrade> upOpt = context.getFarmUpgradeService().getUpgrade(upId);
                    if (upOpt.isPresent() && upOpt.get() instanceof ProtectedPlotUpgrade ppu) {
                        ppu.setTargetPlotIndex(pIdx);
                    }
                }

                OperationResult<Void> res = context.getFarmUpgradeService().purchaseUpgrade(
                        upId, context.getDayCycleService().getCurrentDay(), context.getWalletService()
                );
                feedbackMessage = res.isSuccess() ? "[OK] Upgrade berhasil dibeli dan fasilitas telah ditingkatkan!" : "[!] " + res.getMessage();
            }
        }
    }

    private String resolveUpgradeId(String input, List<AbstractFarmUpgrade> list) {
        if (input == null || input.isBlank()) return "";
        String trimmed = input.trim();
        try {
            int num = Integer.parseInt(trimmed);
            if (num >= 1 && num <= list.size()) {
                return list.get(num - 1).getUpgradeId();
            }
        } catch (NumberFormatException ignored) {}
        return trimmed;
    }

    // =========================================================================
    // 10. ADVANCE DAY
    // =========================================================================
    private void handleAdvanceDay() {
        ConsoleRenderer.clearScreen();

        // 1. Tumbuhkan tanaman di petak (jika petak lembap)
        int plots = context.getPlotService().getPlotCount();
        int cropsGrown = 0;
        for (int i = 0; i < plots; i++) {
            boolean isMoist = context.getPlotService().isPlotMoist(i);
            Object cropObj = context.getPlotService().getPlot(i).getCrop();
            if (cropObj instanceof AbstractCrop crop) {
                if (isMoist) {
                    cropsGrown++;
                }
                context.getCropService().processCropGrowth(crop, isMoist);
            }
        }

        // 2. Produksi hewan dari hari yang baru saja selesai
        context.getAnimalProductionService().processDailyProduction(
                context.getDayCycleService().getCurrentDay(),
                context.getAnimalService(),
                context.getInventoryService()
        );

        // 3. Reset kelembapan harian dan status makan hewan dari hari yang telah berlalu
        context.getPlotService().resetDailyMoisture();
        context.getAnimalService().resetDailyAnimalState();

        // 4. Maju cuaca dan nomor hari
        WeatherSnapshot nextWeather = context.getWeatherService().advanceToNextWeather();
        context.getDayCycleService().advanceDay(nextWeather);

        // 5. TERAPKAN CUACA HARI BARU KE PETAK!
        // Jika hari baru ini adalah RAINY, seluruh petak luar ruang (Outdoor) langsung basah/lembap oleh air hujan alami!
        context.getPlotService().applyDailyWeather(nextWeather.providesRain());

        // Tampilkan transisi hari secara elegan
        System.out.println(AnsiColor.bold(AnsiColor.yellow("\n===========================================================================")));
        System.out.println("  >>> " + AnsiColor.wrap("PERGANTIAN HARI MENUJU HARI " + context.getDayCycleService().getCurrentDay(), AnsiColor.BOLD, AnsiColor.BRIGHT_YELLOW) + " <<<");
        System.out.println(AnsiColor.bold(AnsiColor.yellow("===========================================================================")));
        System.out.println(AsciiArt.getWeatherArt(nextWeather.getWeatherType()));
        System.out.println("\n" + AnsiColor.header("[LAPORAN SIKLUS HARIAN]:"));
        System.out.println("  * Tanaman berkembang pada petak lembap : " + AnsiColor.green(cropsGrown + " petak"));
        System.out.println("  * Produksi ternak harian telah diproses ke tas / pending output.");
        System.out.println("  * Cuaca hari baru                      : " + AnsiColor.weather(nextWeather.getWeatherType()));
        if (nextWeather.providesRain()) {
            System.out.println("  * Efek Hujan Alami                     : " + AnsiColor.blue("Seluruh petak luar ruang otomatis tersiram hujan!"));
        }
        System.out.println("  * Energi petani telah pulih            : " + AnsiColor.green("100/100 Energi"));

        feedbackMessage = "[OK] Selamat datang di Hari " + context.getDayCycleService().getCurrentDay() + "! Cuaca hari ini: " + nextWeather.getWeatherType();
        input.readLine(AnsiColor.bold("\nTekan [ENTER] untuk melanjutkan ke Menu Utama..."));
    }

    private String resolveListId(String input, List<ItemStack> list) {
        if (input == null || input.isBlank()) return "";
        String trimmed = input.trim();
        try {
            int num = Integer.parseInt(trimmed);
            if (num >= 1 && num <= list.size()) {
                return list.get(num - 1).getItemId();
            }
        } catch (NumberFormatException ignored) {}

        for (ItemStack s : list) {
            if (s.getItemId().equalsIgnoreCase(trimmed)) {
                return s.getItemId();
            }
        }
        return trimmed;
    }

    private int parseQuantity(String qtyInput, int maxAvailable) {
        if (qtyInput == null || qtyInput.isBlank()) return 1;
        String trimmed = qtyInput.trim().toLowerCase();
        if ("all".equals(trimmed) || "semua".equals(trimmed)) {
            return maxAvailable;
        }
        try {
            int val = Integer.parseInt(trimmed);
            return Math.max(1, Math.min(val, maxAvailable));
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    private static void printSubmenuItem(int number, String title, String subtitle) {
        System.out.println("  " + AnsiColor.bold(AnsiColor.yellow(number + ".")) + " " +
                AnsiColor.bold(AnsiColor.white(title)) + " " +
                AnsiColor.gray(subtitle));
    }

    private static void printSubmenuBackItem(String title) {
        System.out.println("  " + AnsiColor.bold(AnsiColor.red("0.")) + " " +
                AnsiColor.gray(title));
    }
}

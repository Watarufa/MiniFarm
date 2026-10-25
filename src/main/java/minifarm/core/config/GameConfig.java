package minifarm.core.config;

import minifarm.core.api.ItemStack;

import java.util.Collections;
import java.util.List;

/**
 * Konfigurasi baseline dan konstanta sentral MiniFarm.
 * Menghindari magic numbers tersebar di UI maupun domain services.
 */
public final class GameConfig {
    private GameConfig() {}

    // Sesi awal
    public static final int INITIAL_DAY = 1;
    public static final String INITIAL_WEATHER = "SUNNY";
    public static final long INITIAL_COINS = 500L;
    public static final int INITIAL_ENERGY = 100;
    public static final int MAX_ENERGY = 100;

    // Lahan & Petak
    public static final int INITIAL_PLOT_COUNT = 4;
    public static final int MAX_PLOT_COUNT = 8;
    public static final int INITIAL_SOIL_FERTILITY = 50;
    public static final int FERTILIZER_FERTILITY_BOOST = 20;
    public static final int HIGH_FERTILITY_BONUS_THRESHOLD = 80;

    // Inventaris & Penyimpanan
    public static final int INVENTORY_SLOT_CAPACITY = 20;
    public static final int INITIAL_STORAGE_SLOT_CAPACITY = 20;

    // Hewan & Kandang
    public static final int INITIAL_COOP_CAPACITY = 4;
    public static final int INITIAL_CHICKEN_COUNT = 2;

    // Biaya stamina/energi per aksi
    public static final int ENERGY_COST_PLANT = 5;
    public static final int ENERGY_COST_WATER = 5;
    public static final int ENERGY_COST_HARVEST = 5;
    public static final int ENERGY_COST_ANIMAL_CARE = 3;
    public static final int ENERGY_COST_CROP_TREATMENT = 4;
    public static final int ENERGY_COST_CRAFTING = 2;

    // Harga dan karakteristik tanaman/benih
    public static final String SEED_WHEAT = "wheat_seed";
    public static final String SEED_CORN = "corn_seed";
    public static final String SEED_TOMATO = "tomato_seed";

    public static final String CROP_WHEAT = "wheat";
    public static final String CROP_CORN = "corn";
    public static final String CROP_TOMATO = "tomato";

    public static final int WHEAT_GROWTH_DAYS = 2;
    public static final int WHEAT_BASE_YIELD = 2;
    public static final long WHEAT_SEED_PRICE = 5L;
    public static final long WHEAT_SELL_PRICE = 10L;

    public static final int CORN_GROWTH_DAYS = 3;
    public static final int CORN_BASE_YIELD = 3;
    public static final long CORN_SEED_PRICE = 8L;
    public static final long CORN_SELL_PRICE = 15L;

    public static final int TOMATO_GROWTH_DAYS = 2;
    public static final int TOMATO_BASE_YIELD = 2;
    public static final long TOMATO_SEED_PRICE = 10L;
    public static final long TOMATO_SELL_PRICE = 18L;

    // Hewan & produk
    public static final String ITEM_ANIMAL_FEED = "animal_feed";
    public static final long ANIMAL_FEED_PRICE = 12L;
    public static final String ITEM_EGG = "egg";
    public static final long EGG_SELL_PRICE = 8L;

    // Item alat awal
    public static final String TOOL_WATERING_CAN = "watering_can";
    public static final String TOOL_HOE = "hoe";
    public static final int INITIAL_TOOL_DURABILITY = 30;

    // Item perawatan / supply
    public static final String ITEM_FERTILIZER = "fertilizer";
    public static final long FERTILIZER_PRICE = 15L;
    public static final String ITEM_PESTICIDE = "pesticide";
    public static final long PESTICIDE_PRICE = 20L;
    public static final String ITEM_MEDICINE = "medicine";
    public static final long MEDICINE_PRICE = 25L;

    /**
     * Daftar item inventaris bawaan saat memulai game baru:
     * 3 wheat seed, 2 corn seed, 2 tomato seed, 2 animal feed, 1 watering can, 1 hoe.
     */
    public static List<ItemStack> getInitialInventory() {
        return List.of(
                new ItemStack(SEED_WHEAT, 3),
                new ItemStack(SEED_CORN, 2),
                new ItemStack(SEED_TOMATO, 2),
                new ItemStack(ITEM_ANIMAL_FEED, 2),
                new ItemStack(TOOL_WATERING_CAN, 1),
                new ItemStack(TOOL_HOE, 1)
        );
    }
}


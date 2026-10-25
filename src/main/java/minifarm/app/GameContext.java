package minifarm.app;

import minifarm.core.api.ItemStack;
import minifarm.core.config.GameConfig;
import minifarm.core.events.EventBus;
import minifarm.units.u01plot.PlotService;
import minifarm.units.u02crop.CropService;
import minifarm.units.u03seed.SeedCatalog;
import minifarm.units.u04watering.WateringService;
import minifarm.units.u05soil.SoilService;
import minifarm.units.u06daycycle.DayCycleService;
import minifarm.units.u07weather.WeatherService;
import minifarm.units.u08harvest.HarvestService;
import minifarm.units.u09item.ItemCatalog;
import minifarm.units.u10inventory.InventoryService;
import minifarm.units.u11tool.ToolService;
import minifarm.units.u12toolmaintenance.ToolMaintenanceService;
import minifarm.units.u13farmerprofile.FarmerProfileService;
import minifarm.units.u14energy.EnergyService;
import minifarm.units.u15animal.AnimalService;
import minifarm.units.u16animalcare.AnimalCareService;
import minifarm.units.u17animalproduction.AnimalProductionService;
import minifarm.units.u18housing.HousingService;
import minifarm.units.u19storage.StorageService;
import minifarm.units.u20shop.ShopCatalogService;
import minifarm.units.u21purchase.PurchaseService;
import minifarm.units.u22pricing.PricingService;
import minifarm.units.u23sale.SellingService;
import minifarm.units.u24wallet.WalletService;
import minifarm.units.u25quest.QuestService;
import minifarm.units.u26achievement.AchievementService;
import minifarm.units.u27skill.SkillService;
import minifarm.units.u28crafting.CraftingService;
import minifarm.units.u29order.DeliveryOrderService;
import minifarm.units.u30statistics.StatisticsService;
import minifarm.units.u31journal.JournalService;
import minifarm.units.u32crophealth.CropHealthService;
import minifarm.units.u33upgrade.*;

/**
 * Container sentral yang menginisialisasi dan menghubungkan (wiring) seluruh 33 unit modul MiniFarm.
 */
public class GameContext {
    private final EventBus eventBus = new EventBus();

    // 33 Public Facades
    private final PlotService plotService = new PlotService();
    private final CropService cropService = new CropService();
    private final SeedCatalog seedCatalog = new SeedCatalog();
    private final WateringService wateringService = new WateringService();
    private final SoilService soilService = new SoilService();
    private final WeatherService weatherService = new WeatherService();
    private final EnergyService energyService = new EnergyService();
    private final DayCycleService dayCycleService;
    private final HarvestService harvestService = new HarvestService(eventBus);
    private final ItemCatalog itemCatalog = new ItemCatalog();
    private final InventoryService inventoryService = new InventoryService();
    private final ToolService toolService = new ToolService();
    private final ToolMaintenanceService toolMaintenanceService = new ToolMaintenanceService();
    private final FarmerProfileService farmerProfileService = new FarmerProfileService();
    private final AnimalService animalService = new AnimalService();
    private final AnimalCareService animalCareService = new AnimalCareService(eventBus);
    private final AnimalProductionService animalProductionService = new AnimalProductionService(eventBus);
    private final HousingService housingService = new HousingService();
    private final StorageService storageService = new StorageService();
    private final ShopCatalogService shopCatalogService = new ShopCatalogService();
    private final PricingService pricingService = new PricingService();
    private final PurchaseService purchaseService = new PurchaseService(eventBus);
    private final SellingService sellingService = new SellingService(eventBus);
    private final WalletService walletService = new WalletService();
    private final QuestService questService = new QuestService(eventBus);
    private final AchievementService achievementService = new AchievementService(eventBus);
    private final SkillService skillService = new SkillService(eventBus);
    private final CraftingService craftingService = new CraftingService(eventBus);
    private final DeliveryOrderService deliveryOrderService = new DeliveryOrderService(eventBus);
    private final StatisticsService statisticsService = new StatisticsService(eventBus);
    private final JournalService journalService = new JournalService(eventBus);
    private final CropHealthService cropHealthService = new CropHealthService(eventBus);
    private final FarmUpgradeService farmUpgradeService = new FarmUpgradeService(eventBus);

    public GameContext() {
        // Wiring clock & daycycle
        this.dayCycleService = new DayCycleService(
                GameConfig.INITIAL_DAY,
                weatherService.getCurrentWeather(),
                eventBus,
                energyService
        );

        // Terapkan cuaca awal ke petak
        plotService.applyDailyWeather(dayCycleService.getCurrentWeather().providesRain());

        // Pasang upgrade options
        farmUpgradeService.registerUpgrade(new PlotExpansionUpgrade(plotService));
        farmUpgradeService.registerUpgrade(new StorageExpansionUpgrade(storageService));
        farmUpgradeService.registerUpgrade(new HousingExpansionUpgrade(housingService));
        farmUpgradeService.registerUpgrade(new ProtectedPlotUpgrade(plotService));

        // Inisialisasi inventaris awal sesuai SRS (3 wheat seed, 2 corn seed, 2 tomato seed, 2 feed, watering can, hoe)
        for (ItemStack item : GameConfig.getInitialInventory()) {
            inventoryService.addItem(item.getItemId(), item.getQuantity());
        }
    }

    public EventBus getEventBus() { return eventBus; }
    public PlotService getPlotService() { return plotService; }
    public CropService getCropService() { return cropService; }
    public SeedCatalog getSeedCatalog() { return seedCatalog; }
    public WateringService getWateringService() { return wateringService; }
    public SoilService getSoilService() { return soilService; }
    public DayCycleService getDayCycleService() { return dayCycleService; }
    public WeatherService getWeatherService() { return weatherService; }
    public HarvestService getHarvestService() { return harvestService; }
    public ItemCatalog getItemCatalog() { return itemCatalog; }
    public InventoryService getInventoryService() { return inventoryService; }
    public ToolService getToolService() { return toolService; }
    public ToolMaintenanceService getToolMaintenanceService() { return toolMaintenanceService; }
    public FarmerProfileService getFarmerProfileService() { return farmerProfileService; }
    public EnergyService getEnergyService() { return energyService; }
    public AnimalService getAnimalService() { return animalService; }
    public AnimalCareService getAnimalCareService() { return animalCareService; }
    public AnimalProductionService getAnimalProductionService() { return animalProductionService; }
    public HousingService getHousingService() { return housingService; }
    public StorageService getStorageService() { return storageService; }
    public ShopCatalogService getShopCatalogService() { return shopCatalogService; }
    public PricingService getPricingService() { return pricingService; }
    public PurchaseService getPurchaseService() { return purchaseService; }
    public SellingService getSellingService() { return sellingService; }
    public WalletService getWalletService() { return walletService; }
    public QuestService getQuestService() { return questService; }
    public AchievementService getAchievementService() { return achievementService; }
    public SkillService getSkillService() { return skillService; }
    public CraftingService getCraftingService() { return craftingService; }
    public DeliveryOrderService getDeliveryOrderService() { return deliveryOrderService; }
    public StatisticsService getStatisticsService() { return statisticsService; }
    public JournalService getJournalService() { return journalService; }
    public CropHealthService getCropHealthService() { return cropHealthService; }
    public FarmUpgradeService getFarmUpgradeService() { return farmUpgradeService; }
}


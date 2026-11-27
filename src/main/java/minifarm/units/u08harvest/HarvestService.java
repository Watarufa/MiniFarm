package minifarm.units.u08harvest;

import minifarm.core.api.*;
import minifarm.core.config.GameConfig;
import minifarm.core.events.CropHarvested;
import minifarm.core.events.EventBus;
import java.util.Optional;

public class HarvestService {
    private AbstractHarvestStrategy defaultStrategy;
    private final EventBus eventBus;

    public HarvestService(AbstractHarvestStrategy defaultStrategy, EventBus eventBus) {
        this.defaultStrategy = defaultStrategy != null ? defaultStrategy : new ManualHarvestStrategy();
        this.eventBus = eventBus;
    }

    public HarvestService(EventBus eventBus) {
        this(new ManualHarvestStrategy(), eventBus);
    }

    public void setStrategy(AbstractHarvestStrategy strategy) {
        if (strategy != null) {
            this.defaultStrategy = strategy;
        }
    }

    public OperationResult<Integer> harvest(int plotIndex, int day, CropSlotPort slotPort, SoilPort soilPort,
            InventoryPort inventoryPort, EnergyPort energyPort, ToolEffectPort toolPort) {
        // Validasi tanaman
        Optional<CropSnapshot> cropOpt = slotPort.getCropSnapshot(plotIndex);
        if (cropOpt.isEmpty()) {
            return OperationResult.failed(ResultCode.NOT_FOUND, "Petak kosong, tidak ada tanaman untuk dipanen");
        }
        CropSnapshot crop = cropOpt.get();
        if (crop.getHealth() <= 0) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Tanaman telah layu/mati dan tidak bisa dipanen");
        }
        if (!crop.isMature()) {
            return OperationResult.failed(ResultCode.INVALID_STATE, "Tanaman belum matang (Hari " + crop.getGrowthDay() + "/" + crop.getDaysToMature() + ")");
        }

        // Validasi energi & alat
        OperationResult<Void> reqCheck = defaultStrategy.validateRequirements(energyPort, toolPort);
        if (reqCheck.isFailure()) {
            return OperationResult.failed(reqCheck.getCode(), reqCheck.getMessage());
        }

        // Hitung hasil panen
        boolean soilBonus = soilPort != null && soilPort.getSoilSnapshot(plotIndex).getFertility() >= 80;

        int baseYield = switch (crop.getCropType().toLowerCase()) {
            case "corn" -> GameConfig.CORN_BASE_YIELD;
            case "tomato" -> GameConfig.TOMATO_BASE_YIELD;
            default -> GameConfig.WHEAT_BASE_YIELD;
        };

        int yieldCount = defaultStrategy.calculateFinalYield(baseYield, soilBonus, toolPort);

        // Cek inventaris, lalu tambahkan hasil
        if (inventoryPort.getAvailableSlots() <= 0 && !inventoryPort.hasItem(crop.getCropType(), 1)) {
            return OperationResult.failed(ResultCode.CAPACITY_EXCEEDED, "Slot inventaris penuh, panen dibatalkan");
        }

        OperationResult<Void> addRes = inventoryPort.addItem(crop.getCropType(), yieldCount);
        if (addRes.isFailure()) {
            return OperationResult.failed(addRes.getCode(), addRes.getMessage());
        }

        // Kosongkan petak, potong energi, publikasikan event
        slotPort.takeCrop(plotIndex);
        energyPort.consumeEnergy(defaultStrategy.getEnergyCost());

        if (eventBus != null) {
            eventBus.publish(new CropHarvested(day, plotIndex, crop.getCropType(), yieldCount));
        }

        return OperationResult.ok("Panen berhasil: " + yieldCount + " " + crop.getCropType(), yieldCount);
    }
}

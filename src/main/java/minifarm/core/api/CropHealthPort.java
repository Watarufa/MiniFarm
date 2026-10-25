package minifarm.core.api;

/**
 * Port integrasi domain untuk memodifikasi dan memeriksa kesehatan tanaman.
 */
public interface CropHealthPort {
    int getHealth(int plotIndex);
    OperationResult<Void> damageCrop(int plotIndex, int damageAmount, String reason);
    OperationResult<Void> restoreHealth(int plotIndex, int healAmount);
}


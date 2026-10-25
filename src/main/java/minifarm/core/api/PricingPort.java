package minifarm.core.api;

/**
 * Port integrasi perhitungan harga dinamis/polimorfik.
 */
public interface PricingPort {
    long calculatePrice(long basePrice, int quantity, int qualityLevel);
}


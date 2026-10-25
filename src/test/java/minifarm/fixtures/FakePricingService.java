package minifarm.fixtures;

import minifarm.core.api.PricingPort;

/**
 * In-memory test double untuk PricingPort agar U23 dapat diuji tanpa bergantung pada U22.
 */
public class FakePricingService implements PricingPort {

    @Override
    public long calculatePrice(long basePrice, int quantity, int qualityLevel) {
        return basePrice * quantity;
    }
}

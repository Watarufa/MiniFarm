package minifarm.units.u22pricing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("U22")
@Tag("unit")
class PricingServiceTest {

    private PricingService pricingService;

    @BeforeEach
    void setUp() {
        pricingService = new PricingService();
    }

    @Test
    @DisplayName("Strategi harga dasar tetap (Fixed) menghitung total = basePrice * quantity")
    void calculatePrice_withFixedStrategy_returnsAccurateSubtotal() {
        long price = pricingService.calculatePrice(10L, 5, 1);
        assertEquals(50L, price);
    }

    @Test
    @DisplayName("Bukti Polymorphism: QualityPricingStrategy meningkatkan harga sesuai level kualitas")
    void polymorphicStrategy_qualityPricingIncreasesPrice() {
        PricingService qualityService = new PricingService(new QualityPricingStrategy());

        long normal = qualityService.calculatePrice(10L, 1, 1); // Level 1 -> 1.0x -> 10
        long highQuality = qualityService.calculatePrice(10L, 1, 2); // Level 2 -> 1.2x -> 12

        assertEquals(10L, normal);
        assertEquals(12L, highQuality);
    }

    @Test
    @DisplayName("Bukti Polymorphism: BulkDiscountPricingStrategy memberikan diskon 15% pada quantity >= 20")
    void polymorphicStrategy_bulkDiscountAppliesOnlyAtThreshold() {
        PricingService bulkService = new PricingService(new BulkDiscountPricingStrategy());

        long underThreshold = bulkService.calculatePrice(10L, 10, 1); // 10 * 10 = 100
        long overThreshold = bulkService.calculatePrice(10L, 20, 1); // 10 * 20 * 0.85 = 170

        assertEquals(100L, underThreshold);
        assertEquals(170L, overThreshold);
    }
}


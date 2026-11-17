package minifarm.units.u20shop;

import java.util.*;

public abstract class AbstractShopSection {
    private final String sectionName;
    private final Map<String, Long> offerings = new LinkedHashMap<>();

    protected AbstractShopSection(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() { return sectionName; }

    public void addOffering(String itemId, long price) {
        if (itemId != null && price >= 0) {
            offerings.put(itemId.toLowerCase(), price);
        }
    }

    public boolean hasItem(String itemId) {
        return itemId != null && offerings.containsKey(itemId.toLowerCase());
    }

    public long getPrice(String itemId) {
        if (itemId == null) { return -1; }

        return offerings.getOrDefault(itemId.toLowerCase(), -1L);
    }

    public Map<String, Long> getOfferings() {
        return Collections.unmodifiableMap(offerings);
    }

    public abstract boolean acceptsCategory(String category);
}

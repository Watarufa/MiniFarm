package minifarm.units.u20shop;

import minifarm.core.api.OperationResult;
import minifarm.core.api.ResultCode;
import minifarm.core.api.ShopCatalogPort;
import java.util.*;

public class ShopCatalogService implements ShopCatalogPort {
    private final List<AbstractShopSection> sections = new ArrayList<>();

    public ShopCatalogService() {
        sections.add(new SeedShopSection());
        sections.add(new ToolShopSection());
        sections.add(new SupplyShopSection());
    }

    public List<AbstractShopSection> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public boolean isItemForSale(String itemId) {
        if (itemId == null) return  false;

        for (AbstractShopSection sec : sections) {
            if (sec.hasItem(itemId)) return true;
        }
        return false;
    }

    public OperationResult<Long> getItemPrice(String itemId) {
        if (itemId == null) {
            return OperationResult.failed(ResultCode.INVALID_ARGUMENT, "Item tidak valid");
        }
        for (AbstractShopSection sec : sections) {
            if (sec.hasItem(itemId)) {
                return OperationResult.ok("Item tersedia", sec.getPrice(itemId));
            }

        }
        return OperationResult.failed(ResultCode.NOT_FOUND, "Barang tidak dijual di toko: " + itemId);
    }
}

package minifarm.core.api;

/**
 * Port integrasi katalog toko untuk pengecekan dan pencarian harga item.
 */
public interface ShopCatalogPort {
    OperationResult<Long> getItemPrice(String itemId);
}


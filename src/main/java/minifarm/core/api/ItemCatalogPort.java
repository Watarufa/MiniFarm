package minifarm.core.api;

import java.util.Optional;

/**
 * Port integrasi katalog taksonomi item pertanian.
 */
public interface ItemCatalogPort {
    Optional<? extends ItemDefinitionPort> getItem(String itemId);
}


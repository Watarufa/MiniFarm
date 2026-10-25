package minifarm.core.api;

/**
 * Kontrak definisi item pertanian untuk alur transaksi.
 */
public interface ItemDefinitionPort {
    String getItemId();
    String getDisplayName();
    long getBasePrice();
    boolean canSell();
}


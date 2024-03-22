package com.gildedtros;

public class KeyChainInventoryItem extends InventoryItem {
    protected static final String NAME = "B-DAWG Keychain";

    public KeyChainInventoryItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
    }

    @Override
    public void updateExpiration() {
    }

    @Override
    public void processExpiration() {
    }
}

package com.gildedtros;

public class SmellyInventoryItems extends InventoryItem {
    protected static final String[] NAMES = new String[]{"Duplicate Code", "Long Methods", "Ugly Variable Names"};

    public SmellyInventoryItems(Item item) {
        super(item);
    }

    @Override
    public void decreaseQuality() {
        updateInventory(item.quality > 0, -2);
    }

}

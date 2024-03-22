package com.gildedtros;

public class GoodWineInventoryItem extends InventoryItem {
    protected static final String NAME = "Good Wine";

    public GoodWineInventoryItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
    }

    @Override
    public void processExpiration() {
        if (item.sellIn < 0) {
            increaseQuality();
        }
    }

}

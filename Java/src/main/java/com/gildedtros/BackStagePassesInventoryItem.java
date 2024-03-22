package com.gildedtros;

public class BackStagePassesInventoryItem extends InventoryItem {
    protected static final String[] NAMES = new String[]{"Backstage passes for Re:Factor", "Backstage passes for HAXX"};

    public BackStagePassesInventoryItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        if (item.sellIn < 11) {
            increaseQuality();
        }
        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    public void processExpiration() {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}

package com.gildedtros;

import java.util.Arrays;

public class InventoryItem {
    protected Item item;

    public InventoryItem(Item item){
        this.item = item;
    }

    public static InventoryItem create(Item item){
        if (item.name.equals(GoodWineInventoryItem.NAME)) {
            return new GoodWineInventoryItem(item);
        }
        if (Arrays.stream(BackStagePassesInventoryItem.NAMES).anyMatch(item.name::equals)) {
            return new BackStagePassesInventoryItem(item);
        }
        if (item.name.equals(KeyChainInventoryItem.NAME)) {
            return new KeyChainInventoryItem(item);
        }
        return new InventoryItem(item);
    }

    public void updateQuality() {
        decreaseQuality();
    }

    public void updateExpiration() {
        item.sellIn = item.sellIn - 1;
    }

    public void processExpiration() {
        if (item.sellIn < 0) {
            decreaseQuality();
        }
    }

    protected void decreaseQuality() {
        updateInventory(item.quality > 0, -1);
    }

    protected void increaseQuality() {
        updateInventory(item.quality < 50, 1);
    }

    protected void updateInventory(boolean b, int i) {
        if (b) {
            item.quality = item.quality + i;
        }
    }
}

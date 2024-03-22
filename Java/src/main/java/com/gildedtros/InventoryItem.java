package com.gildedtros;

public class InventoryItem {
    private Item item;

    public InventoryItem(Item item){
        this.item = item;
    }

    public void updateQuality() {
        if(item.name.equals("Good Wine")) {
            increaseQuality();
        } else if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")){
            increaseQuality();
            if (item.sellIn < 11) {
                increaseQuality();
            }
            if (item.sellIn < 6) {
                increaseQuality();
            }
        } else if (item.name.equals("B-DAWG Keychain")) {
            return;
        } else {
            decreaseQuality();
        }
    }

    public void updateExpiration() {
        if (item.name.equals("B-DAWG Keychain")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    public void processExpiration() {
        if (item.sellIn < 0) {
            if (item.name.equals("Good Wine")) {
                increaseQuality();
            } else if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")) {
                item.quality = 0;
            }
            else if (item.name.equals("B-DAWG Keychain")) {
                return;
            } else {
                decreaseQuality();
            }
        }
    }

    private void decreaseQuality() {
        updateInventory(item.quality > 0, -1);
    }

    private void increaseQuality() {
        updateInventory(item.quality < 50, 1);
    }

    private void updateInventory(boolean b, int i) {
        if (b) {
            item.quality = item.quality + i;
        }
    }
}

package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item: items) {
            updateInventory(item);
            updateExpiration(item);
            processExpiration(item);
        }
    }

    private void updateInventory(Item item) {
        if(item.name.equals("Good Wine")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")){
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else if (item.name.equals("B-DAWG Keychain")) {
            return;
        } else {
            decreaseQuality(item);
        }
    }

    private void updateExpiration(Item item) {
        if (item.name.equals("B-DAWG Keychain")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    private void processExpiration(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Good Wine")) {
                increaseQuality(item);
            } else if (item.name.equals("Backstage passes for Re:Factor") || item.name.equals("Backstage passes for HAXX")) {
                item.quality = 0;
            }
            else if (item.name.equals("B-DAWG Keychain")) {
                return;
            } else {
                decreaseQuality(item);
            }
        }
    }

    private void decreaseQuality(Item item) {
        updateInventory(item, item.quality > 0, -1);
    }

    private void increaseQuality(Item item) {
        updateInventory(item, item.quality < 50, 1);
    }

    private void updateInventory(Item item, boolean b, int i) {
        if (b) {
            item.quality = item.quality + i;
        }
    }
}
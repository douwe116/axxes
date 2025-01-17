package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item: items) {
            InventoryItem inventoryItem = InventoryItem.create(item);
            inventoryItem.updateQuality();
            inventoryItem.updateExpiration();
            inventoryItem.processExpiration();
        }
    }


}
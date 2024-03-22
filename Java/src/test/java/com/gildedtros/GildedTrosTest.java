package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    @Test
    void nonNegativeQuality() {
        Item[] items = new Item[] { new Item("itemName", 0, 0) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("itemName", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void qualityDegarationWhenBad() {
        Item[] items = new Item[] { new Item("itemName", 0, 10) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("itemName", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    @Test
    void qualityDegarationWhenGood() {
        Item[] items = new Item[] { new Item("itemName", 10, 10) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("itemName", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }
    @Test
    void goodWine() {
        Item[] items = new Item[] { new Item("Good Wine", 10, 10) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("Good Wine", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    @Test
    void maxQuality() {
        Item[] items = new Item[] { new Item("Good Wine", 10, 50) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("Good Wine", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void keychain() {
        Item[] items = new Item[] { new Item("B-DAWG Keychain", 10, 80) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("B-DAWG Keychain", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
    @Test
    void backstagePasses10Days() {
        Item[] items = new Item[] { new Item("Backstage passes for Re:Factor", 9, 10) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("Backstage passes for Re:Factor", app.items[0].name);
        assertEquals(8, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    @Test
    void backstagePasses5Days() {
        Item[] items = new Item[] { new Item("Backstage passes for HAXX", 4, 10) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("Backstage passes for HAXX", app.items[0].name);
        assertEquals(3, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    @Test
    void backstagePasses0Days() {
        Item[] items = new Item[] { new Item("Backstage passes for HAXX", 0, 10) };
        GildedTros app = new GildedTros(items);
        app.updateInventory();
        assertEquals("Backstage passes for HAXX", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}

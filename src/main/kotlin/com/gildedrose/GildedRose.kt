package com.gildedrose

import com.gildedrose.utilities.toBaseItem
import com.gildedrose.utilities.toItem

/*
* Notes:
* - Even though the readme says that items shouldnt have Quality > 50. We can force it... Should we validate and normalize that?
* - I don't like that we are using a mutable list. I would prefer for updateQuality to have the following signature:
*   fun updateQuality(items: List<Item>) : List<Item>
* */
class GildedRose(
    var items: Array<Item>
) {

    private fun refactoredUpdateQuality(items: Array<Item>): Array<Item> =
        items.map { e -> e.toBaseItem }
            .onEach { e -> e.switchDay() }
            .map { e -> e.toItem }
            .toTypedArray()

    private fun oldUpdateQuality() {
        for (i in items.indices) {
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

    fun updateQuality() {
        val newItems = refactoredUpdateQuality(items)

        items = newItems
    }
}

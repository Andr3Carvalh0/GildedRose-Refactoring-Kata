package com.gildedrose.dtos

import com.gildedrose.dtos.base.LegendaryItem

class Sulfuras(
    sellIn: Int,
    quality: Int
) : LegendaryItem(NAME, sellIn, quality) {
    companion object {
        const val NAME = "Sulfuras, Hand of Ragnaros"
    }
}

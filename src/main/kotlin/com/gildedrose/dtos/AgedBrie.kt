package com.gildedrose.dtos

import com.gildedrose.dtos.base.BaseItem

class AgedBrie(
    sellIn: Int,
    quality: Int
) : BaseItem(NAME, sellIn, quality) {
    companion object {
        const val NAME = "Aged Brie"
    }

    override fun updateQuality() {
        quality += 1
    }
}

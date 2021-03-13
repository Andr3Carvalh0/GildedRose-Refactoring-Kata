package com.gildedrose.controllers

import com.gildedrose.Item
import com.gildedrose.controllers.base.BaseItemController

class AgedBrieController(item: Item) : BaseItemController(item) {

    companion object {
        const val NAME = "Aged Brie"
    }

    override fun shouldUpdateQuality(): Boolean = item.quality != MAX_QUALITY

    override fun updateQuality() {
        item.quality += 1
    }
}

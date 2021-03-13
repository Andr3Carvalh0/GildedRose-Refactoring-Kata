package com.gildedrose.controllers

import com.gildedrose.Item
import com.gildedrose.controllers.base.BaseItemController
import com.gildedrose.utilities.toInt

class NormalItemController(item: Item) : BaseItemController(item) {

    override fun updateQuality() {
        item.quality = item.quality - 1 - isExpired().toInt
    }
}

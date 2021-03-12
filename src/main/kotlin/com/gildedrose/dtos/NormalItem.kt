package com.gildedrose.dtos

import com.gildedrose.dtos.base.BaseItem
import com.gildedrose.utilities.toInt

class NormalItem(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun updateQuality() {
        quality = quality - 1 - isExpired().toInt
    }
}

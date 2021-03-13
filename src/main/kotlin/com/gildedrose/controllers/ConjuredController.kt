package com.gildedrose.controllers

import com.gildedrose.Item
import com.gildedrose.controllers.base.BaseItemController
import kotlin.math.max

private const val EXPIRED_QUALITY_MODIFIER = 4
private const val QUALITY_MODIFIER = 2

class Conjured(item: Item) : BaseItemController(item) {

    companion object {
        const val NAME = "Conjured Mana Cake"
    }

    override fun updateQuality() {
        item.quality = max(0, item.quality - if (isExpired()) EXPIRED_QUALITY_MODIFIER else QUALITY_MODIFIER)
    }
}

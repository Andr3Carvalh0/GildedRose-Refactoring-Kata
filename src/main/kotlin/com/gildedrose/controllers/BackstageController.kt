package com.gildedrose.controllers

import com.gildedrose.Item
import com.gildedrose.controllers.base.BaseItemController
import com.gildedrose.utilities.toInt
import kotlin.math.min

private const val URGENT_DAY_MARK = 11
private const val SUPER_URGENT_DAY_MARK = 6

class Backstage(item: Item) : BaseItemController(item) {

    companion object {
        const val NAME = "Backstage passes to a TAFKAL80ETC concert"
    }

    override fun updateQuality() {
        item.quality = if (!isExpired()) {
            val modifier = 1 + isUrgent().toInt + isSuperUrgent().toInt

            min(MAX_QUALITY, item.quality + (1 * modifier))
        } else MIN_QUALITY
    }

    private fun isUrgent(): Boolean = item.sellIn < URGENT_DAY_MARK

    private fun isSuperUrgent(): Boolean = item.sellIn < SUPER_URGENT_DAY_MARK
}

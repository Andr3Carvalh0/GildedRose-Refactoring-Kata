package com.gildedrose.dtos

import com.gildedrose.dtos.base.BaseItem
import com.gildedrose.utilities.toInt
import kotlin.math.min

private const val URGENT_DAY_MARK = 11
private const val SUPER_URGENT_DAY_MARK = 6

class Backstage(
    sellIn: Int,
    quality: Int
) : BaseItem(NAME, sellIn, quality) {
    companion object {
        const val NAME = "Backstage passes to a TAFKAL80ETC concert"
    }

    override fun updateQuality() {
        quality = if (!isExpired()) {
            val modifier = 1 + isUrgent().toInt + isSuperUrgent().toInt

            min(MAX_QUALITY, quality + (1 * modifier))
        } else MIN_QUALITY
    }

    private fun isUrgent(): Boolean = sellIn < URGENT_DAY_MARK

    private fun isSuperUrgent(): Boolean = sellIn < SUPER_URGENT_DAY_MARK
}

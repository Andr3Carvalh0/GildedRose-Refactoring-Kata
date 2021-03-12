package com.gildedrose.dtos

import com.gildedrose.dtos.base.BaseItem
import kotlin.math.max

private const val EXPIRED_QUALITY_MODIFIER = 4
private const val QUALITY_MODIFIER = 2

class Conjured(
    sellIn: Int,
    quality: Int
) : BaseItem(NAME, sellIn, quality) {
    companion object {
        const val NAME = "Conjured Mana Cake"
    }

    override fun updateQuality() {
        quality = max(0, quality - if (isExpired()) EXPIRED_QUALITY_MODIFIER else QUALITY_MODIFIER)
    }
}

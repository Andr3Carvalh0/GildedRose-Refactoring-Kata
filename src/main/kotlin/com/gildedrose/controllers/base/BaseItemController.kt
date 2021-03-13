package com.gildedrose.controllers.base

import com.gildedrose.Item

abstract class BaseItemController(val item: Item) {

    companion object {
        const val MIN_QUALITY = 0
        const val MAX_QUALITY = 50
    }

    fun switchDay() {
        if (shouldUpdateQuality()) updateQuality()
        if (shouldUpdateSellBy()) updateSellBy()
    }

    protected open fun shouldUpdateQuality(): Boolean = item.quality != MIN_QUALITY && item.quality != MAX_QUALITY

    protected open fun shouldUpdateSellBy(): Boolean = true

    protected open fun updateQuality() { }

    protected open fun updateSellBy() { item.sellIn -= 1 }

    protected fun isExpired(): Boolean = item.sellIn <= 0
}

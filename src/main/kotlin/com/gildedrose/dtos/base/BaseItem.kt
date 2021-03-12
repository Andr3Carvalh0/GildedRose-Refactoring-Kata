package com.gildedrose.dtos.base

private const val MIN_QUALITY = 0
private const val MAX_QUALITY = 50

abstract class BaseItem(
    var name: String,
    var sellIn: Int,
    var quality: Int
) {

    fun switchDay() {
        if (shouldUpdateQuality()) updateQuality()
        if (shouldUpdateSellBy()) updateSellBy()
    }

    protected open fun shouldUpdateQuality(): Boolean = quality != MIN_QUALITY && quality != MAX_QUALITY

    protected open fun shouldUpdateSellBy(): Boolean = true

    protected open fun updateQuality() { }

    protected open fun updateSellBy() { sellIn -= 1 }

    protected fun isExpired(): Boolean = sellIn <= 0
}

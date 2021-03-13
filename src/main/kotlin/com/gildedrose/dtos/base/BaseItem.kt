package com.gildedrose.dtos.base

abstract class BaseItem(
    val name: String,
    sellIn: Int,
    quality: Int
) {
    companion object {
        const val MIN_QUALITY = 0
        const val MAX_QUALITY = 50
    }

    var sellIn: Int = sellIn
        protected set

    var quality: Int = quality
        protected set

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

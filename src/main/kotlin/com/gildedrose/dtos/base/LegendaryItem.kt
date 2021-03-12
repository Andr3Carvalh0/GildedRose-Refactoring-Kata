package com.gildedrose.dtos.base

abstract class LegendaryItem(
    name: String,
    sellIn: Int,
    quality: Int
) : BaseItem(name, sellIn, quality) {

    override fun shouldUpdateQuality(): Boolean = false

    override fun shouldUpdateSellBy(): Boolean = false
}

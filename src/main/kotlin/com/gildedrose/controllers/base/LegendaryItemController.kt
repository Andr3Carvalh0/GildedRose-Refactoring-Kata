package com.gildedrose.controllers.base

import com.gildedrose.Item

abstract class LegendaryItemController(item: Item) : BaseItemController(item) {

    override fun shouldUpdateQuality(): Boolean = false

    override fun shouldUpdateSellBy(): Boolean = false
}

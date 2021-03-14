package com.gildedrose.factory

import com.gildedrose.Item
import com.gildedrose.controllers.base.BaseItemController

interface IBaseItemFactory {
    fun transform(item: Item): BaseItemController
}

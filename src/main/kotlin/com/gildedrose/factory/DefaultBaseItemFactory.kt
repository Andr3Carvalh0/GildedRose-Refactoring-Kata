package com.gildedrose.factory

import com.gildedrose.Item
import com.gildedrose.controllers.base.BaseItemController
import com.gildedrose.utilities.toBaseItem

class DefaultBaseItemFactory : IBaseItemFactory {

    override fun transform(item: Item): BaseItemController = item.toBaseItem
}

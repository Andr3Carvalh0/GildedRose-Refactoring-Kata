package com.gildedrose

import com.gildedrose.factory.DefaultBaseItemFactory
import com.gildedrose.factory.IBaseItemFactory

/*
* Notes:
* - Even though the readme says that items shouldnt have Quality > 50. We can force it...
*   Should we validate and normalize that?
* */
class GildedRose(
    var items: Array<Item>,
    private val baseItemFactory: IBaseItemFactory = DefaultBaseItemFactory()
) {

    fun updateQuality() {
        items.map { e -> baseItemFactory.transform(e) }
            .onEach { e -> e.switchDay() }
    }
}

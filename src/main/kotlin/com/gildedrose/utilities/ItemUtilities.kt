package com.gildedrose.utilities

import com.gildedrose.Item
import com.gildedrose.dtos.AgedBrie
import com.gildedrose.dtos.Backstage
import com.gildedrose.dtos.Conjured
import com.gildedrose.dtos.NormalItem
import com.gildedrose.dtos.Sulfuras
import com.gildedrose.dtos.base.BaseItem

/*
* For short amount of items, a when is fine.
* If there are multiple values that route to the same class/longer list,
* I would probably use a collection of "factories" with keys and generators to route the instantiation of
* the data classes
* */
val Item.toBaseItem
    get() =
        when (name.toLowerCase()) {
            AgedBrie.NAME.toLowerCase() -> AgedBrie(sellIn, quality)
            Backstage.NAME.toLowerCase() -> Backstage(sellIn, quality)
            Conjured.NAME.toLowerCase() -> Conjured(sellIn, quality)
            Sulfuras.NAME.toLowerCase() -> Sulfuras(sellIn, quality)
            else -> NormalItem(name, sellIn, quality)
        }

val BaseItem.toItem
    get() = Item(name, sellIn, quality)

package com.gildedrose.utilities

import com.gildedrose.Item
import com.gildedrose.dtos.AgedBrie
import com.gildedrose.dtos.Backstage
import com.gildedrose.dtos.Conjured
import com.gildedrose.dtos.NormalItem
import com.gildedrose.dtos.Sulfuras

val Item.toBaseItem
    get() = when (name) {
        AgedBrie.NAME -> AgedBrie(sellIn, quality)
        Backstage.NAME -> Backstage(sellIn, quality)
        Conjured.NAME -> Conjured(sellIn, quality)
        Sulfuras.NAME -> Sulfuras(sellIn, quality)
        else -> NormalItem(name, sellIn, quality)
    }

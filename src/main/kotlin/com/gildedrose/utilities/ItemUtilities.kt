package com.gildedrose.utilities

import com.gildedrose.Item
import com.gildedrose.controllers.AgedBrieController
import com.gildedrose.controllers.Backstage
import com.gildedrose.controllers.Conjured
import com.gildedrose.controllers.NormalItemController
import com.gildedrose.controllers.Sulfuras
import com.gildedrose.controllers.base.BaseItemController

/*
* For short amount of items, a when is fine.
* If there are multiple values that route to the same class/longer list,
* I would probably use a collection of "factories" with keys and generators to route the instantiation of
* the data classes
* */
val Item.toBaseItem
    get() =
        when (name.toLowerCase()) {
            AgedBrieController.NAME.toLowerCase() -> AgedBrieController(this)
            Backstage.NAME.toLowerCase() -> Backstage(this)
            Conjured.NAME.toLowerCase() -> Conjured(this)
            Sulfuras.NAME.toLowerCase() -> Sulfuras(this)
            else -> NormalItemController(this)
        }

val BaseItemController.toItem
    get() = this.item

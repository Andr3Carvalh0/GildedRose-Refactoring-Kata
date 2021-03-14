package com.gildedrose.utilities

import com.gildedrose.Item
import com.gildedrose.controllers.AgedBrieController
import com.gildedrose.controllers.BackstageController
import com.gildedrose.controllers.ConjuredController
import com.gildedrose.controllers.NormalItemController
import com.gildedrose.controllers.SulfurasController
import com.gildedrose.controllers.base.BaseItemController

/*
* Notes:
* - For short amount of items, a when is fine.
*   If there are multiple values that route to the same class/longer list,
*   I would probably use a collection of "factories" with keys and generators to route the instantiation of
*   the data classes
* */
val Item.toBaseItem
    get() =
        when (name.toLowerCase()) {
            AgedBrieController.NAME.toLowerCase() -> AgedBrieController(this)
            BackstageController.NAME.toLowerCase() -> BackstageController(this)
            ConjuredController.NAME.toLowerCase() -> ConjuredController(this)
            SulfurasController.NAME.toLowerCase() -> SulfurasController(this)
            else -> NormalItemController(this)
        }

val BaseItemController.toItem
    get() = this.item

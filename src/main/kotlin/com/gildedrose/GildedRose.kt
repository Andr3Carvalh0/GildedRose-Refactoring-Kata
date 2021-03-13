package com.gildedrose

import com.gildedrose.utilities.toBaseItem
import com.gildedrose.utilities.toItem

/*
* Notes:
* - Even though the readme says that items shouldnt have Quality > 50. We can force it... Should we validate and normalize that?
* - I don't like that we are using a mutable list. I would prefer for updateQuality to have the following signature:
*   fun updateQuality(items: List<Item>) : List<Item>
* */
class GildedRose(
    var items: Array<Item>
) {

    private fun refactoredUpdateQuality(items: Array<Item>): Array<Item> =
        items.map { e -> e.toBaseItem }
            .onEach { e -> e.switchDay() }
            .map { e -> e.toItem }
            .toTypedArray()

    fun updateQuality() {
        refactoredUpdateQuality(items)
    }
}

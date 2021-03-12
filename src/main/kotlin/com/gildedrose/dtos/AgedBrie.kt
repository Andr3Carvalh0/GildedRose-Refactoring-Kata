package com.gildedrose.dtos

class AgedBrie(
    _sellIn: Int,
    _quality: Int
) : BaseItem(NAME, _sellIn, _quality) {
    companion object {
        const val NAME = "Aged Brie"
    }
}

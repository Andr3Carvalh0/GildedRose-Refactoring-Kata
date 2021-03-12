package com.gildedrose.dtos

class Sulfuras(
    _sellIn: Int,
    _quality: Int
) : BaseItem(NAME, _sellIn, _quality) {
    companion object {
        const val NAME = "Sulfuras, Hand of Ragnaros"
    }
}

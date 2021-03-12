package com.gildedrose.dtos

class Backstage(
    _sellIn: Int,
    _quality: Int
) : BaseItem(NAME, _sellIn, _quality) {
    companion object {
        const val NAME = "Backstage passes to a TAFKAL80ETC concert"
    }
}

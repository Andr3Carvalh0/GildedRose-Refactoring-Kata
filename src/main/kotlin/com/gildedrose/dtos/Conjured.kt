package com.gildedrose.dtos

class Conjured(
    _sellIn: Int,
    _quality: Int
) : BaseItem(NAME, _sellIn, _quality) {
    companion object {
        const val NAME = "Conjured Mana Cake"
    }
}

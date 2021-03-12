package com.gildedrose.dtos

import com.gildedrose.Item

abstract class BaseItem(
    _name: String,
    _sellIn: Int,
    _quality: Int
) : Item(_name, _sellIn, _quality)

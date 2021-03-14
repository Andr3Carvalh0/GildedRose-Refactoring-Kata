package com.gildedrose.controllers

import com.gildedrose.AMOUNT_OF_DAYS
import com.gildedrose.GildedRose
import com.gildedrose.Item
import com.gildedrose.QUALITY
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AgedBrieControllerTest {

    companion object {
        const val ITEM_NAME = AgedBrieController.NAME
        const val NORMAL_SELL_BY = 20
        const val SUPER_URGENT_SELL_BY = 5
        const val MAX_QUALITY = 50
    }

    @Test
    fun `When brie item its quality should increase each day`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, NORMAL_SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(QUALITY + (i + 1), inn.items[0].quality)
            Assertions.assertEquals(NORMAL_SELL_BY - (i + 1), inn.items[0].sellIn)
        }
    }

    @Test
    fun `When brie item its quality should never be higher than 50`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, SUPER_URGENT_SELL_BY, MAX_QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(MAX_QUALITY, inn.items[0].quality)
        }
    }

    @Test
    fun `When brie item has 0 has quality it should increase`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, SUPER_URGENT_SELL_BY, 0))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(i + 1, inn.items[0].quality)
        }
    }
}

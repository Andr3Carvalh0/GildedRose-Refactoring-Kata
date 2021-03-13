package com.gildedrose.controllers

import com.gildedrose.AMOUNT_OF_DAYS
import com.gildedrose.EXPIRED_SELL_BY
import com.gildedrose.GildedRose
import com.gildedrose.Item
import com.gildedrose.QUALITY
import com.gildedrose.SELL_BY
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConjuredTest {

    companion object {
        const val ITEM_NAME = "Conjured Mana Cake"
    }

    @Test
    fun `When conjured item its quality drops twice when sell by is still greater than 0`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(QUALITY - ((i + 1) * 2), inn.items[0].quality)
            Assertions.assertEquals(SELL_BY - (i + 1), inn.items[0].sellIn)
        }
    }

    @Test
    fun `When conjured item its quality drops four time when expired`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, EXPIRED_SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(QUALITY - ((i + 1) * 4), inn.items[0].quality)
            Assertions.assertEquals(EXPIRED_SELL_BY - (i + 1), inn.items[0].sellIn)
        }
    }

    @Test
    fun `When conjured item its quality should never reach below 0`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, SELL_BY, 0))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(0, inn.items[0].quality)
            Assertions.assertEquals(SELL_BY - (i + 1), inn.items[0].sellIn)
        }
    }
}

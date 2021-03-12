package com.gildedrose.items

import com.gildedrose.AMOUNT_OF_DAYS
import com.gildedrose.EXPIRED_SELL_BY
import com.gildedrose.GildedRose
import com.gildedrose.Item
import com.gildedrose.QUALITY
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BackstageTest {

    companion object {
        const val ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert"
        const val NORMAL_SELL_BY = 20
        const val URGENT_SELL_BY = 10
        const val SUPER_URGENT_SELL_BY = 5
        const val MAX_QUALITY = 50
    }

    @Test
    fun `When backstage item its quality should increase each day`() {
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
    fun `When backstage item its quality should increase twice as fast if sell by date is less or equal to 10`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, URGENT_SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(QUALITY + ((i + 1) * 2), inn.items[0].quality)
            Assertions.assertEquals(URGENT_SELL_BY - (i + 1), inn.items[0].sellIn)
        }
    }

    @Test
    fun `When backstage item its quality should increase 3x as fast if sell by date is less or equal to 5`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, SUPER_URGENT_SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(QUALITY + ((i + 1) * 3), inn.items[0].quality)
            Assertions.assertEquals(SUPER_URGENT_SELL_BY - (i + 1), inn.items[0].sellIn)
        }
    }

    @Test
    fun `When backstage item its quality should be 0 after expiration date`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, EXPIRED_SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(0, inn.items[0].quality)
        }
    }

    @Test
    fun `When backstage item its quality should never be higher than 50`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, SUPER_URGENT_SELL_BY, MAX_QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(MAX_QUALITY, inn.items[0].quality)
        }
    }
}

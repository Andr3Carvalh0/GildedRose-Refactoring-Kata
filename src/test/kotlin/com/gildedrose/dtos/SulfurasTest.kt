package com.gildedrose.dtos

import com.gildedrose.AMOUNT_OF_DAYS
import com.gildedrose.GildedRose
import com.gildedrose.Item
import com.gildedrose.QUALITY
import com.gildedrose.SELL_BY
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SulfurasTest {

    companion object {
        const val ITEM_NAME = "Sulfuras, Hand of Ragnaros"
        const val EXPIRED_SELL_BY = -1
    }

    @Test
    fun `When item is Sulfuras its quality never changes`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(QUALITY, inn.items[0].quality)
        }
    }

    @Test
    fun `When item is Sulfuras its sell by never changes`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(SELL_BY, inn.items[0].sellIn)
        }
    }

    @Test
    fun `When item is Sulfuras and its sell by has past its quality should remain the same`() {
        val inn = GildedRose(
            arrayOf(Item(ITEM_NAME, EXPIRED_SELL_BY, QUALITY))
        )

        for (i in 0 until AMOUNT_OF_DAYS) {
            inn.updateQuality()
            Assertions.assertEquals(QUALITY, inn.items[0].quality)
        }
    }
}

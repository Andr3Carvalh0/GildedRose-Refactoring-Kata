package com.gildedrose.utilities

import com.gildedrose.Item
import com.gildedrose.dtos.AgedBrie
import com.gildedrose.dtos.Backstage
import com.gildedrose.dtos.Conjured
import com.gildedrose.dtos.NormalItem
import com.gildedrose.dtos.Sulfuras
import com.gildedrose.randomizeCapitalization
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ItemUtilitiesTest {

    @Test
    fun `When Item is AgedBrie the toBaseItem extension returns an AgedBrie instance`() {
        val item = Item(AgedBrie.NAME, 0, 0)

        Assertions.assertEquals(true, item.toBaseItem is AgedBrie)
    }

    @Test
    fun `When Item is AgedBrie the toBaseItem extension returns an AgedBrie instance no matter the case sensitivity`() {
        listOf(
            Item(AgedBrie.NAME.randomizeCapitalization(), 0, 0),
            Item(AgedBrie.NAME.toLowerCase(), 0, 0)
        ).forEach {
            Assertions.assertEquals(true, it.toBaseItem is AgedBrie)
        }
    }

    @Test
    fun `When Item is Backstage the toBaseItem extension returns an Backstage instance`() {
        val item = Item(Backstage.NAME, 0, 0)

        Assertions.assertEquals(true, item.toBaseItem is Backstage)
    }

    @Test
    fun `When Item is Backstage the toBaseItem extension returns an Backstage instance no matter the case sensitivity`() {
        listOf(
            Item(Backstage.NAME.randomizeCapitalization(), 0, 0),
            Item(Backstage.NAME.toLowerCase(), 0, 0)
        ).forEach {
            Assertions.assertEquals(true, it.toBaseItem is Backstage)
        }
    }

    @Test
    fun `When Item is Conjured the toBaseItem extension returns an Conjured instance`() {
        val item = Item(Conjured.NAME, 0, 0)

        Assertions.assertEquals(true, item.toBaseItem is Conjured)
    }

    @Test
    fun `When Item is Conjured the toBaseItem extension returns an Conjured instance no matter the case sensitivity`() {
        listOf(
            Item(Conjured.NAME.randomizeCapitalization(), 0, 0),
            Item(Conjured.NAME.toLowerCase(), 0, 0)
        ).forEach {
            Assertions.assertEquals(true, it.toBaseItem is Conjured)
        }
    }

    @Test
    fun `When Item is Sulfuras the toBaseItem extension returns an Sulfuras instance`() {
        val item = Item(Sulfuras.NAME, 0, 0)

        Assertions.assertEquals(true, item.toBaseItem is Sulfuras)
    }

    @Test
    fun `When Item is Sulfuras the toBaseItem extension returns an Sulfuras instance no matter the case sensitivity`() {
        listOf(
            Item(Sulfuras.NAME.randomizeCapitalization(), 0, 0),
            Item(Sulfuras.NAME.toLowerCase(), 0, 0)
        ).forEach {
            Assertions.assertEquals(true, it.toBaseItem is Sulfuras)
        }
    }

    @Test
    fun `When Item doesnt have a category the toBaseItem extension returns a NormalItem instance`() {
        listOf(
            Item("+5 Dexterity Vest", 0, 0),
            Item("Elixir of the Mongoose", 0, 0)
        ).forEach {
            Assertions.assertEquals(true, it.toBaseItem is NormalItem)
        }
    }
}

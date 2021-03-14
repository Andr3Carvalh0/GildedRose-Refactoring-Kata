package com.gildedrose.factory

import com.gildedrose.Item
import com.gildedrose.controllers.AgedBrieController
import com.gildedrose.controllers.BackstageController
import com.gildedrose.controllers.ConjuredController
import com.gildedrose.controllers.NormalItemController
import com.gildedrose.controllers.SulfurasController
import com.gildedrose.randomizeCapitalization
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DefaultBaseItemFactoryTest {

    @Test
    fun `When Item is AgedBrie the factory returns an AgedBrie instance`() {
        val item = Item(AgedBrieController.NAME, 0, 0)

        Assertions.assertEquals(true, DefaultBaseItemFactory().transform(item) is AgedBrieController)
    }

    @Test
    fun `When Item is AgedBrie the factory returns an AgedBrie instance no matter the case sensitivity`() {
        listOf(
            Item(AgedBrieController.NAME.randomizeCapitalization(), 0, 0),
            Item(AgedBrieController.NAME.toLowerCase(), 0, 0)
        ).forEach {
            Assertions.assertEquals(true, DefaultBaseItemFactory().transform(it) is AgedBrieController)
        }
    }

    @Test
    fun `When Item is Backstage the factory returns an Backstage instance`() {
        val item = Item(BackstageController.NAME, 0, 0)

        Assertions.assertEquals(true, DefaultBaseItemFactory().transform(item) is BackstageController)
    }

    @Test
    fun `When Item is Backstage the factory returns an Backstage instance no matter the case sensitivity`() {
        listOf(
            Item(BackstageController.NAME.randomizeCapitalization(), 0, 0),
            Item(BackstageController.NAME.toLowerCase(), 0, 0)
        ).forEach {
            Assertions.assertEquals(true, DefaultBaseItemFactory().transform(it) is BackstageController)
        }
    }

    @Test
    fun `When Item is Conjured the factory returns an Conjured instance`() {
        val item = Item(ConjuredController.NAME, 0, 0)

        Assertions.assertEquals(true, DefaultBaseItemFactory().transform(item) is ConjuredController)
    }

    @Test
    fun `When Item is Conjured the factory returns an Conjured instance no matter the case sensitivity`() {
        listOf(
            Item(ConjuredController.NAME.randomizeCapitalization(), 0, 0),
            Item(ConjuredController.NAME.toLowerCase(), 0, 0)
        ).forEach {
            Assertions.assertEquals(true, DefaultBaseItemFactory().transform(it) is ConjuredController)
        }
    }

    @Test
    fun `When Item is Sulfuras the factory returns an Sulfuras instance`() {
        val item = Item(SulfurasController.NAME, 0, 0)

        Assertions.assertEquals(true, DefaultBaseItemFactory().transform(item) is SulfurasController)
    }

    @Test
    fun `When Item is Sulfuras the factory returns an Sulfuras instance no matter the case sensitivity`() {
        listOf(
            Item(SulfurasController.NAME.randomizeCapitalization(), 0, 0),
            Item(SulfurasController.NAME.toLowerCase(), 0, 0)
        ).forEach {
            Assertions.assertEquals(true, DefaultBaseItemFactory().transform(it) is SulfurasController)
        }
    }

    @Test
    fun `When Item doesnt have a category the factory returns a NormalItem instance`() {
        listOf(
            Item("+5 Dexterity Vest", 0, 0),
            Item("Elixir of the Mongoose", 0, 0)
        ).forEach {
            Assertions.assertEquals(true, DefaultBaseItemFactory().transform(it) is NormalItemController)
        }
    }
}

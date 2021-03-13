package com.gildedrose.utilities

import com.gildedrose.randomizeCapitalization
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StringUtilitiesTest {

    @Test
    fun `randomizeCapitalization returns the same string content but different capitalization`() {
        val text = "Ola eu sou o André"

        Assertions.assertEquals(text.toLowerCase(), text.randomizeCapitalization().toLowerCase())
        Assertions.assertNotEquals(text, text.randomizeCapitalization())
    }
}

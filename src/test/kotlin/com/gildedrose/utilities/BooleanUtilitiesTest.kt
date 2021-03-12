package com.gildedrose.utilities

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BooleanUtilitiesTest {

    @Test
    fun `True value is transformed into 1`() {
        Assertions.assertEquals(1, true.toInt)
    }

    @Test
    fun `False value is transformed into 0`() {
        Assertions.assertEquals(0, false.toInt)
    }
}

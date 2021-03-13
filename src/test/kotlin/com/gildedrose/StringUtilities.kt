package com.gildedrose

import kotlin.random.Random

fun String.randomizeCapitalization(): String {
    return toCharArray()
        .map {
            if (Random.nextInt(0, 100) % 2 == 0) {
                it.toUpperCase()
            } else {
                it.toLowerCase()
            }
        }
        .joinToString("")
}

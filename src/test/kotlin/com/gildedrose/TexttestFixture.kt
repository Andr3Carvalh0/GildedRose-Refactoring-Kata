package com.gildedrose

private const val APPLY_FIX = false

/*
* Question: With the refactor, since we are just pointin to a newly created array instead of using this `items` references
* meaning with the refactor the code will have different behaviour. (all the days will show the initial values)
* Is this something thats important or nah?
*/
fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Item("Aged Brie", 2, 0), //
        Item("Elixir of the Mongoose", 5, 7), //
        Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        Item("Sulfuras, Hand of Ragnaros", -1, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        Item("Conjured Mana Cake", 3, 6)
    )

    val app = GildedRose(items)

    var days = 2
    if (args.size > 0) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("name, sellIn, quality")

        val inventory = if (APPLY_FIX) app.items else items

        for (item in inventory) {
            println(item)
        }

        println()
        app.updateQuality()
    }
}

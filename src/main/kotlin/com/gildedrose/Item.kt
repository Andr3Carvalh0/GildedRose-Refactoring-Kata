package com.gildedrose

/*
* Notes:
* - I would convert this to a data class and remove the toString, since thats impl on data classes
*   But the goblin wont allow me to touch this class :)
*/
open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

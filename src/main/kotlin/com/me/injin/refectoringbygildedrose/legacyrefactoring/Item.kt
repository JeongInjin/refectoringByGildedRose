package com.me.injin.refectoringbygildedrose.legacyrefactoring

open class Item(
    var name: String = "",
    var sellIn: Int = 0,
    var quality: Int = 0
) {
    companion object {
        fun of(name: String, sellIn: Int, quality: Int): Item {
            return when (name) {
                "Sulfuras, Hand of Ragnaros" -> Sulfuras(sellIn, quality)
                "Backstage passes to a TAFKAL80ETC concert" -> Backstage(sellIn, quality)
                "Aged Brie" -> Aged(sellIn, quality)
                else -> Item(name, sellIn, quality)
            }
        }
    }

    open fun updateQualityFor() {
        if (quality > 0) {
            quality -= 1
        }
        sellIn -= 1
        if (sellIn < 0 && quality > 0) {
            quality -= 1
        }
    }

    override fun toString(): String {
        return "Item(name=$name, sellIn=$sellIn, quality=$quality)"
    }

}
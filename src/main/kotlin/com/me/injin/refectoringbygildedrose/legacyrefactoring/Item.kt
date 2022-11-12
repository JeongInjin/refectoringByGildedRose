package com.me.injin.refectoringbygildedrose.legacyrefactoring

open class Item(
    var name: String = "",
    var sellIn: Int = 0,
    var quality: Int = 0
) {
    companion object {
        fun of(name: String, sellIn: Int, quality: Int): Item {
            when (name) {
                "Sulfuras, Hand of Ragnaros" -> {
                    return Sulfuras(sellIn, quality)
                }
                "Backstage passes to a TAFKAL80ETC concert" -> {
                    return Backstage(sellIn, quality)
                }
                "Aged Brie" -> {
                    return Aged(sellIn, quality)
                }
                else -> {
                    return Item(name, sellIn, quality)
                }
            }
        }
    }


    open fun updateQualityFor() {
        when (this.name) {
            "Sulfuras, Hand of Ragnaros" -> {

            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                if (this.quality < 50) {
                    this.quality = this.quality + 1
                    if (this.sellIn < 11 && this.quality < 50) {
                        this.quality = this.quality + 1
                    }
                    if (this.sellIn < 6 && this.quality < 50) {
                        this.quality = this.quality + 1
                    }
                }
                this.sellIn = this.sellIn - 1
                if (this.sellIn < 0) {
                    this.quality = 0
                }
            }
            "Aged Brie" -> {
                if (this.quality < 50) {
                    this.quality = this.quality + 1
                }
                this.sellIn = this.sellIn - 1
                if (this.sellIn < 0 && this.quality < 50) {
                    this.quality = this.quality + 1
                }
            }
            else -> {
                if (this.quality > 0) {
                    this.quality = this.quality - 1
                }
                this.sellIn = this.sellIn - 1
                if (this.sellIn < 0 && this.quality > 0) {
                    this.quality = this.quality - 1
                }
            }
        }
    }

    override fun toString(): String {
        return "Item(name=$name, sellIn=$sellIn, quality=$quality)"
    }

}
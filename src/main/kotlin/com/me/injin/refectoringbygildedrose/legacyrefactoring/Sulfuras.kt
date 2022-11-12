package com.me.injin.refectoringbygildedrose.legacyrefactoring

class Sulfuras(sellIn: Int, quality: Int) : Item("Sulfuras, Hand of Ragnaros", sellIn, quality) {
    override fun updateQualityFor() {
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
}

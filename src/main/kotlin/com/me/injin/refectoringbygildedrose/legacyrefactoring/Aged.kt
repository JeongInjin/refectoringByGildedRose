package com.me.injin.refectoringbygildedrose.legacyrefactoring

class Aged(sellIn: Int, quality: Int) : Item("Aged Brie", sellIn, quality) {
    override fun updateQualityFor() {
        when (this.name) {
            "Aged Brie" -> {
                if (this.quality < 50) {
                    this.quality = this.quality + 1
                }
                this.sellIn = this.sellIn - 1
                if (this.sellIn < 0 && this.quality < 50) {
                    this.quality = this.quality + 1
                }
            }
        }
    }

}

package com.me.injin.refectoringbygildedrose.legacyrefactoring

class Backstage(sellIn: Int, quality: Int) : Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    override fun updateQualityFor() {
        when (this.name) {
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
        }
    }

}

package com.me.injin.refectoringbygildedrose.legacyrefactoring

class Backstage(sellIn: Int, quality: Int) : Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    override fun updateQualityFor() {
        when (name) {
            "Backstage passes to a TAFKAL80ETC concert" -> {
                if (quality < 50) {
                    quality += 1
                    if (sellIn < 11 && quality < 50) {
                        quality += 1
                    }
                    if (sellIn < 6 && quality < 50) {
                        quality += 1
                    }
                }
                sellIn -= 1
                if (sellIn < 0) {
                    quality = 0
                }
            }
        }
    }

}

package com.me.injin.refectoringbygildedrose.legacyrefactoring

class Aged(sellIn: Int, quality: Int) : Item("Aged Brie", sellIn, quality) {
    override fun updateQualityFor() {
        when (name) {
            "Aged Brie" -> {
                if (quality < 50) {
                    quality += 1
                }
                sellIn -= 1
                if (sellIn < 0 && quality < 50) {
                    quality += 1
                }
            }
        }
    }

}

package com.me.injin.refectoringbygildedrose.legacyrefactoring

class Item(
    var name: String? = null,
    var sellIn: Int = 0,
    var quality: Int = 0
) {
    override fun toString(): String {
        return "Item(name=$name, sellIn=$sellIn, quality=$quality)"
    }
}
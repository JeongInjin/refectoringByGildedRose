package com.me.injin.refectoringbygildedrose.legacyrefactoring

import org.approvaltests.combinations.CombinationApprovals
import org.junit.jupiter.api.Test


class GildedRoseTest {

    @Test
    fun updateQuality() {
        val name = arrayOf("foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros")
        val sellIn = arrayOf(-1, 0, 1, 6, 11)
        val quality = arrayOf(0, 1, 49, 50)

        //여러 조합으로 테스트 해야할 시
        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, name, sellIn, quality)
    }

    fun doUpdateQuality(name: String, sellIn: Int, quality: Int): String {
        val sut = GildedRose(arrayOf(Item(name, sellIn, quality)))
        sut.updateQuality()
        return sut.items[0].toString()
    }
}
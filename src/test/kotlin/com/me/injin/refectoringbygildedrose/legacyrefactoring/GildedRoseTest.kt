package com.me.injin.refectoringbygildedrose.legacyrefactoring

import org.approvaltests.combinations.CombinationApprovals
import org.junit.jupiter.api.Test


class GildedRoseTest {

    @Test
    fun updateQuality() {
//        //given
//        val sut = GildedRose(arrayOf(Item("foo", 0, 0)))
//        //when
//        sut.updateQuality()
//        //then
//        assertThat(sut.items[0].toString()).isEqualTo("Item(name=foo, sellIn=-1, quality=0)")
//
//        //approval test
//        Approvals.verify(sut.items[0].toString())

        val name = arrayOf("foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros")
        val sellIn = arrayOf(-1, 0, 11)
        val quality = arrayOf(0, 1, 50)

        //여러 조합으로 테스트 해야할 시
        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, name, sellIn, quality)
    }

    fun doUpdateQuality(name: String, sellIn: Int, quality: Int): String {
        val sut = GildedRose(arrayOf(Item(name, sellIn, quality)))
        sut.updateQuality()
        return sut.items[0].toString()
    }
}
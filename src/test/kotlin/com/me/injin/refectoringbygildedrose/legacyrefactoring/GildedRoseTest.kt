package com.me.injin.refectoringbygildedrose.legacyrefactoring

import org.approvaltests.Approvals
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class GildedRoseTest {

    @Test
    fun updateQuality() {
        //given
        val sut = GildedRose(arrayOf(Item("foo", 0, 0)))
        //when
        sut.updateQuality()
        //then
        assertThat(sut.items[0].toString()).isEqualTo("Item(name=foo, sellIn=-1, quality=0)")

        //approval test
        Approvals.verify(sut.items[0].toString())
    }
}
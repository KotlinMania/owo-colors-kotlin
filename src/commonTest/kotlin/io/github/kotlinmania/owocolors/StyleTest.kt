// port-lint: tests src/tests.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StyleTest {

    @Test
    fun defaultStyleIsPlain() {
        val s = Style()
        assertEquals(null, s.fg)
        assertEquals(null, s.bg)
        assertEquals(false, s.bold)
        assertTrue(s.styleFlags.isPlain())
    }

    @Test
    fun styleFactoryReturnsDefault() {
        assertEquals(Style(), style())
    }

    @Test
    fun foregroundColorEncodesAsSgrCode() {
        val output = style().red().style("hi").toString()
        assertEquals("[31mhi[0m", output)
    }

    @Test
    fun backgroundColorEncodesAsSgrCode() {
        val output = style().onBlue().style("hi").toString()
        assertEquals("[44mhi[0m", output)
    }

    @Test
    fun boldStyleEncodesFirstThenForegroundColor() {
        val output = style().white().bold().style("title").toString()
        assertEquals("[1;37mtitle[0m", output)
    }

    @Test
    fun emptyStyleEmitsTargetVerbatim() {
        val output = Style().style("no styling").toString()
        assertEquals("no styling", output)
    }

    @Test
    fun strikethroughEffectFlag() {
        val output = style().strikethrough().style("gone").toString()
        assertEquals("[9mgone[0m", output)
    }

    @Test
    fun multipleEffectFlagsCombine() {
        val output = style().italic().underline().style("emph").toString()
        assertEquals("[3;4memph[0m", output)
    }

    @Test
    fun purpleIsMagentaAlias() {
        assertEquals(style().magenta().style("x").toString(), style().purple().style("x").toString())
    }

    @Test
    fun removeFgClearsForeground() {
        val s = style().red().removeFg()
        assertEquals(null, s.fg)
    }

    @Test
    fun styleFlagsBitPacking() {
        val flags = StyleFlags()
            .withDimmed(true)
            .withItalic(true)
            .withStrikethrough(true)
        assertTrue(flags.dimmed())
        assertTrue(flags.italic())
        assertTrue(flags.strikethrough())
        assertEquals(false, flags.blink())
        assertEquals(false, flags.underline())
    }

    @Test
    fun styledIsCharSequence() {
        val styled: CharSequence = style().red().style("xy")
        assertEquals("[31mxy[0m", styled.toString())
        assertEquals('', styled[0])
    }
}

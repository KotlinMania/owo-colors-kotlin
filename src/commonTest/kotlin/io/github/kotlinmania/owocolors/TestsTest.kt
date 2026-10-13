// port-lint: tests tests.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals

class TestsTest {
    @Test
    fun testFg() {
        assertEquals("\u001b[30mtest\u001b[39m", "test".fg(Black).toString())
        assertEquals("\u001b[31mblah blah\u001b[39m", "blah blah".red().toString())
    }

    @Test
    fun testBg() {
        assertEquals("\u001b[40mtest\u001b[49m", "test".bg(Black).toString())
        assertEquals("\u001b[41mblah blah\u001b[49m", "blah blah".onRed().toString())
    }

    @Test
    fun testDynFg() {
        assertEquals("\u001b[30mtest\u001b[39m", "test".color(AnsiColors.Black).toString())
        assertEquals("\u001b[31mblah blah\u001b[39m", "blah blah".color(AnsiColors.Red).toString())
    }

    @Test
    fun testDynBg() {
        assertEquals("\u001b[40mtest\u001b[49m", "test".onColor(AnsiColors.Black).toString())
        assertEquals("\u001b[41mblah blah\u001b[49m", "blah blah".onColor(AnsiColors.Red).toString())
    }

    @Test
    fun testBgEffect() {
        run {
            val style = Style().underline().onBlue()
            assertEquals("\u001b[44;4mtest\u001b[0m", "test".style(style).toString())
        }

        run {
            val style = Style().italic().onRed()
            assertEquals("\u001b[41;3mtest\u001b[0m", "test".style(style).toString())
        }
    }

    @Test
    fun testHex() {
        assertEquals(
            "\u001b[31m0000000A\u001b[39m",
            0xa
                .toString(16)
                .uppercase()
                .padStart(8, '0')
                .red()
                .toString(),
        )
    }

    @Test
    fun testCssName() {
        assertEquals(
            "\u001b[38;2;230;230;250mtest\u001b[39m",
            "test".fg(Lavender).toString(),
        )
    }

    @Test
    fun testParse() {
        assertEquals(DynColors.Ansi(AnsiColors.Yellow), DynColors.fromStr("yellow"))
        assertEquals(DynColors.Ansi(AnsiColors.Blue), DynColors.fromStr("blue"))
        assertEquals(DynColors.Rgb(235, 64, 52), DynColors.fromStr("#eb4034"))
    }

    @Test
    fun defaultColor() {
        val formatted = "red red red ${"default color".defaultColor()} no color".red().toString()
        assertEquals(
            "\u001b[31mred red red \u001b[39mdefault color\u001b[39m no color\u001b[39m",
            formatted,
        )
    }
}

// port-lint: tests owo-colors/src/dyn_styles.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DynStylesTest {
    // Upstream size-of test asserts exact byte layout.
    // Not ported: Kotlin's Style is a heap-allocated data class with no
    // 10-byte layout guarantee — the upstream assertion is checking the
    // bit-packed representation, which has no equivalent on the JVM
    // or Kotlin/Native.

    @Test
    fun testIt() {
        val style =
            Style()
                .brightWhite()
                .onBlue()
                .bold()
                .dimmed()
                .italic()
                .underline()
                .blink()
                // .blinkFast()
                // .reversed()
                // .hidden()
                .strikethrough()
        val s = style.style("TEST")
        val s2 = s.toString()
        assertEquals("\u001B[97;44;1;2;3;4;5;9mTEST\u001B[0m", s2)

        val prefix = style.prefixFormatter().toString()
        assertEquals("\u001B[97;44;1;2;3;4;5;9m", prefix)

        val suffix = style.suffixFormatter().toString()
        assertEquals("\u001B[0m", suffix)
    }

    @Test
    fun testEffects() {
        val style = Style().effects(Effect.Strikethrough, Effect.Underline)

        val s = style.style("TEST")
        val s2 = s.toString()
        assertEquals("\u001B[4;9mTEST\u001B[0m", s2)
    }

    @Test
    fun testColor() {
        val style =
            Style()
                .color(AnsiColors.White)
                .onColor(AnsiColors.Black)

        val s = style.style("TEST")
        val s2 = s.toString()
        assertEquals("\u001B[37;40mTEST\u001B[0m", s2)
    }

    @Test
    fun testTruecolor() {
        val style = Style().truecolor(255, 255, 255).onTruecolor(0, 0, 0)

        val s = style.style("TEST")
        val s2 = s.toString()
        assertEquals("\u001B[38;2;255;255;255;48;2;0;0;0mTEST\u001B[0m", s2)
    }

    @Test
    fun testStringReference() {
        val style = Style().truecolor(255, 255, 255).onTruecolor(0, 0, 0)

        val string = "TEST"
        val s = style.style(string)
        val s2 = s.toString()
        assertEquals("\u001B[38;2;255;255;255;48;2;0;0;0mTEST\u001B[0m", s2)
    }

    @Test
    fun testOwocolorize() {
        val style = Style().brightWhite().onBlue()

        val s = "TEST".style(style)
        val s2 = s.toString()
        assertEquals("\u001B[97;44mTEST\u001B[0m", s2)
    }

    @Test
    fun testIsPlain() {
        val style = Style().brightWhite().onBlue()

        assertFalse(style.isPlain())
        assertTrue(Style().isPlain())

        val string = "TEST"
        val s = Style().style(string)
        val s2 = s.toString()

        assertEquals(string, s2)
    }

    @Test
    fun testInner() {
        val style = Style()
        val s = "TEST".style(style)

        assertEquals("TEST", s.inner())
    }

    @Test
    fun testDynColorsParse() {
        val red = DynColors.fromStr("red")
        assertEquals(DynColors.Ansi(AnsiColors.Red), red)

        val hex = DynColors.fromStr("#ff8000")
        assertEquals(DynColors.Rgb(255, 128, 0), hex)
    }
}

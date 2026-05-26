// port-lint: tests src/dyn_styles.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals

class DynStylesTest {

    // Upstream `size_of` asserts `std::mem::size_of::<Style>() == 10`.
    // Not ported: Kotlin's Style is a heap-allocated data class with no
    // 10-byte layout guarantee — the upstream assertion is checking the
    // bit-packed Rust representation, which has no equivalent on the JVM
    // or Kotlin/Native.

    @Test
    fun test_it() {
        val style = Style()
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
    fun test_effects() {
        val style = Style().effects(Effect.Strikethrough, Effect.Underline)

        val s = style.style("TEST")
        val s2 = s.toString()
        assertEquals("\u001B[4;9mTEST\u001B[0m", s2)
    }

    @Test
    fun test_color() {
        val style = Style()
            .color(AnsiColors.White)
            .onColor(AnsiColors.Black)

        val s = style.style("TEST")
        val s2 = s.toString()
        assertEquals("\u001B[37;40mTEST\u001B[0m", s2)
    }
}

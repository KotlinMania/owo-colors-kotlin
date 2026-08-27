// port-lint: tests owo-colors/src/tests.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals

class TestsTest {
    // Upstream foreground and background tests exercise the OwoColorize extension
    // form. Not ported: OwoColorize trait is not yet ported, so there is no
    // Kotlin extension to translate.

    // Upstream dynamic foreground and background tests exercise OwoColorize.
    // Same gap: OwoColorize is unported.

    @Test
    fun testBgEffect() {
        run {
            val style = Style().underline().onBlue()
            assertEquals("\u001B[44;4mtest\u001B[0m", style.style("test").toString())
        }

        run {
            val style = Style().italic().onRed()
            assertEquals("\u001B[41;3mtest\u001B[0m", style.style("test").toString())
        }
    }

    // Upstream hex formatting test formats with hex display. Not ported: the
    // OwoColorize trait is unported.

    // Upstream CSS name test uses CSS colors. Not ported: the CSS color module is unported.

    // Upstream parse test uses string parse for DynColors. Not ported: the
    // parser for DynColors is unported.

    // Upstream default color test uses format argument chaining and the
    // OwoColorize extension form. Not ported: same OwoColorize gap.
}

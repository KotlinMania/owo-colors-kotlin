// port-lint: tests tests.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals

class TestsTest {
    // Upstream `test_fg` and `test_bg` exercise the OwoColorize extension
    // form ("test".red() / "test".on_red()). Not ported: OwoColorize trait
    // is not yet ported, so there is no Kotlin extension to translate.

    // Upstream `test_dyn_fg` and `test_dyn_bg` exercise OwoColorize::color
    // and OwoColorize::on_color. Same gap: OwoColorize is unported.

    @Test
    fun test_bg_effect() {
        run {
            val style = Style().underline().onBlue()
            assertEquals("\u001B[44;4mtest\u001B[0m", style.style("test").toString())
        }

        run {
            val style = Style().italic().onRed()
            assertEquals("\u001B[41;3mtest\u001B[0m", style.style("test").toString())
        }
    }

    // Upstream `test_hex` formats `0xa.red()` with the UpperHex Display
    // impl. Not ported: the `OwoColorize` trait is unported and Kotlin has
    // no Display-trait-per-format-spec equivalent.

    // Upstream `test_css_name` uses `Lavender` from `colors::css`. Not
    // ported: the CSS color module is unported.

    // Upstream `test_parse` uses `str::parse::<DynColors>`. Not ported: the
    // FromStr impl for DynColors is unported.

    // Upstream `default_color` uses `format_args!` chaining and the
    // OwoColorize extension form. Not ported: same OwoColorize gap.
}

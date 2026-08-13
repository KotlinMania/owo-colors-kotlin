// port-lint: tests src/combo.rs
package io.github.kotlinmania.owocolors

// Upstream combo.rs tests exercise the OwoColorize extension form on string
// literals: `"test".red().on_blue()`, `"test".color(AnsiColors::Red)`, etc.
//
// Not ported: the OwoColorize trait is not yet ported, so there is no Kotlin
// extension method to translate the call sites. The equivalent behavior on
// the Style builder is already covered by `dyn_styles.rs::test_color` and
// `dyn_styles.rs::test_it`.
internal object ComboTest

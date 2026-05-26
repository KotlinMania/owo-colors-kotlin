// port-lint: tests src/overrides.rs
package io.github.kotlinmania.owocolors

// Upstream overrides.rs tests `with_override` and `set_override` against the
// `OVERRIDE` global. Not ported: the overrides module is unported (it
// relies on `if_supports_color` / `SupportsColorsDisplay`, which is gated
// on the `supports-colors` feature and uses `std::panic::catch_unwind` plus
// thread-local mutable globals — none of those have Kotlin equivalents yet
// in this port).

// port-lint: tests styled_list.rs
package io.github.kotlinmania.owocolors

// Upstream styled_list.rs tests exercise StyledList and the Transition enum
// for emitting compact SGR sequences across a list of pre-styled items.
//
// Not ported: StyledList and Transition are unported in this MVP (they
// require the full Style fmt_prefix/fmt_suffix transition logic plus the
// IntoIterator impls that Kotlin would express as a custom collection
// wrapper).
internal object StyledListTest

// port-lint: source src/dyn_colors.rs
package io.github.kotlinmania.owocolors

/**
 * Available colors for the purpose of setting one at runtime.
 */
public sealed interface DynColors {

    /**
     * One of the [AnsiColors] standard ANSI colors.
     */
    public data class Ansi(public val color: AnsiColors) : DynColors
}

// port-lint: source src/dyn_colors.rs
package io.github.kotlinmania.owocolors

/**
 * Available standard ANSI colors that can be set as either a foreground or
 * background color.
 *
 * Mirrors upstream `DynColors`, which is a runtime-tagged enum of every kind
 * of color owo-colors knows about. For now this port covers the 16 ANSI 4-bit
 * colors (the [Ansi] variant); upstream also supports `Css`, `Xterm`,
 * `Rgb(r,g,b)`, and `Fixed(u8)`, and a `default_color` fallback. Those map to
 * additional [DynColors] variants when their consumers are ported.
 */
public sealed interface DynColors {

    /**
     * One of the 16 standard ANSI colors. Equivalent to upstream
     * `DynColors::Ansi(AnsiColors)`.
     */
    public data class Ansi(public val color: AnsiColors) : DynColors

    /**
     * Active terminal default for the given role (foreground or background).
     * Equivalent to upstream `DynColors::Ansi(AnsiColors::Default)`'s
     * "no-op restore" behavior at the SGR layer.
     */
    public data object Default : DynColors
}

/**
 * The 16 standard ANSI colors. Mirrors upstream `AnsiColors`.
 *
 * `default` is the terminal-default sentinel: emitting `[39m`
 * (foreground) or `[49m` (background) resets only the color while
 * leaving other SGR attributes alone, which the Rust upstream models as
 * `AnsiColors::Default` and exposes through `Style::default_color`.
 */
public enum class AnsiColors(public val fgCode: Int, public val bgCode: Int) {
    Black(30, 40),
    Red(31, 41),
    Green(32, 42),
    Yellow(33, 43),
    Blue(34, 44),
    Magenta(35, 45),
    Cyan(36, 46),
    White(37, 47),
    Default(39, 49),
    BrightBlack(90, 100),
    BrightRed(91, 101),
    BrightGreen(92, 102),
    BrightYellow(93, 103),
    BrightBlue(94, 104),
    BrightMagenta(95, 105),
    BrightCyan(96, 106),
    BrightWhite(97, 107),
}

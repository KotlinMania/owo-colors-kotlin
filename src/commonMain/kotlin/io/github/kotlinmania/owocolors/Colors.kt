// port-lint: source owo-colors/src/colors.rs
// Color types for used for being generic over the color
package io.github.kotlinmania.owocolors

/**
 * Available standard ANSI colors for use with [Style.color] or
 * [Style.onColor].
 */
public enum class AnsiColors(
    internal val fg: Int,
    internal val bg: Int,
) {
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

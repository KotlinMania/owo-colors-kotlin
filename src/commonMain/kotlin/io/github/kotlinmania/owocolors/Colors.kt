// port-lint: source colors.rs
// Color types used for being generic over the color
package io.github.kotlinmania.owocolors

/**
 * A trait for describing a type which can be used with [FgColorDisplay] or [BgColorDisplay].
 */
public interface Color : DynColor {
    public val ansiFg: String
    public val ansiBg: String
    public val rawAnsiFg: String
    public val rawAnsiBg: String
    public val dynColorsEquivalent: DynColors

    override fun fmtAnsiFg(): String = ansiFg

    override fun fmtAnsiBg(): String = ansiBg

    override fun fmtRawAnsiFg(): String = rawAnsiFg

    override fun fmtRawAnsiBg(): String = rawAnsiBg

    override fun getDyncolorsFg(): DynColors = dynColorsEquivalent

    override fun getDyncolorsBg(): DynColors = dynColorsEquivalent
}

/**
 * A trait describing a runtime-configurable color which can be displayed using
 * [FgDynColorDisplay] or [BgDynColorDisplay].
 */
public interface DynColor {
    public fun fmtAnsiFg(): String

    public fun fmtAnsiBg(): String

    public fun fmtRawAnsiFg(): String

    public fun fmtRawAnsiBg(): String

    public fun getDyncolorsFg(): DynColors

    public fun getDyncolorsBg(): DynColors
}

/**
 * Available standard ANSI colors for use with [Style.color] or
 * [Style.onColor].
 */
public enum class AnsiColors(
    public val fg: Int,
    public val bg: Int,
) : DynColor {
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
    ;

    override fun fmtAnsiFg(): String = "\u001b[${fg}m"

    override fun fmtAnsiBg(): String = "\u001b[${bg}m"

    override fun fmtRawAnsiFg(): String = "$fg"

    override fun fmtRawAnsiBg(): String = "$bg"

    override fun getDyncolorsFg(): DynColors = DynColors.Ansi(this)

    override fun getDyncolorsBg(): DynColors = DynColors.Ansi(this)

    public companion object {
        public fun fromStr(color: String): AnsiColors =
            when (color.lowercase()) {
                "black" -> Black
                "red" -> Red
                "green" -> Green
                "yellow" -> Yellow
                "blue" -> Blue
                "magenta", "purple" -> Magenta
                "cyan" -> Cyan
                "white" -> White
                "bright black" -> BrightBlack
                "bright red" -> BrightRed
                "bright green" -> BrightGreen
                "bright yellow" -> BrightYellow
                "bright blue" -> BrightBlue
                "bright magenta" -> BrightMagenta
                "bright cyan" -> BrightCyan
                "bright white" -> BrightWhite
                else -> White
            }
    }
}

public object Black : Color {
    override val ansiFg: String = "\u001b[30m"
    override val ansiBg: String = "\u001b[40m"
    override val rawAnsiFg: String = "30"
    override val rawAnsiBg: String = "40"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.Black)
}

public object Red : Color {
    override val ansiFg: String = "\u001b[31m"
    override val ansiBg: String = "\u001b[41m"
    override val rawAnsiFg: String = "31"
    override val rawAnsiBg: String = "41"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.Red)
}

public object Green : Color {
    override val ansiFg: String = "\u001b[32m"
    override val ansiBg: String = "\u001b[42m"
    override val rawAnsiFg: String = "32"
    override val rawAnsiBg: String = "42"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.Green)
}

public object Yellow : Color {
    override val ansiFg: String = "\u001b[33m"
    override val ansiBg: String = "\u001b[43m"
    override val rawAnsiFg: String = "33"
    override val rawAnsiBg: String = "43"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.Yellow)
}

public object Blue : Color {
    override val ansiFg: String = "\u001b[34m"
    override val ansiBg: String = "\u001b[44m"
    override val rawAnsiFg: String = "34"
    override val rawAnsiBg: String = "44"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.Blue)
}

public object Magenta : Color {
    override val ansiFg: String = "\u001b[35m"
    override val ansiBg: String = "\u001b[45m"
    override val rawAnsiFg: String = "35"
    override val rawAnsiBg: String = "45"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.Magenta)
}

public object Cyan : Color {
    override val ansiFg: String = "\u001b[36m"
    override val ansiBg: String = "\u001b[46m"
    override val rawAnsiFg: String = "36"
    override val rawAnsiBg: String = "46"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.Cyan)
}

public object White : Color {
    override val ansiFg: String = "\u001b[37m"
    override val ansiBg: String = "\u001b[47m"
    override val rawAnsiFg: String = "37"
    override val rawAnsiBg: String = "47"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.White)
}

public object Default : Color {
    override val ansiFg: String = "\u001b[39m"
    override val ansiBg: String = "\u001b[49m"
    override val rawAnsiFg: String = "39"
    override val rawAnsiBg: String = "49"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.Default)
}

public object BrightBlack : Color {
    override val ansiFg: String = "\u001b[90m"
    override val ansiBg: String = "\u001b[100m"
    override val rawAnsiFg: String = "90"
    override val rawAnsiBg: String = "100"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.BrightBlack)
}

public object BrightRed : Color {
    override val ansiFg: String = "\u001b[91m"
    override val ansiBg: String = "\u001b[101m"
    override val rawAnsiFg: String = "91"
    override val rawAnsiBg: String = "101"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.BrightRed)
}

public object BrightGreen : Color {
    override val ansiFg: String = "\u001b[92m"
    override val ansiBg: String = "\u001b[102m"
    override val rawAnsiFg: String = "92"
    override val rawAnsiBg: String = "102"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.BrightGreen)
}

public object BrightYellow : Color {
    override val ansiFg: String = "\u001b[93m"
    override val ansiBg: String = "\u001b[103m"
    override val rawAnsiFg: String = "93"
    override val rawAnsiBg: String = "103"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.BrightYellow)
}

public object BrightBlue : Color {
    override val ansiFg: String = "\u001b[94m"
    override val ansiBg: String = "\u001b[104m"
    override val rawAnsiFg: String = "94"
    override val rawAnsiBg: String = "104"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.BrightBlue)
}

public object BrightMagenta : Color {
    override val ansiFg: String = "\u001b[95m"
    override val ansiBg: String = "\u001b[105m"
    override val rawAnsiFg: String = "95"
    override val rawAnsiBg: String = "105"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.BrightMagenta)
}

public object BrightCyan : Color {
    override val ansiFg: String = "\u001b[96m"
    override val ansiBg: String = "\u001b[106m"
    override val rawAnsiFg: String = "96"
    override val rawAnsiBg: String = "106"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.BrightCyan)
}

public object BrightWhite : Color {
    override val ansiFg: String = "\u001b[97m"
    override val ansiBg: String = "\u001b[107m"
    override val rawAnsiFg: String = "97"
    override val rawAnsiBg: String = "107"
    override val dynColorsEquivalent: DynColors = DynColors.Ansi(AnsiColors.BrightWhite)
}

/**
 * A custom RGB color, determined at compile time.
 */
public data class CustomColor(
    public val r: Int,
    public val g: Int,
    public val b: Int,
) : Color {
    override val ansiFg: String = "\u001b[38;2;$r;$g;${b}m"
    override val ansiBg: String = "\u001b[48;2;$r;$g;${b}m"
    override val rawAnsiFg: String = "38;2;$r;$g;$b"
    override val rawAnsiBg: String = "48;2;$r;$g;$b"
    override val dynColorsEquivalent: DynColors = DynColors.Rgb(r, g, b)
}

/**
 * Available RGB colors for runtime dynamic color usage.
 */
public data class Rgb(
    public val r: Int,
    public val g: Int,
    public val b: Int,
) : DynColor {
    override fun fmtAnsiFg(): String = "\u001b[38;2;$r;$g;${b}m"

    override fun fmtAnsiBg(): String = "\u001b[48;2;$r;$g;${b}m"

    override fun fmtRawAnsiFg(): String = "38;2;$r;$g;$b"

    override fun fmtRawAnsiBg(): String = "48;2;$r;$g;$b"

    override fun getDyncolorsFg(): DynColors = DynColors.Rgb(r, g, b)

    override fun getDyncolorsBg(): DynColors = DynColors.Rgb(r, g, b)
}

public object Lavender : Color by CustomColor(230, 230, 250)

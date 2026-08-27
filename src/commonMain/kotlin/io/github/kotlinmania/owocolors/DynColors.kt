// port-lint: source owo-colors/src/dyn_colors.rs
package io.github.kotlinmania.owocolors

/**
 * An error for when the color cannot be parsed from a string at runtime.
 */
class ParseColorError(message: String = "Color cannot be parsed from string") : Exception(message)

/**
 * Available colors for the purpose of setting one at runtime.
 */
public sealed interface DynColors {
    fun fmtAnsiFg(): String
    fun fmtAnsiBg(): String
    fun fmtRawAnsiFg(): String
    fun fmtRawAnsiBg(): String

    /**
     * One of the [AnsiColors] standard ANSI colors.
     */
    public data class Ansi(
        public val color: AnsiColors,
    ) : DynColors {
        override fun fmtAnsiFg(): String = "\u001b[${color.fg}m"
        override fun fmtAnsiBg(): String = "\u001b[${color.bg}m"
        override fun fmtRawAnsiFg(): String = "${color.fg}"
        override fun fmtRawAnsiBg(): String = "${color.bg}"
    }

    /**
     * 24-bit Truecolor RGB.
     */
    public data class Rgb(
        public val r: Int,
        public val g: Int,
        public val b: Int,
    ) : DynColors {
        override fun fmtAnsiFg(): String = "\u001b[38;2;$r;$g;${b}m"
        override fun fmtAnsiBg(): String = "\u001b[48;2;$r;$g;${b}m"
        override fun fmtRawAnsiFg(): String = "38;2;$r;$g;$b"
        override fun fmtRawAnsiBg(): String = "48;2;$r;$g;$b"
    }

    /**
     * 8-bit 256-color Xterm palette.
     */
    public data class Xterm(
        public val code: Int,
    ) : DynColors {
        override fun fmtAnsiFg(): String = "\u001b[38;5;${code}m"
        override fun fmtAnsiBg(): String = "\u001b[48;5;${code}m"
        override fun fmtRawAnsiFg(): String = "38;5;$code"
        override fun fmtRawAnsiBg(): String = "48;5;$code"
    }

    companion object {
        fun fromStr(s: String): DynColors {
            if (s.startsWith("#")) {
                if (s.length == 7) {
                    val r = s.substring(1, 3).toIntOrNull(16) ?: throw ParseColorError()
                    val g = s.substring(3, 5).toIntOrNull(16) ?: throw ParseColorError()
                    val b = s.substring(5, 7).toIntOrNull(16) ?: throw ParseColorError()
                    return Rgb(r, g, b)
                }
                throw ParseColorError()
            }
            val ansi = when (s.lowercase()) {
                "black" -> AnsiColors.Black
                "red" -> AnsiColors.Red
                "green" -> AnsiColors.Green
                "yellow" -> AnsiColors.Yellow
                "blue" -> AnsiColors.Blue
                "magenta", "purple" -> AnsiColors.Magenta
                "cyan" -> AnsiColors.Cyan
                "white" -> AnsiColors.White
                "bright black" -> AnsiColors.BrightBlack
                "bright red" -> AnsiColors.BrightRed
                "bright green" -> AnsiColors.BrightGreen
                "bright yellow" -> AnsiColors.BrightYellow
                "bright blue" -> AnsiColors.BrightBlue
                "bright magenta" -> AnsiColors.BrightMagenta
                "bright cyan" -> AnsiColors.BrightCyan
                "bright white" -> AnsiColors.BrightWhite
                else -> throw ParseColorError("Unknown color name $s")
            }
            return Ansi(ansi)
        }
    }
}

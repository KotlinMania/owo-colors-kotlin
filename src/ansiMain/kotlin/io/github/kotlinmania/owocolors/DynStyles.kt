// port-lint: source src/dyn_styles.rs
package io.github.kotlinmania.owocolors

/**
 * A pre-computed style that can be applied to a struct using [style]. Compared
 * to the inline `OwoColorize` extension methods, [Style] is useful when the
 * same set of colors and effects is reused across many display values.
 *
 * ```kotlin
 * val mine = style().red().onWhite().strikethrough()
 * println(mine.style("red text, white background, struck through"))
 * ```
 */
public data class Style(
    public val fg: DynColors? = null,
    public val bg: DynColors? = null,
    public val bold: Boolean = false,
    public val styleFlags: StyleFlags = StyleFlags(),
) {

    /**
     * Apply this style to the given [target] and return a value that, when
     * stringified, emits the SGR-bracketed colored output.
     */
    public fun <T> style(target: T): Styled<T> = Styled(target, this)

    /** Remove the foreground color from the style. */
    public fun removeFg(): Style = copy(fg = null)

    /** Remove the background color from the style. */
    public fun removeBg(): Style = copy(bg = null)

    // ----- Foreground colors (one method per ANSI color, matching upstream `color_methods!`).

    /** Change the foreground color to black. */
    public fun black(): Style = copy(fg = DynColors.Ansi(AnsiColors.Black))

    /** Change the foreground color to red. */
    public fun red(): Style = copy(fg = DynColors.Ansi(AnsiColors.Red))

    /** Change the foreground color to green. */
    public fun green(): Style = copy(fg = DynColors.Ansi(AnsiColors.Green))

    /** Change the foreground color to yellow. */
    public fun yellow(): Style = copy(fg = DynColors.Ansi(AnsiColors.Yellow))

    /** Change the foreground color to blue. */
    public fun blue(): Style = copy(fg = DynColors.Ansi(AnsiColors.Blue))

    /** Change the foreground color to magenta. */
    public fun magenta(): Style = copy(fg = DynColors.Ansi(AnsiColors.Magenta))

    /**
     * Change the foreground color to purple. Upstream `color_methods!` declares
     * this as an alias for [magenta], using the same `Magenta` color value.
     */
    public fun purple(): Style = copy(fg = DynColors.Ansi(AnsiColors.Magenta))

    /** Change the foreground color to cyan. */
    public fun cyan(): Style = copy(fg = DynColors.Ansi(AnsiColors.Cyan))

    /** Change the foreground color to white. */
    public fun white(): Style = copy(fg = DynColors.Ansi(AnsiColors.White))

    /** Change the foreground color to the terminal default. */
    public fun defaultColor(): Style = copy(fg = DynColors.Ansi(AnsiColors.Default))

    /** Change the foreground color to bright black. */
    public fun brightBlack(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightBlack))

    /** Change the foreground color to bright red. */
    public fun brightRed(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightRed))

    /** Change the foreground color to bright green. */
    public fun brightGreen(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightGreen))

    /** Change the foreground color to bright yellow. */
    public fun brightYellow(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightYellow))

    /** Change the foreground color to bright blue. */
    public fun brightBlue(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightBlue))

    /** Change the foreground color to bright magenta. */
    public fun brightMagenta(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightMagenta))

    /**
     * Change the foreground color to bright purple. Alias of [brightMagenta]
     * per upstream `color_methods!`.
     */
    public fun brightPurple(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightMagenta))

    /** Change the foreground color to bright cyan. */
    public fun brightCyan(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightCyan))

    /** Change the foreground color to bright white. */
    public fun brightWhite(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightWhite))

    // ----- Background colors.

    /** Change the background color to black. */
    public fun onBlack(): Style = copy(bg = DynColors.Ansi(AnsiColors.Black))

    /** Change the background color to red. */
    public fun onRed(): Style = copy(bg = DynColors.Ansi(AnsiColors.Red))

    /** Change the background color to green. */
    public fun onGreen(): Style = copy(bg = DynColors.Ansi(AnsiColors.Green))

    /** Change the background color to yellow. */
    public fun onYellow(): Style = copy(bg = DynColors.Ansi(AnsiColors.Yellow))

    /** Change the background color to blue. */
    public fun onBlue(): Style = copy(bg = DynColors.Ansi(AnsiColors.Blue))

    /** Change the background color to magenta. */
    public fun onMagenta(): Style = copy(bg = DynColors.Ansi(AnsiColors.Magenta))

    /** Alias of [onMagenta]. */
    public fun onPurple(): Style = copy(bg = DynColors.Ansi(AnsiColors.Magenta))

    /** Change the background color to cyan. */
    public fun onCyan(): Style = copy(bg = DynColors.Ansi(AnsiColors.Cyan))

    /** Change the background color to white. */
    public fun onWhite(): Style = copy(bg = DynColors.Ansi(AnsiColors.White))

    /** Change the background color to the terminal default. */
    public fun onDefaultColor(): Style = copy(bg = DynColors.Ansi(AnsiColors.Default))

    /** Change the background color to bright black. */
    public fun onBrightBlack(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightBlack))

    /** Change the background color to bright red. */
    public fun onBrightRed(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightRed))

    /** Change the background color to bright green. */
    public fun onBrightGreen(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightGreen))

    /** Change the background color to bright yellow. */
    public fun onBrightYellow(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightYellow))

    /** Change the background color to bright blue. */
    public fun onBrightBlue(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightBlue))

    /** Change the background color to bright magenta. */
    public fun onBrightMagenta(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightMagenta))

    /** Alias of [onBrightMagenta]. */
    public fun onBrightPurple(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightMagenta))

    /** Change the background color to bright cyan. */
    public fun onBrightCyan(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightCyan))

    /** Change the background color to bright white. */
    public fun onBrightWhite(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightWhite))

    // ----- Effect flags.

    /** Enable bold output. */
    public fun bold(): Style = copy(bold = true)

    /** Enable dim output. */
    public fun dimmed(): Style = copy(styleFlags = styleFlags.withDimmed(true))

    /** Enable italicized output. */
    public fun italic(): Style = copy(styleFlags = styleFlags.withItalic(true))

    /** Enable underlined output. */
    public fun underline(): Style = copy(styleFlags = styleFlags.withUnderline(true))

    /** Enable blinking output. */
    public fun blink(): Style = copy(styleFlags = styleFlags.withBlink(true))

    /** Enable rapidly-blinking output. */
    public fun blinkFast(): Style = copy(styleFlags = styleFlags.withBlinkFast(true))

    /** Swap foreground and background colors. */
    public fun reversed(): Style = copy(styleFlags = styleFlags.withReversed(true))

    /** Hide output (terminal still tracks it but renders nothing). */
    public fun hidden(): Style = copy(styleFlags = styleFlags.withHidden(true))

    /** Enable struck-through output. */
    public fun strikethrough(): Style = copy(styleFlags = styleFlags.withStrikethrough(true))
}

/**
 * Bit-packed effect flags. Mirrors upstream `StyleFlags`, which packs eight
 * boolean effect flags into a single `u8` so [Style] stays `Copy` cheaply.
 */
public data class StyleFlags(public val bits: Int = 0) {

    public fun dimmed(): Boolean = (bits ushr DIMMED_SHIFT) and 1 != 0
    public fun italic(): Boolean = (bits ushr ITALIC_SHIFT) and 1 != 0
    public fun underline(): Boolean = (bits ushr UNDERLINE_SHIFT) and 1 != 0
    public fun blink(): Boolean = (bits ushr BLINK_SHIFT) and 1 != 0
    public fun blinkFast(): Boolean = (bits ushr BLINK_FAST_SHIFT) and 1 != 0
    public fun reversed(): Boolean = (bits ushr REVERSED_SHIFT) and 1 != 0
    public fun hidden(): Boolean = (bits ushr HIDDEN_SHIFT) and 1 != 0
    public fun strikethrough(): Boolean = (bits ushr STRIKETHROUGH_SHIFT) and 1 != 0

    public fun withDimmed(value: Boolean): StyleFlags = StyleFlags(set(DIMMED_SHIFT, value))
    public fun withItalic(value: Boolean): StyleFlags = StyleFlags(set(ITALIC_SHIFT, value))
    public fun withUnderline(value: Boolean): StyleFlags = StyleFlags(set(UNDERLINE_SHIFT, value))
    public fun withBlink(value: Boolean): StyleFlags = StyleFlags(set(BLINK_SHIFT, value))
    public fun withBlinkFast(value: Boolean): StyleFlags = StyleFlags(set(BLINK_FAST_SHIFT, value))
    public fun withReversed(value: Boolean): StyleFlags = StyleFlags(set(REVERSED_SHIFT, value))
    public fun withHidden(value: Boolean): StyleFlags = StyleFlags(set(HIDDEN_SHIFT, value))
    public fun withStrikethrough(value: Boolean): StyleFlags = StyleFlags(set(STRIKETHROUGH_SHIFT, value))

    /** True when no effect flag is set. */
    public fun isPlain(): Boolean = bits == 0

    private fun set(shift: Int, value: Boolean): Int =
        (bits and (1 shl shift).inv()) or ((if (value) 1 else 0) shl shift)

    public companion object {
        public const val DIMMED_SHIFT: Int = 0
        public const val ITALIC_SHIFT: Int = 1
        public const val UNDERLINE_SHIFT: Int = 2
        public const val BLINK_SHIFT: Int = 3
        public const val BLINK_FAST_SHIFT: Int = 4
        public const val REVERSED_SHIFT: Int = 5
        public const val HIDDEN_SHIFT: Int = 6
        public const val STRIKETHROUGH_SHIFT: Int = 7
    }
}

/**
 * Convenience factory matching upstream `pub fn style() -> Style`.
 *
 * ```kotlin
 * val s = style().red().bold()
 * ```
 */
public fun style(): Style = Style()

/**
 * The result of [Style.style], which formats [target] wrapped in the SGR
 * escapes that realize the style.
 *
 * Implements [CharSequence] so callers can feed it directly to
 * [StringBuilder.append] just like upstream callers feed `Styled` to
 * `write!` / `println!` via `Display`.
 */
public class Styled<T>(public val target: T, public val style: Style) : CharSequence {

    private val rendered: String by lazy(LazyThreadSafetyMode.NONE) { render() }

    override val length: Int get() = rendered.length
    override fun get(index: Int): Char = rendered[index]
    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence =
        rendered.subSequence(startIndex, endIndex)

    override fun toString(): String = rendered

    private fun render(): String {
        val codes = mutableListOf<Int>()
        if (style.bold) codes += SGR_BOLD
        if (style.styleFlags.dimmed()) codes += SGR_DIMMED
        if (style.styleFlags.italic()) codes += SGR_ITALIC
        if (style.styleFlags.underline()) codes += SGR_UNDERLINE
        if (style.styleFlags.blink()) codes += SGR_BLINK
        if (style.styleFlags.blinkFast()) codes += SGR_BLINK_FAST
        if (style.styleFlags.reversed()) codes += SGR_REVERSED
        if (style.styleFlags.hidden()) codes += SGR_HIDDEN
        if (style.styleFlags.strikethrough()) codes += SGR_STRIKETHROUGH
        when (val fg = style.fg) {
            is DynColors.Ansi -> codes += fg.color.fgCode
            DynColors.Default -> codes += AnsiColors.Default.fgCode
            null -> Unit
        }
        when (val bg = style.bg) {
            is DynColors.Ansi -> codes += bg.color.bgCode
            DynColors.Default -> codes += AnsiColors.Default.bgCode
            null -> Unit
        }
        val targetStr = target?.toString() ?: "null"
        if (codes.isEmpty()) return targetStr
        return buildString {
            append(ESC)
            append('[')
            codes.forEachIndexed { index, code ->
                if (index != 0) append(';')
                append(code)
            }
            append('m')
            append(targetStr)
            append(ESC)
            append('[')
            append(SGR_RESET)
            append('m')
        }
    }

    public companion object {
        private const val ESC: Char = ''
        private const val SGR_RESET: Int = 0
        private const val SGR_BOLD: Int = 1
        private const val SGR_DIMMED: Int = 2
        private const val SGR_ITALIC: Int = 3
        private const val SGR_UNDERLINE: Int = 4
        private const val SGR_BLINK: Int = 5
        private const val SGR_BLINK_FAST: Int = 6
        private const val SGR_REVERSED: Int = 7
        private const val SGR_HIDDEN: Int = 8
        private const val SGR_STRIKETHROUGH: Int = 9
    }
}

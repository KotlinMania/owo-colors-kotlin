// port-lint: source src/dyn_styles.rs
package io.github.kotlinmania.owocolors

/**
 * A runtime-configurable text effect for use with [Style].
 */
public enum class Effect {
    Bold,
    Dimmed,
    Italic,
    Underline,
    Blink,
    BlinkFast,
    Reversed,
    Hidden,
    Strikethrough,
}

/**
 * A wrapper type which applies a [Style] when displaying the inner type.
 */
public class Styled<T> internal constructor(
    /** The target value to be styled. */
    internal val target: T,
    /** The style to apply to target. */
    public val style: Style,
) {
    override fun toString(): String = buildString {
        style.fmtPrefix(this)
        append(target)
        style.fmtSuffix(this)
    }
}

/**
 * A pre-computed style that can be applied to a struct using [style].
 *
 * Its interface mimics that of the inline color/effect builders, but instead
 * of chaining methods on your object, you instead chain them on the [Style]
 * object before applying it.
 *
 * ```kotlin
 * val myStyle = Style().red().onWhite().strikethrough()
 *
 * println(myStyle.style("red text, white background, struck through"))
 * ```
 */
public data class Style(
    internal val fg: DynColors? = null,
    internal val bg: DynColors? = null,
    internal val bold: Boolean = false,
    internal val styleFlags: StyleFlags = StyleFlags(),
) {

    /**
     * Apply the style to a given struct to output.
     *
     * Usage in constant contexts:
     *
     * ```kotlin
     * val styledText: Styled<String> = Style().bold().italic().style("bold and italic text")
     *
     * println(styledText)
     * ```
     */
    public fun <T> style(target: T): Styled<T> = Styled(target, this)

    /**
     * Removes the foreground color from the style. Note that this does not
     * apply the default color, but rather represents not changing the current
     * terminal color.
     *
     * If you wish to actively change the terminal color back to the default,
     * see [defaultColor].
     */
    public fun removeFg(): Style = copy(fg = null)

    /**
     * Removes the background color from the style. Note that this does not
     * apply the default color, but rather represents not changing the current
     * terminal color.
     *
     * If you wish to actively change the terminal color back to the default,
     * see [onDefaultColor].
     */
    public fun removeBg(): Style = copy(bg = null)

    /** Change the foreground color to black. */ public fun black(): Style = copy(fg = DynColors.Ansi(AnsiColors.Black))
    /** Change the background color to black. */ public fun onBlack(): Style = copy(bg = DynColors.Ansi(AnsiColors.Black))
    /** Change the foreground color to red. */ public fun red(): Style = copy(fg = DynColors.Ansi(AnsiColors.Red))
    /** Change the background color to red. */ public fun onRed(): Style = copy(bg = DynColors.Ansi(AnsiColors.Red))
    /** Change the foreground color to green. */ public fun green(): Style = copy(fg = DynColors.Ansi(AnsiColors.Green))
    /** Change the background color to green. */ public fun onGreen(): Style = copy(bg = DynColors.Ansi(AnsiColors.Green))
    /** Change the foreground color to yellow. */ public fun yellow(): Style = copy(fg = DynColors.Ansi(AnsiColors.Yellow))
    /** Change the background color to yellow. */ public fun onYellow(): Style = copy(bg = DynColors.Ansi(AnsiColors.Yellow))
    /** Change the foreground color to blue. */ public fun blue(): Style = copy(fg = DynColors.Ansi(AnsiColors.Blue))
    /** Change the background color to blue. */ public fun onBlue(): Style = copy(bg = DynColors.Ansi(AnsiColors.Blue))
    /** Change the foreground color to magenta. */ public fun magenta(): Style = copy(fg = DynColors.Ansi(AnsiColors.Magenta))
    /** Change the background color to magenta. */ public fun onMagenta(): Style = copy(bg = DynColors.Ansi(AnsiColors.Magenta))
    /** Change the foreground color to purple. */ public fun purple(): Style = copy(fg = DynColors.Ansi(AnsiColors.Magenta))
    /** Change the background color to purple. */ public fun onPurple(): Style = copy(bg = DynColors.Ansi(AnsiColors.Magenta))
    /** Change the foreground color to cyan. */ public fun cyan(): Style = copy(fg = DynColors.Ansi(AnsiColors.Cyan))
    /** Change the background color to cyan. */ public fun onCyan(): Style = copy(bg = DynColors.Ansi(AnsiColors.Cyan))
    /** Change the foreground color to white. */ public fun white(): Style = copy(fg = DynColors.Ansi(AnsiColors.White))
    /** Change the background color to white. */ public fun onWhite(): Style = copy(bg = DynColors.Ansi(AnsiColors.White))

    /** Change the foreground color to the terminal default. */
    public fun defaultColor(): Style = copy(fg = DynColors.Ansi(AnsiColors.Default))
    /** Change the background color to the terminal default. */
    public fun onDefaultColor(): Style = copy(bg = DynColors.Ansi(AnsiColors.Default))

    /** Change the foreground color to bright black. */ public fun brightBlack(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightBlack))
    /** Change the background color to bright black. */ public fun onBrightBlack(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightBlack))
    /** Change the foreground color to bright red. */ public fun brightRed(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightRed))
    /** Change the background color to bright red. */ public fun onBrightRed(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightRed))
    /** Change the foreground color to bright green. */ public fun brightGreen(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightGreen))
    /** Change the background color to bright green. */ public fun onBrightGreen(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightGreen))
    /** Change the foreground color to bright yellow. */ public fun brightYellow(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightYellow))
    /** Change the background color to bright yellow. */ public fun onBrightYellow(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightYellow))
    /** Change the foreground color to bright blue. */ public fun brightBlue(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightBlue))
    /** Change the background color to bright blue. */ public fun onBrightBlue(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightBlue))
    /** Change the foreground color to bright magenta. */ public fun brightMagenta(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightMagenta))
    /** Change the background color to bright magenta. */ public fun onBrightMagenta(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightMagenta))
    /** Change the foreground color to bright purple. */ public fun brightPurple(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightMagenta))
    /** Change the background color to bright purple. */ public fun onBrightPurple(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightMagenta))
    /** Change the foreground color to bright cyan. */ public fun brightCyan(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightCyan))
    /** Change the background color to bright cyan. */ public fun onBrightCyan(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightCyan))
    /** Change the foreground color to bright white. */ public fun brightWhite(): Style = copy(fg = DynColors.Ansi(AnsiColors.BrightWhite))
    /** Change the background color to bright white. */ public fun onBrightWhite(): Style = copy(bg = DynColors.Ansi(AnsiColors.BrightWhite))

    /** Make the text bold. */ public fun bold(): Style = copy(bold = true)
    /** Make the text dim. */ public fun dimmed(): Style = copy(styleFlags = styleFlags.setDimmed(true))
    /** Make the text italicized. */ public fun italic(): Style = copy(styleFlags = styleFlags.setItalic(true))
    /** Make the text underlined. */ public fun underline(): Style = copy(styleFlags = styleFlags.setUnderline(true))
    /** Make the text blink. */ public fun blink(): Style = copy(styleFlags = styleFlags.setBlink(true))
    /** Make the text blink (but fast!). */ public fun blinkFast(): Style = copy(styleFlags = styleFlags.setBlinkFast(true))
    /** Swap the foreground and background colors. */ public fun reversed(): Style = copy(styleFlags = styleFlags.setReversed(true))
    /** Hide the text. */ public fun hidden(): Style = copy(styleFlags = styleFlags.setHidden(true))
    /** Cross out the text. */ public fun strikethrough(): Style = copy(styleFlags = styleFlags.setStrikethrough(true))

    private fun setEffect(effect: Effect, to: Boolean): Style = when (effect) {
        Effect.Bold -> copy(bold = to)
        Effect.Dimmed -> copy(styleFlags = styleFlags.setDimmed(to))
        Effect.Italic -> copy(styleFlags = styleFlags.setItalic(to))
        Effect.Underline -> copy(styleFlags = styleFlags.setUnderline(to))
        Effect.Blink -> copy(styleFlags = styleFlags.setBlink(to))
        Effect.BlinkFast -> copy(styleFlags = styleFlags.setBlinkFast(to))
        Effect.Reversed -> copy(styleFlags = styleFlags.setReversed(to))
        Effect.Hidden -> copy(styleFlags = styleFlags.setHidden(to))
        Effect.Strikethrough -> copy(styleFlags = styleFlags.setStrikethrough(to))
    }

    private fun setEffects(effects: Array<out Effect>, to: Boolean): Style {
        var result = this
        for (e in effects) {
            result = result.setEffect(e, to)
        }
        return result
    }

    /** Apply a given effect from the style. */
    public fun effect(effect: Effect): Style = setEffect(effect, true)

    /** Remove a given effect from the style. */
    public fun removeEffect(effect: Effect): Style = setEffect(effect, false)

    /** Apply a given set of effects to the style. */
    public fun effects(vararg effects: Effect): Style = setEffects(effects, true)

    /** Remove a given set of effects from the style. */
    public fun removeEffects(vararg effects: Effect): Style = setEffects(effects, false)

    /** Disables all the given effects from the style. */
    public fun removeAllEffects(): Style = copy(bold = false, styleFlags = StyleFlags())

    /**
     * Set the foreground color at runtime. Only use if you do not know which
     * color will be used at compile-time. If the color is constant, use a
     * color-specific method such as [green].
     *
     * ```kotlin
     * println(Style().color(AnsiColors.Green).style("green"))
     * ```
     */
    public fun color(color: AnsiColors): Style = copy(fg = DynColors.Ansi(color))

    /**
     * Set the background color at runtime. Only use if you do not know what
     * color to use at compile-time. If the color is constant, use a
     * color-specific method such as [onBrightYellow].
     *
     * ```kotlin
     * println(Style().onColor(AnsiColors.BrightYellow).style("yellow background"))
     * ```
     */
    public fun onColor(color: AnsiColors): Style = copy(bg = DynColors.Ansi(color))

    /** Checks if the style is plain (i.e. no colors or effects set). */
    public fun isPlain(): Boolean = fg == null && bg == null && !bold && styleFlags.isPlain()

    /**
     * Returns a formatter that emits this style's ANSI prefix when displayed,
     * without the suffix. Useful for formatting the prefix separately.
     */
    public fun prefixFormatter(): StylePrefixFormatter = StylePrefixFormatter(this)

    /**
     * Returns a formatter that emits this style's ANSI suffix when displayed,
     * without the prefix. Useful for formatting the suffix separately.
     */
    public fun suffixFormatter(): StyleSuffixFormatter = StyleSuffixFormatter(this)

    /** Applies the ANSI-prefix for this style to the given formatter. */
    internal fun fmtPrefix(out: StringBuilder) {
        val formatLessImportantEffects = styleFlags != StyleFlags()
        val formatEffect = bold || formatLessImportantEffects
        val formatAny = !isPlain()

        var semicolon = false

        if (formatAny) {
            out.append("\u001B[")
        }

        val fgColor = fg
        if (fgColor != null) {
            fgColor.writeRawAnsiFg(out)
            semicolon = true
        }

        val bgColor = bg
        if (bgColor != null) {
            if (fg != null) {
                out.append(';')
            }
            bgColor.writeRawAnsiBg(out)
            semicolon = true
        }

        if (formatEffect) {
            if (bold) {
                if (semicolon) out.append(';')
                out.append('1')
                semicolon = true
            }

            if (formatLessImportantEffects) {
                if (styleFlags.dimmed()) { if (semicolon) out.append(';'); out.append('2'); semicolon = true }
                if (styleFlags.italic()) { if (semicolon) out.append(';'); out.append('3'); semicolon = true }
                if (styleFlags.underline()) { if (semicolon) out.append(';'); out.append('4'); semicolon = true }
                if (styleFlags.blink()) { if (semicolon) out.append(';'); out.append('5'); semicolon = true }
                if (styleFlags.blinkFast()) { if (semicolon) out.append(';'); out.append('6'); semicolon = true }
                if (styleFlags.reversed()) { if (semicolon) out.append(';'); out.append('7'); semicolon = true }
                if (styleFlags.hidden()) { if (semicolon) out.append(';'); out.append('8'); semicolon = true }
                if (styleFlags.strikethrough()) { if (semicolon) out.append(';'); out.append('9'); semicolon = true }
            }
        }

        if (formatAny) {
            out.append('m')
        }
    }

    /** Applies the ANSI-suffix for this style to the given formatter. */
    internal fun fmtSuffix(out: StringBuilder) {
        if (!isPlain()) {
            out.append("\u001B[0m")
        }
    }
}

private fun DynColors.writeRawAnsiFg(out: StringBuilder) {
    when (this) {
        is DynColors.Ansi -> out.append(color.fg)
    }
}

private fun DynColors.writeRawAnsiBg(out: StringBuilder) {
    when (this) {
        is DynColors.Ansi -> out.append(color.bg)
    }
}

/**
 * Formatter for the prefix of a [Style].
 *
 * This is used to get the ANSI escape codes for the style without the
 * suffix, which is useful for formatting the prefix separately.
 */
@ConsistentCopyVisibility
public data class StylePrefixFormatter internal constructor(internal val style: Style) {
    override fun toString(): String = buildString { style.fmtPrefix(this) }
}

/**
 * Formatter for the suffix of a [Style].
 *
 * This is used to get the ANSI escape codes for the style without the
 * prefix, which is useful for formatting the suffix separately.
 */
@ConsistentCopyVisibility
public data class StyleSuffixFormatter internal constructor(internal val style: Style) {
    override fun toString(): String = buildString { style.fmtSuffix(this) }
}

/** Helper to create [Style]s more ergonomically. */
public fun style(): Style = Style()

/**
 * Bit-packed effect flags storing the eight non-bold text effects.
 */
public data class StyleFlags(internal val bits: Int = 0) {

    public fun dimmed(): Boolean = (bits ushr DIMMED_SHIFT) and 1 != 0
    public fun italic(): Boolean = (bits ushr ITALIC_SHIFT) and 1 != 0
    public fun underline(): Boolean = (bits ushr UNDERLINE_SHIFT) and 1 != 0
    public fun blink(): Boolean = (bits ushr BLINK_SHIFT) and 1 != 0
    public fun blinkFast(): Boolean = (bits ushr BLINK_FAST_SHIFT) and 1 != 0
    public fun reversed(): Boolean = (bits ushr REVERSED_SHIFT) and 1 != 0
    public fun hidden(): Boolean = (bits ushr HIDDEN_SHIFT) and 1 != 0
    public fun strikethrough(): Boolean = (bits ushr STRIKETHROUGH_SHIFT) and 1 != 0

    public fun setDimmed(value: Boolean): StyleFlags = StyleFlags(set(DIMMED_SHIFT, value))
    public fun setItalic(value: Boolean): StyleFlags = StyleFlags(set(ITALIC_SHIFT, value))
    public fun setUnderline(value: Boolean): StyleFlags = StyleFlags(set(UNDERLINE_SHIFT, value))
    public fun setBlink(value: Boolean): StyleFlags = StyleFlags(set(BLINK_SHIFT, value))
    public fun setBlinkFast(value: Boolean): StyleFlags = StyleFlags(set(BLINK_FAST_SHIFT, value))
    public fun setReversed(value: Boolean): StyleFlags = StyleFlags(set(REVERSED_SHIFT, value))
    public fun setHidden(value: Boolean): StyleFlags = StyleFlags(set(HIDDEN_SHIFT, value))
    public fun setStrikethrough(value: Boolean): StyleFlags = StyleFlags(set(STRIKETHROUGH_SHIFT, value))

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

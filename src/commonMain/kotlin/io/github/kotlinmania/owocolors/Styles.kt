// port-lint: source styles.rs
package io.github.kotlinmania.owocolors

/**
 * Transparent wrapper around a type which implements formatting, with the addition of boldening it.
 */
public class BoldDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().bold().style(target)

    override fun toString(): String = "\u001b[1m$target\u001b[0m"
}

/**
 * Transparent wrapper around a type which implements formatting, with the addition of dimming it.
 */
public class DimDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().dimmed().style(target)

    override fun toString(): String = "\u001b[2m$target\u001b[0m"
}

/**
 * Transparent wrapper around a type which implements formatting, with the addition of italicizing it.
 */
public class ItalicDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().italic().style(target)

    override fun toString(): String = "\u001b[3m$target\u001b[0m"
}

/**
 * Transparent wrapper around a type which implements formatting, with the addition of underlining it.
 */
public class UnderlineDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().underline().style(target)

    override fun toString(): String = "\u001b[4m$target\u001b[0m"
}

/**
 * Transparent wrapper around a type which implements formatting, with the addition of blinking it.
 */
public class BlinkDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().blink().style(target)

    override fun toString(): String = "\u001b[5m$target\u001b[0m"
}

/**
 * Transparent wrapper around a type which implements formatting, with the addition of fast blinking it.
 */
public class BlinkFastDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().blinkFast().style(target)

    override fun toString(): String = "\u001b[6m$target\u001b[0m"
}

/**
 * Transparent wrapper around a type which implements formatting, with the addition of reversing colors.
 */
public class ReversedDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().reversed().style(target)

    override fun toString(): String = "\u001b[7m$target\u001b[0m"
}

/**
 * Transparent wrapper around a type which implements formatting, with the addition of hiding it.
 */
public class HiddenDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().hidden().style(target)

    override fun toString(): String = "\u001b[8m$target\u001b[0m"
}

/**
 * Transparent wrapper around a type which implements formatting, with the addition of crossing out it.
 */
public class StrikeThroughDisplay<T>(
    public val target: T,
) {
    public fun intoStyled(): Styled<T> = Style().strikethrough().style(target)

    override fun toString(): String = "\u001b[9m$target\u001b[0m"
}

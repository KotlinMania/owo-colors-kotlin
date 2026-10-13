// port-lint: source styled_list.rs
package io.github.kotlinmania.owocolors

/**
 * How the transition between two styles should be printed.
 */
public sealed class Transition {
    public object Noop : Transition() {
        override fun toString(): String = ""
    }

    public data class FullReset(
        public val style: Style,
    ) : Transition() {
        override fun toString(): String =
            buildString {
                append("\u001b[0m")
                style.fmtPrefix(this)
            }
    }

    public data class StyleTransition(
        public val style: Style,
    ) : Transition() {
        override fun toString(): String =
            buildString {
                style.fmtPrefix(this)
            }
    }
}

/**
 * Returns a [Transition] indicating how to transition from [from] style to this style.
 */
public fun Style.transitionFrom(from: Style): Transition {
    if (this == from) {
        return Transition.Noop
    }

    if ((from.fg != null && this.fg == null) ||
        (from.bg != null && this.bg == null) ||
        (from.bold && !this.bold) ||
        ((this.styleFlags.bits.inv() and from.styleFlags.bits) != 0)
    ) {
        return Transition.FullReset(this)
    }

    val newFg =
        when {
            this.fg != null && from.fg != null && this.fg != from.fg -> this.fg
            this.fg != null && from.fg == null -> this.fg
            else -> null
        }

    val newBg =
        when {
            this.bg != null && from.bg != null && this.bg != from.bg -> this.bg
            this.bg != null && from.bg == null -> this.bg
            else -> null
        }

    val newStyle =
        Style(
            fg = newFg,
            bg = newBg,
            bold = from.bold xor this.bold,
            styleFlags = StyleFlags(this.styleFlags.bits xor from.styleFlags.bits),
        )

    return Transition.StyleTransition(newStyle)
}

/**
 * A collection of [Styled] items displayed in such a way as to minimize the amount of characters written.
 */
public class StyledList(
    public val items: List<Styled<*>>,
) {
    override fun toString(): String {
        if (items.isEmpty()) return ""
        val first = items.first()
        val sb = StringBuilder()
        first.style.fmtPrefix(sb)
        sb.append(first.inner())

        for (i in 1 until items.size) {
            val prev = items[i - 1]
            val current = items[i]
            sb.append(current.style.transitionFrom(prev.style))
            sb.append(current.inner())
        }

        items.last().style.fmtSuffix(sb)
        return sb.toString()
    }

    public companion object {
        public fun from(items: List<Styled<*>>): StyledList = StyledList(items)

        public fun from(vararg items: Styled<*>): StyledList = StyledList(items.toList())
    }
}

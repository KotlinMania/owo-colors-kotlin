// port-lint: source supports_colors.rs
package io.github.kotlinmania.owocolors

/**
 * A possible stream source.
 */
public enum class Stream {
    /** Standard output. */
    Stdout,

    /** Standard error. */
    Stderr,
}

/**
 * A display wrapper which applies a transformation based on if the given stream supports
 * colored terminal output.
 */
public class SupportsColorsDisplay<T, Out>(
    public val target: T,
    private val apply: (T) -> Out,
    private val stream: Stream,
) {
    override fun toString(): String {
        val (forceEnabled, forceDisabled) = OVERRIDE.isForceEnabledOrDisabled()
        return if (forceEnabled || (!forceDisabled)) {
            apply(target).toString()
        } else {
            target.toString()
        }
    }
}

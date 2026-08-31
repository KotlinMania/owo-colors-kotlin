// port-lint: source owo-colors/src/overrides.rs
@file:OptIn(kotlin.concurrent.atomics.ExperimentalAtomicApi::class)

package io.github.kotlinmania.owocolors

import kotlin.concurrent.atomics.AtomicInt

/**
 * Set an override value for whether or not colors are supported using
 * [setOverride] while executing the closure provided.
 *
 * Once the function has executed the value will be reset to the previous set
 * (or unset) override.
 *
 * This is especially useful in use-cases where one would like to temporarily
 * override the supported color set, without impacting previous configurations.
 *
 * ```kotlin
 * setOverride(false)
 * assertEquals(
 *     "example",
 *     "example".ifSupportsColor(Stream.Stdout) { it.bg<Black>() }.toString(),
 * )
 *
 * withOverride(true) {
 *     assertEquals(
 *         "[40mexample[49m",
 *         "example".ifSupportsColor(Stream.Stdout) { it.bg<Black>() }.toString(),
 *     )
 * }
 *
 * assertEquals(
 *     "example",
 *     "example".ifSupportsColor(Stream.Stdout) { it.bg<Black>() }.toString(),
 * )
 * unsetOverride() // make sure that other doc tests are not impacted
 * ```
 */
public fun <T> withOverride(enabled: Boolean, f: () -> T): T {
    val previous = OVERRIDE.inner()
    OVERRIDE.setForce(enabled)

    // Use a scope guard to ensure that if `f` panics, the override is still
    // caught.
    try {
        return f()
    } finally {
        OVERRIDE.setUnchecked(previous)
    }
}

/**
 * Set an override value for whether or not colors are supported.
 *
 * If `true` is passed, [ifSupportsColor] will always act as if colors are
 * supported.
 *
 * If `false` is passed, [ifSupportsColor] will always act as if colors are
 * **not** supported.
 *
 * This behavior can be disabled using [unsetOverride], allowing `owo-colors`
 * to return to inferring if colors are supported.
 */
public fun setOverride(enabled: Boolean) {
    OVERRIDE.setForce(enabled)
}

/**
 * Remove any override value for whether or not colors are supported. This
 * means [ifSupportsColor] will resume checking if the given terminal output
 * ([Stream]) supports colors.
 *
 * This override can be set using [setOverride].
 */
public fun unsetOverride() {
    OVERRIDE.unset()
}

internal val OVERRIDE: Override = Override.none()

internal class Override(
    initial: Int,
) {
    private val bits: AtomicInt = AtomicInt(initial)

    internal fun inner(): Int = bits.load()

    internal fun isForceEnabledOrDisabled(): Pair<Boolean, Boolean> {
        val inner = inner()
        return Pair(inner == FORCE_ENABLE, inner == FORCE_DISABLE)
    }

    internal fun setForce(enable: Boolean) {
        setUnchecked(FORCE_MASK or (if (enable) 1 else 0))
    }

    internal fun unset() {
        setUnchecked(0)
    }

    internal fun setUnchecked(value: Int) {
        bits.store(value)
    }

    internal companion object {
        internal fun none(): Override = Override(NO_FORCE)
    }
}

internal const val FORCE_MASK: Int = 0b10
internal const val FORCE_ENABLE: Int = 0b11
internal const val FORCE_DISABLE: Int = 0b10
internal const val NO_FORCE: Int = 0b00

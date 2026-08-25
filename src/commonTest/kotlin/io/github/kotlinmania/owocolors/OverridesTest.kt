// port-lint: tests overrides.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class OverridesTest {
    @Test
    fun withOverrideOnPanic() {
        setOverride(false)

        assertFailsWith<IllegalStateException>("test should panic") {
            withOverride(true) {
                assertEquals(OVERRIDE.inner(), FORCE_ENABLE)
                error("test")
            }
        }

        assertEquals(
            OVERRIDE.inner(),
            FORCE_DISABLE,
            "override should have been reset",
        )
    }
}

// port-lint: tests styled_list.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals

class StyledListTest {
    @Test
    fun testStyledList() {
        val list =
            listOf(
                Style().red().style("red"),
                Style().green().italic().style("green italic"),
                Style().red().bold().style("red bold"),
            )

        val styledList = StyledList.from(list)

        assertEquals(
            "\u001b[31mred\u001b[32;3mgreen italic\u001b[0m\u001b[31;1mred bold\u001b[0m",
            styledList.toString(),
        )
    }

    @Test
    fun testStyledFinalPlain() {
        val list =
            listOf(
                Style().red().style("red"),
                Style().green().italic().style("green italic"),
                Style().style("plain"),
            )

        val styledList = StyledList.from(list)

        assertEquals(
            "\u001b[31mred\u001b[32;3mgreen italic\u001b[0mplain",
            styledList.toString(),
        )
    }

    @Test
    fun testTransitionFromNoop() {
        val styleCurrent = Style().italic().red()
        val stylePrev = Style().italic().red()

        assertEquals(Transition.Noop, styleCurrent.transitionFrom(stylePrev))
    }

    @Test
    fun testTransitionFromFullReset() {
        run {
            val styleCurrent = Style().italic().red()
            val stylePrev = Style().italic().dimmed().red()

            assertEquals(
                Transition.FullReset(styleCurrent),
                styleCurrent.transitionFrom(stylePrev),
            )
        }

        run {
            val styleCurrent = Style()
            val stylePrev = Style().red()
            assertEquals(
                Transition.FullReset(styleCurrent),
                styleCurrent.transitionFrom(stylePrev),
            )
        }

        run {
            val styleCurrent = Style()
            val stylePrev = Style().bold()
            assertEquals(
                Transition.FullReset(styleCurrent),
                styleCurrent.transitionFrom(stylePrev),
            )
        }
    }

    @Test
    fun testTransitionFromStyle() {
        run {
            val styleCurrent = Style().italic().dimmed().red()
            val stylePrev = Style().italic().red()

            assertEquals(
                Transition.StyleTransition(Style().dimmed()),
                styleCurrent.transitionFrom(stylePrev),
            )
        }

        run {
            val styleCurrent = Style().red().onGreen()
            val stylePrev = Style().red().onBrightCyan()
            assertEquals(
                Transition.StyleTransition(Style().onGreen()),
                styleCurrent.transitionFrom(stylePrev),
            )
        }

        run {
            val styleCurrent = Style().bold().blue()
            val stylePrev = Style().bold()
            assertEquals(
                Transition.StyleTransition(Style().blue()),
                styleCurrent.transitionFrom(stylePrev),
            )
        }
    }
}

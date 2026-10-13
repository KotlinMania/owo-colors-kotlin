// port-lint: tests combo.rs
package io.github.kotlinmania.owocolors

import kotlin.test.Test
import kotlin.test.assertEquals

class ComboTest {
    @Test
    fun fgBgCombo() {
        val test = "test".red().onBlue()
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun bgFgCombo() {
        val test = "test".onBlue().red()
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun fgBgDynCombo() {
        val test = "test".color(AnsiColors.Red).onColor(AnsiColors.Blue)
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun bgFgDynCombo() {
        val test = "test".onColor(AnsiColors.Blue).color(AnsiColors.Red)
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun fgOverride() {
        val test = "test".green().yellow().red().onBlue()
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun bgOverride() {
        val test = "test".onGreen().onYellow().onBlue().red()
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun multipleOverride() {
        val test =
            "test"
                .onGreen()
                .onYellow()
                .onRed()
                .green()
                .yellow()
                .red()
                .onColor(AnsiColors.Blue)
                .color(AnsiColors.Red)
                .onColor(AnsiColors.Blue)
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun genericMultipleOverride() {
        val test =
            "test"
                .bg(Green)
                .bg(Yellow)
                .bg(Red)
                .fg(Green)
                .fg(Yellow)
                .bg(Blue)
                .fg(Red)
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun fgBgComboGeneric() {
        val test = "test".fg(Red).bg(Blue)
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }

    @Test
    fun bgFgComboGeneric() {
        val test = "test".bg(Blue).fg(Red)
        assertEquals("\u001b[31;44mtest\u001b[0m", test.toString())
    }
}

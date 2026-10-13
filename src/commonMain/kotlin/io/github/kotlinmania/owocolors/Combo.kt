// port-lint: source combo.rs
package io.github.kotlinmania.owocolors

/**
 * A wrapper type which applies both a foreground and background color.
 */
public class ComboColorDisplay<T, Fg : Color, Bg : Color>(
    public val target: T,
    public val fg: Fg,
    public val bg: Bg,
) {
    public fun <NewFg : Color> fg(newFg: NewFg): ComboColorDisplay<T, NewFg, Bg> =
        ComboColorDisplay(target, newFg, bg)

    public fun <NewBg : Color> bg(newBg: NewBg): ComboColorDisplay<T, Fg, NewBg> =
        ComboColorDisplay(target, fg, newBg)

    public fun black(): ComboColorDisplay<T, Black, Bg> = fg(Black)

    public fun red(): ComboColorDisplay<T, Red, Bg> = fg(Red)

    public fun green(): ComboColorDisplay<T, Green, Bg> = fg(Green)

    public fun yellow(): ComboColorDisplay<T, Yellow, Bg> = fg(Yellow)

    public fun blue(): ComboColorDisplay<T, Blue, Bg> = fg(Blue)

    public fun magenta(): ComboColorDisplay<T, Magenta, Bg> = fg(Magenta)

    public fun purple(): ComboColorDisplay<T, Magenta, Bg> = fg(Magenta)

    public fun cyan(): ComboColorDisplay<T, Cyan, Bg> = fg(Cyan)

    public fun white(): ComboColorDisplay<T, White, Bg> = fg(White)

    public fun defaultColor(): ComboColorDisplay<T, Default, Bg> = fg(Default)

    public fun brightBlack(): ComboColorDisplay<T, BrightBlack, Bg> = fg(BrightBlack)

    public fun brightRed(): ComboColorDisplay<T, BrightRed, Bg> = fg(BrightRed)

    public fun brightGreen(): ComboColorDisplay<T, BrightGreen, Bg> = fg(BrightGreen)

    public fun brightYellow(): ComboColorDisplay<T, BrightYellow, Bg> = fg(BrightYellow)

    public fun brightBlue(): ComboColorDisplay<T, BrightBlue, Bg> = fg(BrightBlue)

    public fun brightMagenta(): ComboColorDisplay<T, BrightMagenta, Bg> = fg(BrightMagenta)

    public fun brightPurple(): ComboColorDisplay<T, BrightMagenta, Bg> = fg(BrightMagenta)

    public fun brightCyan(): ComboColorDisplay<T, BrightCyan, Bg> = fg(BrightCyan)

    public fun brightWhite(): ComboColorDisplay<T, BrightWhite, Bg> = fg(BrightWhite)

    public fun onBlack(): ComboColorDisplay<T, Fg, Black> = bg(Black)

    public fun onRed(): ComboColorDisplay<T, Fg, Red> = bg(Red)

    public fun onGreen(): ComboColorDisplay<T, Fg, Green> = bg(Green)

    public fun onYellow(): ComboColorDisplay<T, Fg, Yellow> = bg(Yellow)

    public fun onBlue(): ComboColorDisplay<T, Fg, Blue> = bg(Blue)

    public fun onMagenta(): ComboColorDisplay<T, Fg, Magenta> = bg(Magenta)

    public fun onPurple(): ComboColorDisplay<T, Fg, Magenta> = bg(Magenta)

    public fun onCyan(): ComboColorDisplay<T, Fg, Cyan> = bg(Cyan)

    public fun onWhite(): ComboColorDisplay<T, Fg, White> = bg(White)

    public fun onDefaultColor(): ComboColorDisplay<T, Fg, Default> = bg(Default)

    public fun onBrightBlack(): ComboColorDisplay<T, Fg, BrightBlack> = bg(BrightBlack)

    public fun onBrightRed(): ComboColorDisplay<T, Fg, BrightRed> = bg(BrightRed)

    public fun onBrightGreen(): ComboColorDisplay<T, Fg, BrightGreen> = bg(BrightGreen)

    public fun onBrightYellow(): ComboColorDisplay<T, Fg, BrightYellow> = bg(BrightYellow)

    public fun onBrightBlue(): ComboColorDisplay<T, Fg, BrightBlue> = bg(BrightBlue)

    public fun onBrightMagenta(): ComboColorDisplay<T, Fg, BrightMagenta> = bg(BrightMagenta)

    public fun onBrightPurple(): ComboColorDisplay<T, Fg, BrightMagenta> = bg(BrightMagenta)

    public fun onBrightCyan(): ComboColorDisplay<T, Fg, BrightCyan> = bg(BrightCyan)

    public fun onBrightWhite(): ComboColorDisplay<T, Fg, BrightWhite> = bg(BrightWhite)

    public fun <NewFg : DynColor> color(color: NewFg): ComboDynColorDisplay<T, NewFg, Bg> =
        ComboDynColorDisplay(target, color, bg)

    public fun <NewBg : DynColor> onColor(color: NewBg): ComboDynColorDisplay<T, Fg, NewBg> =
        ComboDynColorDisplay(target, fg, color)

    override fun toString(): String = "\u001b[${fg.rawAnsiFg};${bg.rawAnsiBg}m$target\u001b[0m"
}

/**
 * Wrapper around a type which applies both a dynamic foreground and background color.
 */
public class ComboDynColorDisplay<T, Fg : DynColor, Bg : DynColor>(
    public val target: T,
    public val fg: Fg,
    public val bg: Bg,
) {
    public fun <NewFg : DynColor> color(color: NewFg): ComboDynColorDisplay<T, NewFg, Bg> =
        ComboDynColorDisplay(target, color, bg)

    public fun <NewBg : DynColor> onColor(color: NewBg): ComboDynColorDisplay<T, Fg, NewBg> =
        ComboDynColorDisplay(target, fg, color)

    public fun black(): ComboDynColorDisplay<T, Black, Bg> = color(Black)

    public fun red(): ComboDynColorDisplay<T, Red, Bg> = color(Red)

    public fun green(): ComboDynColorDisplay<T, Green, Bg> = color(Green)

    public fun yellow(): ComboDynColorDisplay<T, Yellow, Bg> = color(Yellow)

    public fun blue(): ComboDynColorDisplay<T, Blue, Bg> = color(Blue)

    public fun magenta(): ComboDynColorDisplay<T, Magenta, Bg> = color(Magenta)

    public fun purple(): ComboDynColorDisplay<T, Magenta, Bg> = color(Magenta)

    public fun cyan(): ComboDynColorDisplay<T, Cyan, Bg> = color(Cyan)

    public fun white(): ComboDynColorDisplay<T, White, Bg> = color(White)

    public fun defaultColor(): ComboDynColorDisplay<T, Default, Bg> = color(Default)

    public fun onBlack(): ComboDynColorDisplay<T, Fg, Black> = onColor(Black)

    public fun onRed(): ComboDynColorDisplay<T, Fg, Red> = onColor(Red)

    public fun onGreen(): ComboDynColorDisplay<T, Fg, Green> = onColor(Green)

    public fun onYellow(): ComboDynColorDisplay<T, Fg, Yellow> = onColor(Yellow)

    public fun onBlue(): ComboDynColorDisplay<T, Fg, Blue> = onColor(Blue)

    public fun onMagenta(): ComboDynColorDisplay<T, Fg, Magenta> = onColor(Magenta)

    public fun onPurple(): ComboDynColorDisplay<T, Fg, Magenta> = onColor(Magenta)

    public fun onCyan(): ComboDynColorDisplay<T, Fg, Cyan> = onColor(Cyan)

    public fun onWhite(): ComboDynColorDisplay<T, Fg, White> = onColor(White)

    public fun onDefaultColor(): ComboDynColorDisplay<T, Fg, Default> = onColor(Default)

    override fun toString(): String =
        "\u001b[${fg.fmtRawAnsiFg()};${bg.fmtRawAnsiBg()}m$target\u001b[0m"
}

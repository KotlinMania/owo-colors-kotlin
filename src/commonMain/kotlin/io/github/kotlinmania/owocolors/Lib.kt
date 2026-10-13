// port-lint: source lib.rs
package io.github.kotlinmania.owocolors

/**
 * Transparent wrapper around a type with the addition of changing the foreground color.
 */
public class FgColorDisplay<T, C : Color>(
    public val target: T,
    public val color: C,
) {
    public fun <NewC : Color> fg(newColor: NewC): FgColorDisplay<T, NewC> =
        FgColorDisplay(target, newColor)

    public fun <BgC : Color> bg(bgColor: BgC): ComboColorDisplay<T, C, BgC> =
        ComboColorDisplay(target, color, bgColor)

    public fun black(): FgColorDisplay<T, Black> = fg(Black)

    public fun red(): FgColorDisplay<T, Red> = fg(Red)

    public fun green(): FgColorDisplay<T, Green> = fg(Green)

    public fun yellow(): FgColorDisplay<T, Yellow> = fg(Yellow)

    public fun blue(): FgColorDisplay<T, Blue> = fg(Blue)

    public fun magenta(): FgColorDisplay<T, Magenta> = fg(Magenta)

    public fun purple(): FgColorDisplay<T, Magenta> = fg(Magenta)

    public fun cyan(): FgColorDisplay<T, Cyan> = fg(Cyan)

    public fun white(): FgColorDisplay<T, White> = fg(White)

    public fun defaultColor(): FgColorDisplay<T, Default> = fg(Default)

    public fun brightBlack(): FgColorDisplay<T, BrightBlack> = fg(BrightBlack)

    public fun brightRed(): FgColorDisplay<T, BrightRed> = fg(BrightRed)

    public fun brightGreen(): FgColorDisplay<T, BrightGreen> = fg(BrightGreen)

    public fun brightYellow(): FgColorDisplay<T, BrightYellow> = fg(BrightYellow)

    public fun brightBlue(): FgColorDisplay<T, BrightBlue> = fg(BrightBlue)

    public fun brightMagenta(): FgColorDisplay<T, BrightMagenta> = fg(BrightMagenta)

    public fun brightPurple(): FgColorDisplay<T, BrightMagenta> = fg(BrightMagenta)

    public fun brightCyan(): FgColorDisplay<T, BrightCyan> = fg(BrightCyan)

    public fun brightWhite(): FgColorDisplay<T, BrightWhite> = fg(BrightWhite)

    public fun onBlack(): ComboColorDisplay<T, C, Black> = bg(Black)

    public fun onRed(): ComboColorDisplay<T, C, Red> = bg(Red)

    public fun onGreen(): ComboColorDisplay<T, C, Green> = bg(Green)

    public fun onYellow(): ComboColorDisplay<T, C, Yellow> = bg(Yellow)

    public fun onBlue(): ComboColorDisplay<T, C, Blue> = bg(Blue)

    public fun onMagenta(): ComboColorDisplay<T, C, Magenta> = bg(Magenta)

    public fun onPurple(): ComboColorDisplay<T, C, Magenta> = bg(Magenta)

    public fun onCyan(): ComboColorDisplay<T, C, Cyan> = bg(Cyan)

    public fun onWhite(): ComboColorDisplay<T, C, White> = bg(White)

    public fun onDefaultColor(): ComboColorDisplay<T, C, Default> = bg(Default)

    public fun onBrightBlack(): ComboColorDisplay<T, C, BrightBlack> = bg(BrightBlack)

    public fun onBrightRed(): ComboColorDisplay<T, C, BrightRed> = bg(BrightRed)

    public fun onBrightGreen(): ComboColorDisplay<T, C, BrightGreen> = bg(BrightGreen)

    public fun onBrightYellow(): ComboColorDisplay<T, C, BrightYellow> = bg(BrightYellow)

    public fun onBrightBlue(): ComboColorDisplay<T, C, BrightBlue> = bg(BrightBlue)

    public fun onBrightMagenta(): ComboColorDisplay<T, C, BrightMagenta> = bg(BrightMagenta)

    public fun onPurpleBright(): ComboColorDisplay<T, C, BrightMagenta> = bg(BrightMagenta)

    public fun onBrightCyan(): ComboColorDisplay<T, C, BrightCyan> = bg(BrightCyan)

    public fun onBrightWhite(): ComboColorDisplay<T, C, BrightWhite> = bg(BrightWhite)

    public fun <NewC : DynColor> color(newColor: NewC): FgDynColorDisplay<T, NewC> =
        FgDynColorDisplay(target, newColor)

    public fun <BgC : DynColor> onColor(bgColor: BgC): ComboDynColorDisplay<T, C, BgC> =
        ComboDynColorDisplay(target, color, bgColor)

    override fun toString(): String = "${color.ansiFg}$target\u001b[39m"
}

/**
 * Transparent wrapper around a type with the addition of changing the background color.
 */
public class BgColorDisplay<T, C : Color>(
    public val target: T,
    public val color: C,
) {
    public fun <NewC : Color> bg(newColor: NewC): BgColorDisplay<T, NewC> =
        BgColorDisplay(target, newColor)

    public fun <FgC : Color> fg(fgColor: FgC): ComboColorDisplay<T, FgC, C> =
        ComboColorDisplay(target, fgColor, color)

    public fun black(): ComboColorDisplay<T, Black, C> = fg(Black)

    public fun red(): ComboColorDisplay<T, Red, C> = fg(Red)

    public fun green(): ComboColorDisplay<T, Green, C> = fg(Green)

    public fun yellow(): ComboColorDisplay<T, Yellow, C> = fg(Yellow)

    public fun blue(): ComboColorDisplay<T, Blue, C> = fg(Blue)

    public fun magenta(): ComboColorDisplay<T, Magenta, C> = fg(Magenta)

    public fun purple(): ComboColorDisplay<T, Magenta, C> = fg(Magenta)

    public fun cyan(): ComboColorDisplay<T, Cyan, C> = fg(Cyan)

    public fun white(): ComboColorDisplay<T, White, C> = fg(White)

    public fun defaultColor(): ComboColorDisplay<T, Default, C> = fg(Default)

    public fun onBlack(): BgColorDisplay<T, Black> = bg(Black)

    public fun onRed(): BgColorDisplay<T, Red> = bg(Red)

    public fun onGreen(): BgColorDisplay<T, Green> = bg(Green)

    public fun onYellow(): BgColorDisplay<T, Yellow> = bg(Yellow)

    public fun onBlue(): BgColorDisplay<T, Blue> = bg(Blue)

    public fun onMagenta(): BgColorDisplay<T, Magenta> = bg(Magenta)

    public fun onPurple(): BgColorDisplay<T, Magenta> = bg(Magenta)

    public fun onCyan(): BgColorDisplay<T, Cyan> = bg(Cyan)

    public fun onWhite(): BgColorDisplay<T, White> = bg(White)

    public fun onDefaultColor(): BgColorDisplay<T, Default> = bg(Default)

    public fun <FgC : DynColor> color(fgColor: FgC): ComboDynColorDisplay<T, FgC, C> =
        ComboDynColorDisplay(target, fgColor, color)

    public fun <NewC : DynColor> onColor(newColor: NewC): BgDynColorDisplay<T, NewC> =
        BgDynColorDisplay(target, newColor)

    override fun toString(): String = "${color.ansiBg}$target\u001b[49m"
}

/**
 * Wrapper around a type with the addition of changing the foreground color dynamically.
 */
public class FgDynColorDisplay<T, C : DynColor>(
    public val target: T,
    public val color: C,
) {
    public fun <NewC : DynColor> color(newColor: NewC): FgDynColorDisplay<T, NewC> =
        FgDynColorDisplay(target, newColor)

    public fun <BgC : DynColor> onColor(bgColor: BgC): ComboDynColorDisplay<T, C, BgC> =
        ComboDynColorDisplay(target, color, bgColor)

    public fun black(): FgDynColorDisplay<T, Black> = color(Black)

    public fun red(): FgDynColorDisplay<T, Red> = color(Red)

    public fun green(): FgDynColorDisplay<T, Green> = color(Green)

    public fun yellow(): FgDynColorDisplay<T, Yellow> = color(Yellow)

    public fun blue(): FgDynColorDisplay<T, Blue> = color(Blue)

    public fun magenta(): FgDynColorDisplay<T, Magenta> = color(Magenta)

    public fun purple(): FgDynColorDisplay<T, Magenta> = color(Magenta)

    public fun cyan(): FgDynColorDisplay<T, Cyan> = color(Cyan)

    public fun white(): FgDynColorDisplay<T, White> = color(White)

    public fun defaultColor(): FgDynColorDisplay<T, Default> = color(Default)

    public fun onBlack(): ComboDynColorDisplay<T, C, Black> = onColor(Black)

    public fun onRed(): ComboDynColorDisplay<T, C, Red> = onColor(Red)

    public fun onGreen(): ComboDynColorDisplay<T, C, Green> = onColor(Green)

    public fun onYellow(): ComboDynColorDisplay<T, C, Yellow> = onColor(Yellow)

    public fun onBlue(): ComboDynColorDisplay<T, C, Blue> = onColor(Blue)

    public fun onMagenta(): ComboDynColorDisplay<T, C, Magenta> = onColor(Magenta)

    public fun onPurple(): ComboDynColorDisplay<T, C, Magenta> = onColor(Magenta)

    public fun onCyan(): ComboDynColorDisplay<T, C, Cyan> = onColor(Cyan)

    public fun onWhite(): ComboDynColorDisplay<T, C, White> = onColor(White)

    public fun onDefaultColor(): ComboDynColorDisplay<T, C, Default> = onColor(Default)

    override fun toString(): String = "${color.fmtAnsiFg()}$target\u001b[39m"
}

/**
 * Wrapper around a type with the addition of changing the background color dynamically.
 */
public class BgDynColorDisplay<T, C : DynColor>(
    public val target: T,
    public val color: C,
) {
    public fun <NewC : DynColor> onColor(newColor: NewC): BgDynColorDisplay<T, NewC> =
        BgDynColorDisplay(target, newColor)

    public fun <FgC : DynColor> color(fgColor: FgC): ComboDynColorDisplay<T, FgC, C> =
        ComboDynColorDisplay(target, fgColor, color)

    public fun black(): ComboDynColorDisplay<T, Black, C> = color(Black)

    public fun red(): ComboDynColorDisplay<T, Red, C> = color(Red)

    public fun green(): ComboDynColorDisplay<T, Green, C> = color(Green)

    public fun yellow(): ComboDynColorDisplay<T, Yellow, C> = color(Yellow)

    public fun blue(): ComboDynColorDisplay<T, Blue, C> = color(Blue)

    public fun magenta(): ComboDynColorDisplay<T, Magenta, C> = color(Magenta)

    public fun purple(): ComboDynColorDisplay<T, Magenta, C> = color(Magenta)

    public fun cyan(): ComboDynColorDisplay<T, Cyan, C> = color(Cyan)

    public fun white(): ComboDynColorDisplay<T, White, C> = color(White)

    public fun defaultColor(): ComboDynColorDisplay<T, Default, C> = color(Default)

    public fun onBlack(): BgDynColorDisplay<T, Black> = onColor(Black)

    public fun onRed(): BgDynColorDisplay<T, Red> = onColor(Red)

    public fun onGreen(): BgDynColorDisplay<T, Green> = onColor(Green)

    public fun onYellow(): BgDynColorDisplay<T, Yellow> = onColor(Yellow)

    public fun onBlue(): BgDynColorDisplay<T, Blue> = onColor(Blue)

    public fun onMagenta(): BgDynColorDisplay<T, Magenta> = onColor(Magenta)

    public fun onPurple(): BgDynColorDisplay<T, Magenta> = onColor(Magenta)

    public fun onCyan(): BgDynColorDisplay<T, Cyan> = onColor(Cyan)

    public fun onWhite(): BgDynColorDisplay<T, White> = onColor(White)

    public fun onDefaultColor(): BgDynColorDisplay<T, Default> = onColor(Default)

    override fun toString(): String = "${color.fmtAnsiBg()}$target\u001b[49m"
}

// ----------------------------------------------------------------------------
// OwoColorize Extension Functions
// ----------------------------------------------------------------------------

public fun <T, C : Color> T.fg(color: C): FgColorDisplay<T, C> = FgColorDisplay(this, color)

public fun <T, C : Color> T.bg(color: C): BgColorDisplay<T, C> = BgColorDisplay(this, color)

public fun <T> T.black(): FgColorDisplay<T, Black> = fg(Black)

public fun <T> T.red(): FgColorDisplay<T, Red> = fg(Red)

public fun <T> T.green(): FgColorDisplay<T, Green> = fg(Green)

public fun <T> T.yellow(): FgColorDisplay<T, Yellow> = fg(Yellow)

public fun <T> T.blue(): FgColorDisplay<T, Blue> = fg(Blue)

public fun <T> T.magenta(): FgColorDisplay<T, Magenta> = fg(Magenta)

public fun <T> T.purple(): FgColorDisplay<T, Magenta> = fg(Magenta)

public fun <T> T.cyan(): FgColorDisplay<T, Cyan> = fg(Cyan)

public fun <T> T.white(): FgColorDisplay<T, White> = fg(White)

public fun <T> T.defaultColor(): FgColorDisplay<T, Default> = fg(Default)

public fun <T> T.onBlack(): BgColorDisplay<T, Black> = bg(Black)

public fun <T> T.onRed(): BgColorDisplay<T, Red> = bg(Red)

public fun <T> T.onGreen(): BgColorDisplay<T, Green> = bg(Green)

public fun <T> T.onYellow(): BgColorDisplay<T, Yellow> = bg(Yellow)

public fun <T> T.onBlue(): BgColorDisplay<T, Blue> = bg(Blue)

public fun <T> T.onMagenta(): BgColorDisplay<T, Magenta> = bg(Magenta)

public fun <T> T.onPurple(): BgColorDisplay<T, Magenta> = bg(Magenta)

public fun <T> T.onCyan(): BgColorDisplay<T, Cyan> = bg(Cyan)

public fun <T> T.onWhite(): BgColorDisplay<T, White> = bg(White)

public fun <T> T.onDefaultColor(): BgColorDisplay<T, Default> = bg(Default)

public fun <T> T.brightBlack(): FgColorDisplay<T, BrightBlack> = fg(BrightBlack)

public fun <T> T.brightRed(): FgColorDisplay<T, BrightRed> = fg(BrightRed)

public fun <T> T.brightGreen(): FgColorDisplay<T, BrightGreen> = fg(BrightGreen)

public fun <T> T.brightYellow(): FgColorDisplay<T, BrightYellow> = fg(BrightYellow)

public fun <T> T.brightBlue(): FgColorDisplay<T, BrightBlue> = fg(BrightBlue)

public fun <T> T.brightMagenta(): FgColorDisplay<T, BrightMagenta> = fg(BrightMagenta)

public fun <T> T.brightPurple(): FgColorDisplay<T, BrightMagenta> = fg(BrightMagenta)

public fun <T> T.brightCyan(): FgColorDisplay<T, BrightCyan> = fg(BrightCyan)

public fun <T> T.brightWhite(): FgColorDisplay<T, BrightWhite> = fg(BrightWhite)

public fun <T> T.onBrightBlack(): BgColorDisplay<T, BrightBlack> = bg(BrightBlack)

public fun <T> T.onBrightRed(): BgColorDisplay<T, BrightRed> = bg(BrightRed)

public fun <T> T.onBrightGreen(): BgColorDisplay<T, BrightGreen> = bg(BrightGreen)

public fun <T> T.onBrightYellow(): BgColorDisplay<T, BrightYellow> = bg(BrightYellow)

public fun <T> T.onBrightBlue(): BgColorDisplay<T, BrightBlue> = bg(BrightBlue)

public fun <T> T.onBrightMagenta(): BgColorDisplay<T, BrightMagenta> = bg(BrightMagenta)

public fun <T> T.onBrightPurple(): BgColorDisplay<T, BrightMagenta> = bg(BrightMagenta)

public fun <T> T.onBrightCyan(): BgColorDisplay<T, BrightCyan> = bg(BrightCyan)

public fun <T> T.onBrightWhite(): BgColorDisplay<T, BrightWhite> = bg(BrightWhite)

public fun <T, C : DynColor> T.color(color: C): FgDynColorDisplay<T, C> = FgDynColorDisplay(this, color)

public fun <T, C : DynColor> T.onColor(color: C): BgDynColorDisplay<T, C> = BgDynColorDisplay(this, color)

public fun <T> T.truecolor(r: Int, g: Int, b: Int): FgDynColorDisplay<T, Rgb> = color(Rgb(r, g, b))

public fun <T> T.onTruecolor(r: Int, g: Int, b: Int): BgDynColorDisplay<T, Rgb> = onColor(Rgb(r, g, b))

public fun <T> T.bold(): BoldDisplay<T> = BoldDisplay(this)

public fun <T> T.dimmed(): DimDisplay<T> = DimDisplay(this)

public fun <T> T.italic(): ItalicDisplay<T> = ItalicDisplay(this)

public fun <T> T.underline(): UnderlineDisplay<T> = UnderlineDisplay(this)

public fun <T> T.blink(): BlinkDisplay<T> = BlinkDisplay(this)

public fun <T> T.blinkFast(): BlinkFastDisplay<T> = BlinkFastDisplay(this)

public fun <T> T.reversed(): ReversedDisplay<T> = ReversedDisplay(this)

public fun <T> T.hidden(): HiddenDisplay<T> = HiddenDisplay(this)

public fun <T> T.strikethrough(): StrikeThroughDisplay<T> = StrikeThroughDisplay(this)

public fun <T, Out> T.ifSupportsColor(stream: Stream, apply: (T) -> Out): SupportsColorsDisplay<T, Out> =
    SupportsColorsDisplay(this, apply, stream)

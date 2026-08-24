import Testing
import OwoColors

@Suite("OwoColors Export Smoke Tests")
struct OwoColorsExportTests {
    @Test("Swift module loads cleanly")
    func testSwiftModuleLoads() throws {
        #expect(true)
    }

    @Test("Style factory from Swift")
    func testStyleFactoryFromSwift() throws {
        let s = style()
        #expect(s.isPlain())
    }

    @Test("Style builder chain from Swift")
    func testStyleBuilderChainFromSwift() throws {
        let s = style().red().onBlue().bold()
        #expect(!s.isPlain())
    }

    @Test("Prefix formatter emits SGR codes")
    func testPrefixFormatterEmitsSgrCodes() throws {
        let prefix = style().brightWhite().onBlue().bold().italic()
            .prefixFormatter()
            .toString()
        #expect(prefix == "\u{001B}[97;44;1;3m")
    }

    @Test("Suffix formatter is canonical reset")
    func testSuffixFormatterIsCanonicalReset() throws {
        let suffix = style().red().suffixFormatter().toString()
        #expect(suffix == "\u{001B}[0m")
    }

    @Test("Plain style emits no escapes")
    func testPlainStyleEmitsNoEscapes() throws {
        #expect(style().prefixFormatter().toString() == "")
        #expect(style().suffixFormatter().toString() == "")
    }

    @Test("AnsiColors enum is bridged")
    func testAnsiColorsEnumIsBridged() throws {
        let viaColor = style().color(color: AnsiColors.BrightYellow)
            .prefixFormatter()
            .toString()
        #expect(viaColor == "\u{001B}[93m")

        let viaOnColor = style().onColor(color: AnsiColors.BrightYellow)
            .prefixFormatter()
            .toString()
        #expect(viaOnColor == "\u{001B}[103m")
    }

    @Test("Effects vararg from Swift")
    func testEffectsVarargFromSwift() throws {
        let prefix = style().effects(effects: .Strikethrough, .Underline)
            .prefixFormatter()
            .toString()
        #expect(prefix == "\u{001B}[4;9m")
    }
}

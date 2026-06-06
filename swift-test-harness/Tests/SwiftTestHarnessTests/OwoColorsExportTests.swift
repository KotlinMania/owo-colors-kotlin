import XCTest
import OwoColors

// Smoke test for the Kotlin → Swift Export → SPM → swift test pipeline.
//
// The file's mere existence and successful compilation prove three layers
// of the pipeline:
//
//   1. `embedSwiftExportForXcode` produced `OwoColors.swiftmodule/`
//      and the supporting KotlinRuntimeSupport / ExportedKotlinPackages /
//      KotlinRuntime swiftmodule bundles. If any of them were missing,
//      `import OwoColors` above would fail at compile time.
//
//   2. The static archive `libOwoColors.a` (produced by the
//      `linkSwiftExportBinaryDebugStaticMacosArm64` and
//      `mergeMacosDebugSwiftExportLibraries` tasks) supplied every
//      `__root____*` and `KotlinError`-related symbol the Swift modules
//      reference. If the archive were missing or empty, this test
//      executable would fail to link with "undefined symbols for
//      architecture arm64".
//
//   3. The Kotlin `swiftExport { moduleName = "OwoColors" }` and
//      `flattenPackage = "io.github.kotlinmania.owocolors"` configuration in
//      build.gradle.kts produced a module name that's both syntactically
//      valid as a Swift identifier and reachable from this Package.swift
//      via the `OwoColorsLibrary` product.
//
// Add more meaningful per-API tests below as the Swift Export surface
// grows. For now the import + a single passing assertion is the
// canary that the pipeline is green for this repo.
final class OwoColorsExportTests: XCTestCase {
    func testSwiftModuleLoads() throws {
        XCTAssertTrue(true, "OwoColors swift module imported cleanly")
    }

    func testStyleFactoryFromSwift() throws {
        // Top-level `style()` factory crosses the bridge.
        let s = style()
        XCTAssertTrue(s.isPlain(), "default style should be plain")
    }

    func testStyleBuilderChainFromSwift() throws {
        // The builder-chain methods (red, onBlue, bold, ...) are bridged
        // because they return non-generic `Style`.
        let s = Style().red().onBlue().bold()
        XCTAssertFalse(s.isPlain(), "colored+bold style is not plain")
    }

    func testPrefixFormatterEmitsSgrCodes() throws {
        // `prefixFormatter()` returns the non-generic `StylePrefixFormatter`
        // whose `toString()` emits the SGR bracket sequence.
        let prefix = Style().brightWhite().onBlue().bold().italic()
            .prefixFormatter()
            .toString()
        XCTAssertEqual(prefix, "\u{001B}[97;44;1;3m")
    }

    func testSuffixFormatterIsCanonicalReset() throws {
        let suffix = Style().red().suffixFormatter().toString()
        XCTAssertEqual(suffix, "\u{001B}[0m")
    }

    func testPlainStyleEmitsNoEscapes() throws {
        XCTAssertEqual(Style().prefixFormatter().toString(), "")
        XCTAssertEqual(Style().suffixFormatter().toString(), "")
    }

    func testAnsiColorsEnumIsBridged() throws {
        // The AnsiColors enum is exposed as a Swift enum with case-iterable
        // support (visible in the generated OwoColors.swift). Confirm we can
        // construct a Style with a dynamic color reference.
        let viaColor = Style().color(color: AnsiColors.BrightYellow)
            .prefixFormatter()
            .toString()
        XCTAssertEqual(viaColor, "\u{001B}[93m")

        let viaOnColor = Style().onColor(color: AnsiColors.BrightYellow)
            .prefixFormatter()
            .toString()
        XCTAssertEqual(viaOnColor, "\u{001B}[103m")
    }

    func testEffectsVarargFromSwift() throws {
        let prefix = Style().effects(effects: .Strikethrough, .Underline)
            .prefixFormatter()
            .toString()
        XCTAssertEqual(prefix, "\u{001B}[4;9m")
    }
}

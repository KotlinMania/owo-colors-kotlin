# port-lint Proposed Changes

**Generated:** 2026-08-25
**Source:** tmp/owo-colors/src
**Target:** src/commonMain/kotlin/io/github/kotlinmania/owocolors

These are review proposals only. They are emitted when a Rust -> Kotlin pair matches only after fallback normalization, so the existing `port-lint` header is not an exact provenance match.

| Target file | Current header | Proposed header | Source path | Reason |
|-------------|----------------|-----------------|-------------|--------|
| `src/commonMain/kotlin/io/github/kotlinmania/owocolors/DynStyles.kt` | `// port-lint: source src/dyn_styles.rs` | `// port-lint: source dyn_styles.rs` | `dyn_styles.rs` | `port-lint provenance header matched only after fallback normalization: 'src/dyn_styles.rs' vs expected 'dyn_styles.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/owocolors/DynStylesTest.kt` | `// port-lint: tests src/dyn_styles.rs` | `// port-lint: tests dyn_styles.rs` | `dyn_styles.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:src/dyn_styles.rs' vs expected 'dyn_styles.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/owocolors/DynColors.kt` | `// port-lint: source src/dyn_colors.rs` | `// port-lint: source dyn_colors.rs` | `dyn_colors.rs` | `port-lint provenance header matched only after fallback normalization: 'src/dyn_colors.rs' vs expected 'dyn_colors.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/owocolors/Overrides.kt` | `// port-lint: source src/overrides.rs` | `// port-lint: source overrides.rs` | `overrides.rs` | `port-lint provenance header matched only after fallback normalization: 'src/overrides.rs' vs expected 'overrides.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/owocolors/OverridesTest.kt` | `// port-lint: tests src/overrides.rs` | `// port-lint: tests overrides.rs` | `overrides.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:src/overrides.rs' vs expected 'overrides.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/owocolors/Colors.kt` | `// port-lint: source src/colors.rs` | `// port-lint: source colors.rs` | `colors.rs` | `port-lint provenance header matched only after fallback normalization: 'src/colors.rs' vs expected 'colors.rs'` |

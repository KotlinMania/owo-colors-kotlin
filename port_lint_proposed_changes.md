# port-lint Proposed Changes

**Generated:** 2026-08-25
**Source:** tmp
**Target:** src/commonMain/kotlin

These are review proposals only. They are emitted when a Rust -> Kotlin pair matches only after fallback normalization, so the existing `port-lint` header is not an exact provenance match.

| Target file | Current header | Proposed header | Source path | Reason |
|-------------|----------------|-----------------|-------------|--------|
| `src/commonMain/kotlin/io/github/kotlinmania/owocolors/DynStyles.kt` | `// port-lint: source dyn_styles.rs` | `// port-lint: source dyn_styles.rs` | `dyn_styles.rs` | `port-lint provenance header matched only after fallback normalization: 'dyn_styles.rs' vs expected 'dyn_styles.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/owocolors/DynStylesTest.kt` | `// port-lint: tests dyn_styles.rs` | `// port-lint: tests dyn_styles.rs` | `dyn_styles.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:dyn_styles.rs' vs expected 'dyn_styles.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/owocolors/DynColors.kt` | `// port-lint: source dyn_colors.rs` | `// port-lint: source dyn_colors.rs` | `dyn_colors.rs` | `port-lint provenance header matched only after fallback normalization: 'dyn_colors.rs' vs expected 'dyn_colors.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/owocolors/Overrides.kt` | `// port-lint: source overrides.rs` | `// port-lint: source overrides.rs` | `overrides.rs` | `port-lint provenance header matched only after fallback normalization: 'overrides.rs' vs expected 'overrides.rs'` |
| `src/commonTest/kotlin/io/github/kotlinmania/owocolors/OverridesTest.kt` | `// port-lint: tests overrides.rs` | `// port-lint: tests overrides.rs` | `overrides.rs` | `port-lint provenance header matched only after fallback normalization: 'tests:overrides.rs' vs expected 'overrides.rs'` |
| `src/commonMain/kotlin/io/github/kotlinmania/owocolors/Colors.kt` | `// port-lint: source colors.rs` | `// port-lint: source colors.rs` | `colors.rs` | `port-lint provenance header matched only after fallback normalization: 'colors.rs' vs expected 'colors.rs'` |

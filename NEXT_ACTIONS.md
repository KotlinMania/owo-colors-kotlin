# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 4/14 (28.6%)
- **Function parity:** 31/130 matched (target 101) — 23.8%
- **Class/type parity:** 8/33 matched (target 12) — 24.2%
- **Combined symbol parity:** 39/163 matched (target 113) — 23.9%
- **Average inline-code cosine:** 0.25 (function body across 4 matched files)
- **Average documentation cosine:** 0.62 (doc text across 4 matched files)
- **Cheat-zeroed Files:** 3
- **Critical Issues:** 3 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. dyn_styles

- **Target:** `owocolors.DynStyles [ZERO] [PROVENANCE-FALLBACK]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 174410.0
- **Functions:** 21/38 matched (target 91)
- **Missing functions:** `new`, `default`, `fg`, `bg`, `fg_rgb`, `bg_rgb`, `truecolor`, `on_truecolor`, `fmt`, `inner`, `inner_mut`, `size_of`, `test_truecolor`, `test_string_reference`, `test_owocolorize`, `test_is_plain`, `test_inner`
- **Types:** 6/6 matched (target 7)
- **Missing types:** _none_
- **Tests:** 3/9 matched
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `src/dyn_styles.rs` vs expected `dyn_styles.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tests:src/dyn_styles.rs` vs expected `dyn_styles.rs`
- **Proposed provenance header:** `// port-lint: source dyn_styles.rs` (current: `// port-lint: source src/dyn_styles.rs`)
- **Proposed provenance header:** `// port-lint: tests dyn_styles.rs` (current: `// port-lint: tests src/dyn_styles.rs`)
- **Lint issues:** 2

### 2. dyn_colors

- **Target:** `owocolors.DynColors [ZERO] [PROVENANCE-FALLBACK]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 91010.0
- **Functions:** 0/7 matched (target 0)
- **Missing functions:** `fmt_ansi_fg`, `fmt_ansi_bg`, `fmt_raw_ansi_fg`, `fmt_raw_ansi_bg`, `get_dyncolors_fg`, `get_dyncolors_bg`, `from_str`
- **Types:** 1/3 matched (target 2)
- **Missing types:** `ParseColorError`, `Err`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `src/dyn_colors.rs` vs expected `dyn_colors.rs`
- **Proposed provenance header:** `// port-lint: source dyn_colors.rs` (current: `// port-lint: source src/dyn_colors.rs`)
- **Lint issues:** 1

### 3. overrides

- **Target:** `owocolors.Overrides [ZERO] [PROVENANCE-FALLBACK]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 21310.0
- **Functions:** 10/11 matched (target 10)
- **Missing functions:** `drop`
- **Types:** 1/2 matched
- **Missing types:** `ResetOverrideGuard`
- **Tests:** 1/1 matched
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `src/overrides.rs` vs expected `overrides.rs`
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `tests:src/overrides.rs` vs expected `overrides.rs`
- **Proposed provenance header:** `// port-lint: source overrides.rs` (current: `// port-lint: source src/overrides.rs`)
- **Proposed provenance header:** `// port-lint: tests overrides.rs` (current: `// port-lint: tests src/overrides.rs`)
- **Lint issues:** 2

### 4. colors

- **Target:** `owocolors.Colors [PROVENANCE-FALLBACK]`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 0.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 1)
- **Missing types:** _none_
- **Provenance warning:** port-lint provenance header matched only after fallback normalization: `src/colors.rs` vs expected `colors.rs`
- **Proposed provenance header:** `// port-lint: source colors.rs` (current: `// port-lint: source src/colors.rs`)
- **Lint issues:** 1

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

## Reexport / Wiring Modules

These files match `reexport_modules` patterns in `.ast_distance_config.json`. They are filtered out of
normal priority and missing-file ladders because they are wiring
modules, not direct logic ports. Consult them for call-site routing;
do not treat them as the next implementation target by default.

### Missing

| Source | Expected target | Deps | Source path | Expected path |
|--------|-----------------|------|-------------|---------------|
| `lib` | `Lib` | 0 | `lib.rs` | `Lib.kt` |


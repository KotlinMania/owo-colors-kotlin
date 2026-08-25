=== Deep Analysis: tmp (rust) -> src/commonMain/kotlin (kotlin) ===

Scanning source codebase (rust)...
Codebase: tmp (rust)
  Files: 15
  Total imports: 51
  Most depended: owo-colors.styled_list (1 dependents)

Scanning target codebase (kotlin)...
Codebase: src/commonMain/kotlin (kotlin)
  Files: 9
  Total imports: 8

Comparing codebases...
Computing AST similarities...

=== Codebase Comparison Report ===

Source: tmp (15 files)
Target: src/commonMain/kotlin (9 files)
Scoring invariant: FnSim is required function body/parameter similarity. Class/type and symbol parity are reported beside it; whole-file shape is diagnostic only.

Matched:   4 files
Unmatched: 11 source, 3 target

=== Matched Files (by porting priority) ===

Source                        Target                        FnSim     Dependents FunctionParityTypeParity  Priority
 --------------------------------------------------------------------------------------------------------------------------
owo-colors.dyn_styles         owocolors.DynStyles [PROVENANCE-FALLBACK]0.40      0          21/38         6/6         174406.0  
owo-colors.dyn_colors         owocolors.DynColors [ZERO] [PROVENANCE-FALLBACK]0.00      0          0/7           1/3         91010.0   
owo-colors.overrides          owocolors.Overrides [PROVENANCE-FALLBACK]0.76      0          10/11         1/2         21302.4   
owo-colors.colors             owocolors.Colors [PROVENANCE-FALLBACK]1.00      0          0/0           0/0         0.0       

=== Function and Symbol Details ===

owo-colors.dyn_styles -> owocolors.DynStyles [PROVENANCE-FALLBACK]
  similarity: 0.40, priority: 174406.0, dependents: 0
  provenance warning: port-lint provenance header matched only after fallback normalization: `dyn_styles.rs` vs expected `dyn_styles.rs`
  provenance warning: port-lint provenance header matched only after fallback normalization: `tests:dyn_styles.rs` vs expected `dyn_styles.rs`
  functions: 21/38 matched (target total: 91, required body score: 0.40)
  missing functions: new, default, fg, bg, fg_rgb, bg_rgb, truecolor, on_truecolor, fmt, inner, inner_mut, size_of, test_truecolor, test_string_reference, test_owocolorize, test_is_plain, test_inner
  types: 6/6 matched (target total: 7)
  missing types: none
  tests: 3/9 matched

owo-colors.dyn_colors -> owocolors.DynColors [ZERO] [PROVENANCE-FALLBACK]
  similarity: 0.00, priority: 91010.0, dependents: 0
  provenance warning: port-lint provenance header matched only after fallback normalization: `dyn_colors.rs` vs expected `dyn_colors.rs`
  functions: 0/7 matched (target total: 0, required body score: 0.00)
  missing functions: fmt_ansi_fg, fmt_ansi_bg, fmt_raw_ansi_fg, fmt_raw_ansi_bg, get_dyncolors_fg, get_dyncolors_bg, from_str
  types: 1/3 matched (target total: 2)
  missing types: ParseColorError, Err
  *** CHEAT DETECTION / SCORING FAILURE ***
  function-by-function score forced to 0: no target functions found; report scoring is function-by-function only

owo-colors.overrides -> owocolors.Overrides [PROVENANCE-FALLBACK]
  similarity: 0.76, priority: 21302.4, dependents: 0
  provenance warning: port-lint provenance header matched only after fallback normalization: `overrides.rs` vs expected `overrides.rs`
  provenance warning: port-lint provenance header matched only after fallback normalization: `tests:overrides.rs` vs expected `overrides.rs`
  functions: 10/11 matched (target total: 10, required body score: 0.76)
  missing functions: drop
  types: 1/2 matched (target total: 2)
  missing types: ResetOverrideGuard
  tests: 1/1 matched

owo-colors.colors -> owocolors.Colors [PROVENANCE-FALLBACK]
  similarity: 1.00, priority: 0.0, dependents: 0
  provenance warning: port-lint provenance header matched only after fallback normalization: `colors.rs` vs expected `colors.rs`
  functions: 0/0 matched (target total: 0, required body score: 1.00)
  missing functions: none
  types: 0/0 matched (target total: 1)
  missing types: none


=== Scores Forced To 0 ===

  - owo-colors.dyn_colors -> owocolors.DynColors: no target functions found; report scoring is function-by-function only

=== Provenance Header Fallbacks ===

These files were paired only after normalization; fix the port-lint source header.
  - owo-colors.dyn_styles -> owocolors.DynStyles: port-lint provenance header matched only after fallback normalization: `dyn_styles.rs` vs expected `dyn_styles.rs`
    proposed: // port-lint: source dyn_styles.rs
  - owo-colors.dyn_styles -> owocolors.DynStyles: port-lint provenance header matched only after fallback normalization: `tests:dyn_styles.rs` vs expected `dyn_styles.rs`
    proposed: // port-lint: tests dyn_styles.rs
  - owo-colors.dyn_colors -> owocolors.DynColors: port-lint provenance header matched only after fallback normalization: `dyn_colors.rs` vs expected `dyn_colors.rs`
    proposed: // port-lint: source dyn_colors.rs
  - owo-colors.overrides -> owocolors.Overrides: port-lint provenance header matched only after fallback normalization: `overrides.rs` vs expected `overrides.rs`
    proposed: // port-lint: source overrides.rs
  - owo-colors.overrides -> owocolors.Overrides: port-lint provenance header matched only after fallback normalization: `tests:overrides.rs` vs expected `overrides.rs`
    proposed: // port-lint: tests overrides.rs
  - owo-colors.colors -> owocolors.Colors: port-lint provenance header matched only after fallback normalization: `colors.rs` vs expected `colors.rs`
    proposed: // port-lint: source colors.rs

=== Missing from Target (need to port) ===

File                          Deps    Path
------------------------------------------------------------------------------
owo-colors.styled_list        1       owo-colors/src/styled_list.rs
owo-colors.build              0       owo-colors/build.rs
colors.css                    0       owo-colors/src/colors/css.rs
colors.custom                 0       owo-colors/src/colors/custom.rs
colors.dynamic                0       owo-colors/src/colors/dynamic.rs
colors.xterm                  0       owo-colors/src/colors/xterm.rs
owo-colors.combo              0       owo-colors/src/combo.rs
owo-colors.lib                0       owo-colors/src/lib.rs
owo-colors.styles             0       owo-colors/src/styles.rs
owo-colors.supports_colors    0       owo-colors/src/supports_colors.rs
owo-colors.tests              0       owo-colors/src/tests.rs

=== Porting Quality Summary ===

Matched by exact header:          0 / 4
Matched by provenance fallback:   4 / 4
Matched by name:                  0 / 4
Total TODOs in target: 0
Total lint errors:    6
Stub files:           0

=== Big Picture ===

- Missing files: 11
- Incomplete ports (similarity < 60%): 2
- Stub files: 0
- Files missing functions: 3 (total deficit: 25 functions)
- Type definitions missing: 3
- Files missing tests: 1 (total deficit: 6 unported `#[test]` functions)
- Documentation coverage: 205 / 470 lines (44%)

Primary focus: create missing files (highest deps first)

=== Files with Issues ===

File                          Similarity LineRatio  FunctionParityTests     TODOs Lint  Status
----------------------------------------------------------------------------------------------------
owocolors.DynStyles [PROVENA  0.40       0.00       21/38         3/9       0     2     MISSING_FUNCS
  missing functions: `new`, `default`, `fg`, `bg`, `fg_rgb`, `bg_rgb`, `truecolor`, `on_truecolor`, `fmt`, `inner`, `inner_mut`, `size_of`, `test_truecolor`, `test_string_reference`, `test_owocolorize`, `test_is_plain`, `test_inner`
owocolors.DynColors [ZERO] [  0.00       0.00       0/7           -         0     1     LOW_SIM
  missing functions: `fmt_ansi_fg`, `fmt_ansi_bg`, `fmt_raw_ansi_fg`, `fmt_raw_ansi_bg`, `get_dyncolors_fg`, `get_dyncolors_bg`, `from_str`
  missing types: `ParseColorError`, `Err`
owocolors.Overrides [PROVENA  0.76       0.00       10/11         1/1       0     2     MISSING_FUNCS
  missing functions: `drop`
  missing types: `ResetOverrideGuard`
owocolors.Colors [PROVENANCE  1.00       0.00       -             -         0     1     LINT

=== Porting Recommendations ===

Incomplete ports (similarity < 60%): 2
Missing files: 11

Incomplete ports to complete:
  owo-colors.dyn_styles          similarity=0.40 function_parity=21/38 dependents=0
    missing functions: `new`, `default`, `fg`, `bg`, `fg_rgb`, `bg_rgb`, `truecolor`, `on_truecolor`, `fmt`, `inner`, `inner_mut`, `size_of`, `test_truecolor`, `test_string_reference`, `test_owocolorize`, `test_is_plain`, `test_inner`
  owo-colors.dyn_colors          similarity=0.00 function_parity=0/7 dependents=0
    missing functions: `fmt_ansi_fg`, `fmt_ansi_bg`, `fmt_raw_ansi_fg`, `fmt_raw_ansi_bg`, `get_dyncolors_fg`, `get_dyncolors_bg`, `from_str`
    missing types: `ParseColorError`, `Err`

=== Missing Files (by Dependents) ===

Source File                   Expected Target                       Dependents Path
-----------------------------------------------------------------------------------------------------------------------
owo-colors.styled_list        owocolors.src.StyledList              1          owo-colors/src/styled_list.rs
owo-colors.build              owocolors.Build                       0          owo-colors/build.rs
colors.css                    owocolors.src.colors.Css              0          owo-colors/src/colors/css.rs
colors.custom                 owocolors.src.colors.Custom           0          owo-colors/src/colors/custom.rs
colors.dynamic                owocolors.src.colors.Dynamic          0          owo-colors/src/colors/dynamic.rs
colors.xterm                  owocolors.src.colors.Xterm            0          owo-colors/src/colors/xterm.rs
owo-colors.combo              owocolors.src.Combo                   0          owo-colors/src/combo.rs
owo-colors.styles             owocolors.src.Styles                  0          owo-colors/src/styles.rs
owo-colors.supports_colors    owocolors.src.SupportsColors          0          owo-colors/src/supports_colors.rs
owo-colors.tests              owocolors.src.Tests                   0          owo-colors/src/tests.rs

=== Reexport / Wiring Modules (consult, don't transliterate) ===

owo-colors.lib                owocolors.src.Lib                     0          owo-colors/src/lib.rs

=== Documentation Gaps ===

There is missing documentation that is hurting overall scoring.
Documentation coverage: 205 / 470 lines (44%)
Files with >20% doc gap: 4

File                          Src Docs    Tgt Docs    Gap %     DocSim    DocAmt    DocEq     
----------------------------------------------------------------------------------------------
owo-colors.dyn_styles         360         145         59%       0.96      0.40      0.68      
owo-colors.overrides          82          50          39%       0.78      0.61      0.70      
owo-colors.colors             18          4           77%       0.46      0.22      0.34      
owo-colors.dyn_colors         10          6           39%       0.28      0.60      0.44      

=== Generating Reports ===

✅ Generated: port_status_report.md
✅ Generated: high_priority_ports.md
✅ Generated: NEXT_ACTIONS.md
✅ Generated: port_lint_proposed_changes.md

📁 All reports generated successfully!

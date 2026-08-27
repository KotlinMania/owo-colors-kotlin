# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 4/15 (26.7%)
- **Function parity:** 48/143 matched (target 130) — 33.6%
- **Class/type parity:** 9/43 matched (target 15) — 20.9%
- **Combined symbol parity:** 57/186 matched (target 145) — 30.6%
- **Average inline-code cosine:** 0.64 (function body across 4 matched files)
- **Average documentation cosine:** 0.66 (doc text across 4 matched files)
- **Cheat-zeroed Files:** 0
- **Critical Issues:** 2 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. owo-colors.dyn_styles

- **Target:** `owocolors.DynStyles`
- **Similarity:** 0.57
- **Dependents:** 0
- **Priority Score:** 54404.3
- **Functions:** 33/38 matched (target 107)
- **Missing functions:** `new`, `default`, `fmt`, `inner_mut`, `size_of`
- **Types:** 6/6 matched (target 7)
- **Missing types:** _none_
- **Tests:** 8/9 matched

### 2. owo-colors.dyn_colors

- **Target:** `owocolors.DynColors`
- **Similarity:** 0.22
- **Dependents:** 0
- **Priority Score:** 31007.8
- **Functions:** 5/7 matched (target 13)
- **Missing functions:** `get_dyncolors_fg`, `get_dyncolors_bg`
- **Types:** 2/3 matched (target 5)
- **Missing types:** `Err`

### 3. owo-colors.overrides

- **Target:** `owocolors.Overrides`
- **Similarity:** 0.76
- **Dependents:** 0
- **Priority Score:** 21302.4
- **Functions:** 10/11 matched (target 10)
- **Missing functions:** `drop`
- **Types:** 1/2 matched
- **Missing types:** `ResetOverrideGuard`
- **Tests:** 1/1 matched

### 4. owo-colors.colors

- **Target:** `owocolors.Colors`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 0.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 1)
- **Missing types:** _none_

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present


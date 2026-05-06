# owo-colors-kotlin in Kotlin

[![GitHub link](https://img.shields.io/badge/GitHub-KotlinMania%2Fowo--colors--kotlin-blue.svg)](https://github.com/KotlinMania/owo-colors-kotlin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kotlinmania/owo-colors-kotlin)](https://central.sonatype.com/artifact/io.github.kotlinmania/owo-colors-kotlin)
[![Build status](https://img.shields.io/github/actions/workflow/status/KotlinMania/owo-colors-kotlin/ci.yml?branch=main)](https://github.com/KotlinMania/owo-colors-kotlin/actions)

This is a Kotlin Multiplatform line-by-line transliteration port of [`owo-colors/owo-colors`](https://github.com/owo-colors/owo-colors).

**Original Project:** This port is based on [`owo-colors/owo-colors`](https://github.com/owo-colors/owo-colors). All design credit and project intent belong to the upstream authors; this repository is a faithful port to Kotlin Multiplatform with no behavioural changes intended.

### Porting status

This is an **in-progress port**. The goal is feature parity with the upstream Rust crate while providing a native Kotlin Multiplatform API. Every Kotlin file carries a `// port-lint: source <path>` header naming its upstream Rust counterpart so the AST-distance tool can track provenance.

---

## Upstream README — `owo-colors/owo-colors`

> The text below is reproduced and lightly edited from [`https://github.com/owo-colors/owo-colors`](https://github.com/owo-colors/owo-colors). It is the upstream project's own description and remains under the upstream authors' authorship; links have been rewritten to absolute upstream URLs so they continue to resolve from this repository.

## <img src="https://jam1.re/img/rust_owo.svg" height="100"> Colors

[![Current Crates.io Version](https://img.shields.io/crates/v/owo-colors.svg)](https://crates.io/crates/owo-colors)
[![docs-rs](https://docs.rs/owo-colors/badge.svg)](https://docs.rs/owo-colors)
![MSRV 1.81+](https://img.shields.io/badge/rustc-1.81+-blue.svg)
![Downloads](https://img.shields.io/crates/d/owo-colors)

A zero-allocation no_std-compatible zero-cost way to add color to your Rust
terminal to make people go owo.

**Supports:**

- [x] All std/core formatters
  - [x] [Display](https://doc.rust-lang.org/std/fmt/trait.Display.html)
  - [x] [Debug](https://doc.rust-lang.org/std/fmt/trait.Debug.html)
  - [x] [Octal](https://doc.rust-lang.org/std/fmt/trait.Octal.html)
  - [x] [LowerHex](https://doc.rust-lang.org/std/fmt/trait.LowerHex.html)
  - [x] [UpperHex](https://doc.rust-lang.org/std/fmt/trait.UpperHex.html)
  - [x] [Pointer](https://doc.rust-lang.org/std/fmt/trait.Pointer.html)
  - [x] [Binary](https://doc.rust-lang.org/std/fmt/trait.Binary.html)
  - [x] [LowerExp](https://doc.rust-lang.org/std/fmt/trait.LowerExp.html)
  - [x] [UpperExp](https://doc.rust-lang.org/std/fmt/trait.UpperExp.html)
- [x] Optional checking for if a terminal supports colors
  - [x] Enabled for CI
  - [x] Disabled by default for non-terminal outputs
  - [x] Overridable by `NO_COLOR`/`FORCE_COLOR` environment variables
  - [x] Overridable programmatically via [`set_override`](https://docs.rs/owo-colors/latest/owo_colors/fn.set_override.html)
- [x] Dependency-less by default
- [x] 100% safe code
- [x] Most functions are `const`
- [x] Hand picked names for all ANSI (4-bit) and Xterm (8-bit) colors
- [x] Support for RGB colors
- [x] Set colors at compile time by generics or at runtime by value
- [x] All ANSI colors
  - [x] Basic support (normal and bright variants)
  - [x] Xterm support (high compatibility and 256 colors)
  - [x] Truecolor support (modern, 48-bit color)
- [x] Styling (underline, strikethrough, etc)

owo-colors is also more-or-less a drop-in replacement for
[colored](https://crates.io/crates/colored), allowing colored to work in a
no_std environment. No allocations or dependencies required because embedded
systems deserve to be pretty too uwu.

To add to your Cargo.toml:

```toml
owo-colors = "4"
```

## Example

```rust
use owo_colors::OwoColorize;

fn main() {
    // Foreground colors
    println!("My number is {:#x}!", 10.green());
    // Background colors
    println!("My number is not {}!", 4.on_red());
}
```

## Generic colors

```rust
use owo_colors::OwoColorize;
use owo_colors::colors::*;

fn main() {
    // Generically color
    println!("My number might be {}!", 4.fg::<Black>().bg::<Yellow>());
}
```

## Stylize

```rust
use owo_colors::OwoColorize;

println!("{}", "strikethrough".strikethrough());
```

## Only Style on Supported Terminals

```rust
use owo_colors::{OwoColorize, Stream::Stdout};

println!(
    "{}",
    "colored blue if a supported terminal"
        .if_supports_color(Stdout, |text| text.bright_blue())
);
```

Supports `NO_COLOR`/`FORCE_COLOR` environment variables, checks if it's a tty,
checks if it's running in CI (and thus likely supports color), and checks which
terminal is being used. (Note: requires `supports-colors` feature)

## Minimum supported Rust version (MSRV)

The MSRV of owo-colors is **Rust 1.81**.

This library has a conservative MSRV policy — Rust versions from the last 12 months will be supported (features available in newer versions will be gated by `build.rs`), the MSRV will only be bumped if required, and if the MSRV is bumped it will always occur with a new minor version.

---

## About this Kotlin port

### Installation

```kotlin
dependencies {
    implementation("io.github.kotlinmania:owo-colors-kotlin:0.1.0-SNAPSHOT")
}
```

### Building

```bash
./gradlew build
./gradlew test
```

### Targets

- macOS arm64
- Linux x64
- Windows mingw-x64
- iOS arm64 / simulator-arm64 (Swift export + XCFramework)
- JS (browser + Node.js)
- Wasm-JS (browser + Node.js)
- Android (API 24+)

### Porting guidelines

See [AGENTS.md](AGENTS.md) and [CLAUDE.md](CLAUDE.md) for translator discipline, port-lint header convention, and Rust → Kotlin idiom mapping.

### License

This Kotlin port is distributed under the same MIT license as the upstream [`owo-colors/owo-colors`](https://github.com/owo-colors/owo-colors). See [LICENSE](LICENSE) (and any sibling `LICENSE-*` / `NOTICE` files mirrored from upstream) for the full text.

Original work copyrighted by the owo-colors authors.  
Kotlin port: Copyright (c) 2026 Sydney Renee and The Solace Project.

### Acknowledgments

Thanks to the [`owo-colors/owo-colors`](https://github.com/owo-colors/owo-colors) maintainers and contributors for the original Rust implementation. This port reproduces their work in Kotlin Multiplatform; bug reports about upstream design or behavior should go to the upstream repository.

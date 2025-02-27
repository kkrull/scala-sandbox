# Tools

Tools used in at least one project in this repository, in hopes of making life easier on developers.

Look here for references to foundational documentation and key configuration files.

## [Code Spell Checker](https://cspell.org/) (`cspell`)

- Documentation:
  - <https://github.com/streetsidesoftware/vscode-spell-checker>
- Files:
  - `cspell.config.yaml`: configuration file and dictionary
- Related tools:
  - [`pre-commit`](#pre-commit): Runs checks for this tool.
- VS Code extensions:
  - <https://marketplace.visualstudio.com/items?itemName=streetsidesoftware.code-spell-checker>

## [`direnv`](https://direnv.net/)

_Integrates environment management with your shell (e.g. `bash` or `zsh`)._

- Documentation:
  - Getting Started: <https://direnv.net/#getting-started>
  - Standard library: <https://direnv.net/man/direnv-stdlib.1.html>
- Files:
  - `.envrc`: loads application settings and any machine-specific settings into your environment.
  - `.envrc.local`: machine-specific settings, which are excluded from source control to avoid
    exposing secrets.
  - `.envrc.local.example`: an example of settings for various operating systems, which can be used
    as a template for creating `.envrc.local`.
- Installation:
  - Homebrew: `brew install direnv`
    **Note: Follow instructions about updating `.bashrc` or `.zshrc`**.

## [EditorConfig](https://editorconfig.org/)

_Defines basic parameters for formatting source files._

- Documentation:
  - Configuration: <https://editorconfig.org/>
  - Formal specification: <https://spec.editorconfig.org/>
- Files:
  - `.editorconfig`: configuration file
- Related tools:
  - [`pre-commit`](#pre-commit): Runs checks for this tool.

## [GitHub Actions](https://docs.github.com/en/actions)

_Performs Continuous Integration / Continuous Deployment (CI/CD)._

- Documentation:
  - Runner image definitions: <https://github.com/actions/runner-images>
  - Workflow syntax:
    <https://docs.github.com/en/actions/writing-workflows/workflow-syntax-for-github-actions>
- Files:
  - `.github/workflows/`: Workflow definitions

## [GNU Make](https://www.gnu.org/software/make/)

_Automates project-related tasks, such as rendering project audio._

- Documentation:
  - Makefile Style Guide: <https://style-guides.readthedocs.io/en/latest/makefile.html>
  - Manual: <https://www.gnu.org/software/make/manual/make.html>
  - Portable Makefiles: <https://www.oreilly.com/openbook/make3/book/ch07.pdf>
- Files:
  - `Makefile`

## [Markdown](https://daringfireball.net/projects/markdown/)

_File format and syntax for documentation._

- Documentation:
  - Syntax: <https://daringfireball.net/projects/markdown/syntax>
- VS Code extensions:
  - <https://marketplace.visualstudio.com/items?itemName=yzhang.markdown-all-in-one>

## [Markdownlint](https://github.com/DavidAnson/markdownlint-cli2) (`markdownlint-cli2`)

_Checks Markdown files for style or formatting errors._

- Documentation:
  - Rules: <https://github.com/DavidAnson/markdownlint/blob/main/doc/Rules.md>
- Files:
  - `.markdownlint-cli2.jsonc`: configuration file
- Related tools:
  - [`pre-commit`](#pre-commit): Runs checks for this tool.
- VS Code extensions:
  - <https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint>

## [`pre-commit`](https://pre-commit.com/)

_A framework for managing and maintaining multi-language pre-commit hooks in Git repositories._

- Documentation:
  - Configuration file format:
    <https://pre-commit.com/index.html#adding-pre-commit-plugins-to-your-project>
  - Supported hooks: <https://pre-commit.com/hooks.html>
- Files:
  - `.pre-commit-config.yaml`: Defines hooks to run and where they come from

### Installation

- Install `pre-commit` with your favorite package manager:
  - Debian: `apt install pre-commit`
  - Homebrew: `brew install pre-commit`
- `pre-commit install`: Install Git hooks in this repository.

## [SDKMAN!](https://sdkman.io/install/)

_Manages multiple \[JVM-based] Software Development Kits on Unix systems._

- Documentation:
  - Homebrew tap: <https://github.com/sdkman/homebrew-tap>
- Installation:
  - Bash script: `curl -s "https://get.sdkman.io" | bash`
  - Homebrew: `brew tap sdkman/tap && brew install sdkman-cli`
  - Note: Configure your shell as indicated here: <https://sdkman.io/install/>

## [Simple Build Tool](https://www.scala-sbt.org/) (`sbt`)

_Build tool and task automation for Scala projects._

- Documentation:
  - Main: <https://www.scala-sbt.org/>
  - sbt by example: <https://www.scala-sbt.org/1.x/docs/sbt-by-example.html>
  - sbt is recursive (or what is in `project/` and should I ignore it?):
    <https://www.scala-sbt.org/1.x/docs/Organizing-Build.html#sbt+is+recursive>
- Files:
  - `build.sbt`
- Installation:
  - Homebrew (not recommended): `brew install sbt`
  - SDKMAN! (recommended): `sdk install sbt`

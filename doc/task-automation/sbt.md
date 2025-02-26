# SBT automation

This project uses [`sbt`](../tools.md#simple-build-tool-sbt) to automate tasks for Scala sources.

## Scala `sbt` tasks

### `sbt console`

Open an interactive console (e.g. a REPL).

### `sbt [~] compile`

Compile sources, optionally triggered by changes in the filesystem.

### `sbt [~] test`

Compile and run tests, optionally triggered by changes in the filesystem.

#### Test tooling

`scalatest` supports many paradigms of testing.  The ones I'm using are:

- `FeatureSpec with GivenWhenThen` for Acceptance-Test Driven Development (ATDD).
- `FunSpec with Matchers` for Behavior-Driven Development (BDD).

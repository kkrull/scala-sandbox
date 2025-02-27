# SBT automation

This project uses [`sbt`](../tools.md#simple-build-tool-sbt) to automate tasks for Scala sources.

## `sbt [~]compile`

Compile code, optionally triggering when sources change.

## `sbt console`

Start a REPL.

## `sbt dist`

Create a distribution in `target/universal/`.

## `sbt run`

Run the main program, compiling if necessary.

## `sbt [~]test`

Test code, optionally triggering when sources change.

## `sbt ~testQuick`

Run incremental tests when source files change.

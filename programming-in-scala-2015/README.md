# Programming in Scala Book Club

The original code I wrote as part of a book club that was working through an early edition of
Programming in Scala.

## Contents

- [`doc/`](./doc/README.md): Documentation, including project setup.
- `core/`: Core library.
- `project/`: Code for the meta build.
- `src/main/scala/`: Production code for the main package.
- `src/main/test/`: Test code for the main package.

## Setup

- Install [tools](#tools)
- [Use `make` and/or `sbt`](#task-automation) to build and test sources.

## Task Automation

This project uses:

- [GNU Make](../doc/tools.md#gnu-make) with conventional targets for building and managing
  artifacts.  See `Makefile` or run `make help` for details.
- [`sbt`](../doc/tools.md#simple-build-tool-sbt) as its build tool.  See `build.sbt` for details.

## Tools

Some tools need to be installed ahead of time:

- [GNU Make](../doc/tools.md#gnu-make)
- [SDKMAN!](../doc/tools.md#sdkman)
- [`sbt`](../doc/tools.md#simple-build-tool-sbt)

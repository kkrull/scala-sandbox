# `sbt` in Action

Trying out some parts of "`sbt` in Action".

## Contents

- [`doc/`](./doc/README.md): Documentation, including project setup.
- [`src/scala/`](./src/scala/README.md): Scala sources, lovingly organized by the Department of
  Redundancy Department.

## Setup

- Install [tools](#tools)
- [Use `make` and/or `sbt`](#task-automation) to build and test sources.

## Task Automation

This project uses:

- [GNU Make](../doc/tools.md#gnu-make) with conventional targets for building and managing
  artifacts.  See `Makefile` or run `make help` for details.
- [`sbt`](../doc/tools.md#simple-build-tool-sbt) as its build tool.  See `src/scala/build.sbt` for
  details.

## Tools

Some tools need to be installed ahead of time:

- [GNU Make](../doc/tools.md#gnu-make)
- [SDKMAN!](../doc/tools.md#sdkman)
- [`sbt`](../doc/tools.md#simple-build-tool-sbt)

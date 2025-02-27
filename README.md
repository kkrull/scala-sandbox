# Scala Sandbox

A monorepo of independent projects that try different ideas out in Scala.

## Continuous Integration

See [GitHub Actions](./doc/github-actions.md).

## Projects

- [`programming-in-scala-2015`](./programming-in-scala-2015/README.md): Book club for Programming in
  Scala, circa 2015.
- [`sbt-in-action`](./sbt-in-action/README.md): Going through the book.

## Setup

- Install repository-wide tools:
  - [GNU Make](./doc/tools.md#gnu-make)
  - [`pre-commit`](./doc/tools.md#pre-commit)
- Install tools listed in each project's documentation.
- Go for broke: `make` and `make test`.

## Task Automation

Tasks are automated in a couple of ways, in this repository:

- [GNU Make](./doc/tools.md#gnu-make) generally handles [repository-wide
  automation](./doc/gnu-make.md) (e.g. run all tests in all projects) and anything
  top-level within a project.
- Since this is a Scala repository, you're likely to see projects that use
  [`sbt`](./doc/tools.md#simple-build-tool-sbt) to automate Scala-centric tasks.

## Tools

See [tools](./doc/tools.md) for a comprehensive list of tools used throughout this repository and
some pointers on how to get them working.  Each project lists which tools among them are relevant to
its own sources.

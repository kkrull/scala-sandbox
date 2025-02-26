# Scala Sandbox

A monorepo of independent projects that try different ideas out in Scala.

## Projects

- [`programming-in-scala-2015`](./programming-in-scala-2015/README.md): Book club for Programming in
  Scala, circa 2015.

## Setup

- Install
  - [programs and development tools](./tools.md)
  - (optional) development tools (e.g. `pre-commit`): `make install-tools`
- Build: `make`

## Task Automation

Tasks are automated in a couple of ways, in this repository:

- [GNU Make](./doc/tools.md#gnu-make) generally handles [repository-wide
  automation](./doc/task-automation-gnu-make.md) (e.g. run all tests in all projects) and anything
  top-level within a project.
- Since this is a Scala repository, you're likely to see projects that use
  [`sbt`](./doc/tools.md#simple-build-tool-sbt) to automate Scala-centric tasks.

## Tools

See each project's documentation for a list of tools that it uses.  See [tools](./doc/tools.md) for
a comprehensive list of all tools, over all projects.

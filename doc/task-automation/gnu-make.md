# GNU Make Tasks

This project uses [GNU Make](../tools.md#gnu-make) to automate repository-wide tasks.

## Artifacts

### `src/scala/` targets

Contains tasks to build code and to support development.  Try `make help` to see what is available.

## Conventions

- Provide self-documenting [`help`](https://stackoverflow.com/a/47107132/112682), for relevant
  targets to enable discovery.
- Use conventional [directory
  variables](https://www.gnu.org/software/make/manual/make.html#Directory-Variables) with reasonable
  defaults.
- Use [standard
  targets](https://www.gnu.org/software/make/manual/html_node/Standard-Targets.html#Standard-Targets).
  Create separate Makefiles for sub-directories that have their own work.
- Use variables for the names of external programs like `fswatch`, with reasonable defaults.

## `pre-commit` Targets

Makefiles include targets to ease the process of running various checks on project sources with
[`pre-commit`](./tools.md#pre-commit).

## Support targets

### Help

Use the `help` target to list relevant targets in each `Makefile`:

```sh
# List targets in root Makefile
make help

# List targets for specific sources
make -C man help
```

## Standard targets

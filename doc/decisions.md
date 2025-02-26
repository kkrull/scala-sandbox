# Decision Log

## `Makefile` conventions

- Provide self-documenting [`help`](https://stackoverflow.com/a/47107132/112682), for relevant
  targets to enable discovery.
- Use conventional [directory
  variables](https://www.gnu.org/software/make/manual/make.html#Directory-Variables) with reasonable
  defaults.
- Use [standard
  targets](https://www.gnu.org/software/make/manual/html_node/Standard-Targets.html#Standard-Targets).
  Create separate Makefiles for sub-directories that have their own work.
- Use variables for the names of external programs like `fswatch`, with reasonable defaults.

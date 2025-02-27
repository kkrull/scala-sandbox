# Decision Log

## GitHub Actions conventions

### Separate workflows by project

There is a separate workflow–each with its own sequence of jobs–for each project in the monorepo.  A
workflow triggers upon proposed or merged changes to files in the workflow's project on in the
workflows themselves.  That way, it's easy to see what is changing in the monorepo and you don't
have to rebuild anything unnecessarily, when it hasn't changed.

### Separate jobs by reason to fail

Jobs start by defining the version of any major tools they are using, to avoid and troubleshoot
differences among environments.

Workflows have a sequence of jobs that depend upon the initial toolset/version job, roughly for each
distinct reason to fail.  That way, it's easier to tell at a glance why a workflow failed (e.g.
won't compile or just failed formatting).  Jobs also attempt to sequence to reveal as many errors as
possible (e.g. failed build AND failed linting), so you can fix both at the same time.

### Reduce duplication judiciously

Jobs use some environment variables to reduce duplication, to avoid annoying bugs like running two
separate jobs on two separate versions of the JDK.  Keep in mind that some values like `runs-on`
can't be passed a variable (or a YAML anchor), because this information is needed prior to the
running executing the code (e.g. the time when expressions are evaluated).

## `Makefile` conventions

### Enable overrides at runtime

Use variables for the names of external programs like `fswatch`, with reasonable defaults.  If
someone has their program installed in an alternate location–or if they are on an operating system
where paths are significantly different–it can be overridden at runtime by setting an environment
variable.

For example: `FSWATCH=$HOME/bin/fswatch make test:watch`

### Structure by source type

Create separate Makefiles for sub-directories that have their own work.  Otherwise, having one big
`Makefile` means you wind up with a confusing array of `build-a`, `build-b`, `test-a`, `test-b`
targets.

### Use idiomatic directories and targets

Use conventional [directory
variables](https://www.gnu.org/software/make/manual/make.html#Directory-Variables) with reasonable
defaults, so things install where people generally expect.

Use [standard
targets](https://www.gnu.org/software/make/manual/html_node/Standard-Targets.html#Standard-Targets)
so the process of building, testing, and installing works the same way across packages.

### Unlock discovery

Provide self-documenting [`help`](https://stackoverflow.com/a/47107132/112682), for relevant targets
to enable discovery.

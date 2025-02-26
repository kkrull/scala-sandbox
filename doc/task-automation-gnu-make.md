# GNU Make Tasks

This repository uses [GNU Make](./tools.md#gnu-make) to automate repository-wide tasks.  They are
structured according to some [local conventions](./decisions.md#makefile-conventions).

Try `make help` to see what is available.

## Artifacts

No top-level artifacts are built, in this repository, but each project might build its own.

## `pre-commit` Targets

Makefiles include targets to ease the process of running various checks on project sources with
[`pre-commit`](./tools.md#pre-commit).

## Support targets

### `make debug`

Print programs, paths, and other debugging information related to the build, recursively.

### `make help` and `make help-all`

Use `help` to list relevant targets in this `Makefile` and `help-all` to list targets in this file
and its descendants.

## Standard targets

### `make all`

Build artifacts from sources managed by this `Makefile` and its descendants.

### `make clean`

Remove local files–such as artifacts and object files–that are derived from sources managed by this
`Makefile` and its descendants.

### `make install` and `make uninstall`

Install artifacts–if any–that were [built](#make-all) from sources managed by this `Makefile`, to
standard locations on the filesystem.  Or uninstall artifacts that had been installed some time
earlier.

### `make install-assets`

Obtain and prepare a local copy of assets that are too large to store in this repository, such as
large images or audio files.

### `make install-tools`

Install tools used during development, where supported.

### `make test`

Run automated tests on sources managed by this `Makefile` and its descendants.

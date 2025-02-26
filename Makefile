#. ==Scala Sandbox==

.PHONY: default
default: all

## Sources

## Artifacts

## Paths

## Programs

## Project

.PHONY: debug-project
debug-project:
	$(info Project:)
	@:

#. PRE-COMMIT TARGETS

PRECOMMIT ?= pre-commit

.PHONY: pre-commit-gc
pre-commit-gc: #> Remove stale pre-commit files
	$(PRECOMMIT) gc

.PHONY: pre-commit-install
pre-commit-install: #> Install Git pre-commit hook
	$(PRECOMMIT) install

.PHONY: pre-commit-run
pre-commit-run: #> Run pre-commit on all sources
	$(PRECOMMIT) run --all-files

.PHONY: pre-commit-update
pre-commit-update: #> Update pre-commit plugins
	$(PRECOMMIT) autoupdate

#. STANDARD TARGETS

.PHONY: all
all: #> Build all sub-projects
	$(MAKE) -C programming-in-scala-2015 all

.PHONY: clean
clean: pre-commit-gc #> Remove local build files
	$(MAKE) -C programming-in-scala-2015 clean

.PHONY: install
install:
	@:

.PHONY: test
test: pre-commit-run #> Run checks
	$(MAKE) -C programming-in-scala-2015 test

.PHONY: uninstall
uninstall:
	@:

#. SUPPORT TARGETS

.PHONY: debug
.NOTPARALLEL: debug
debug: | debug-project #> Show debugging information
	@:

# https://stackoverflow.com/a/47107132/112682
.PHONY: help
help: #> Show this help
	@sed -n \
		-e '/@sed/!s/#[.] */_margin_\n/p' \
		-e '/@sed/!s/:.*#> /:/p' \
		$(MAKEFILE_LIST) \
	| column -ts : | sed -e 's/_margin_//'

.PHONY: help-all
help-all: help #> Show help for all Makefiles
	$(MAKE) -C programming-in-scala-2015 help

install-assets:
	$(MAKE) -C programming-in-scala-2015 install-assets

install-tools: pre-commit-install #> Install development tools
	$(MAKE) -C programming-in-scala-2015 install-tools

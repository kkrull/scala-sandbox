#. ==sbt in action==

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

#. STANDARD TARGETS

.PHONY: all
all: #> Build all artifacts
#	$(MAKE) -C src/scala all

.PHONY: clean
clean: #> Remove local build files
#	$(MAKE) -C src/scala clean

.PHONY: install
install:
	@:

.PHONY: test
test: #> Run checks
#	$(MAKE) -C src/scala test

.PHONY: uninstall
uninstall:
	@:

#. SUPPORT TARGETS

.PHONY: debug
.NOTPARALLEL: debug
debug: | debug-project #> Show debugging information
#	$(MAKE) -C src/scala debug

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
#	$(MAKE) -C src/scala help

install-assets:
	@:

install-tools:
	@:

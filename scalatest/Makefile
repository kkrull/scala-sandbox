#. ==ScalaTest==

.PHONY: default
default: all

## Sources

# NB: the wildcard function is not recursive: https://stackoverflow.com/a/2483203/112682
sources := $(shell find src/main/scala -type f -name '*.scala' | sort)

.PHONY: debug-sources
debug-sources:
	$(info Sources:)
	$(info - sources: $(sources))
	@:

## Artifacts

# Can't really track object files that well, since one scala file could output several class files
# For example, one for the class and one for the object.

.PHONY: debug-artifacts
debug-artifacts:
	$(info Artifacts:)
	@:

## Paths

.PHONY: debug-paths
debug-paths:
	$(info Paths:)
	@:

## Programs

SBT := sbt

.PHONY: debug-programs
debug-programs:
	$(info Programs:)
	$(info - SBT: $(SBT))
	@:

#. STANDARD TARGETS

.NOTPARALLEL: all
.PHONY: all
all: #> Build all artifacts with sbt (change detection delegated to sbt)
	$(SBT) compile

.PHONY: clean
clean: #> Remove files built from these sources
	$(SBT) clean

.PHONY: install
install:
	@:

.PHONY: test
test:
	$(SBT) test

.PHONY: uninstall
uninstall:
	@:

#. SUPPORT TARGETS

.PHONY: debug
.NOTPARALLEL: debug
debug: _debug-prefix debug-artifacts debug-paths debug-programs debug-sources #> Show debugging information
	@:

.PHONY: _debug-prefix
_debug-prefix:
	$(info ==Scala Test==)
	@:

# https://stackoverflow.com/a/47107132/112682
.PHONY: help
help: #> Show this help
	@sed -n \
		-e '/@sed/!s/#[.] */_margin_\n/p' \
		-e '/@sed/!s/:.*#> /:/p' \
		$(MAKEFILE_LIST) \
	| column -ts : | sed -e 's/_margin_//'

.PHONY: install-assets
install-assets:
	@:

.PHONY: install-tools
install-tools:
	@:

#. ==Scala==

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

# TODO KDK: Figure out where the compiled files go with sbt, these days.  Then update.
objects := $(patsubst src/main/scala/%.scala,target/%.class,$(sources))

.PHONY: debug-artifacts
debug-artifacts:
	$(info Artifacts:)
	$(info - objects: $(objects))
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

#. SCALA TARGETS

.PHONY: edit
edit:
	$(EDITOR) $(sources) &

target/scala/%.class: src/main/scala/%.scala #> Compile sources
	$(SBT) compile

#. STANDARD TARGETS

.NOTPARALLEL: all
.PHONY: all
all: $(objects) #> Build all artifacts
	@:

.PHONY: clean
clean: #> Remove files built from these sources
	$(RM) $(objects)

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
debug: debug-artifacts debug-paths debug-programs debug-sources #> Show debugging information
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

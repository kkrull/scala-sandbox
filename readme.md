# Scala SBT Project

Run `sbt` to start an interactive sbt session.  Within it:

- `console` for an interactive console
- `compmile` to compile
- `test` to test
- `~ <command>` to run that command upon changes in the filesystem

## Testing

`scalatest` supports many paradigms of testing.  The ones I'm using are:

- `FeatureSpec with GivenWhenThen` for Aceptance-Test Driven Development (ATDD).
- `FunSpec with Matchers` for Behavior-Driven Development (BDD).

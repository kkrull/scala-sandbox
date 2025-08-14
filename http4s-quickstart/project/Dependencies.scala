import sbt.*

object CompilerPlugins {
  val betterMonadicFor = "com.olegpy" %% "better-monadic-for" % "0.3.1"
  val kindProjector = "org.typelevel" %% "kind-projector" % "0.13.3" cross CrossVersion.full
}

object Dependencies {
  val catsEffectTesting = "org.typelevel" %% "cats-effect-testing-scalatest" % "1.6.0"
  val circeGeneric = "io.circe" %% "circe-generic" % "0.14.14"

  val http4s = "org.http4s" %% "http4s-core" % "0.23.30"
  val http4sCirce = "org.http4s" %% "http4s-circe" % http4s.revision
  val http4sDsl = "org.http4s" %% "http4s-dsl" % http4s.revision
  val http4sEmberClient = "org.http4s" %% "http4s-ember-client" % http4s.revision
  val http4sEmberServer = "org.http4s" %% "http4s-ember-server" % http4s.revision

  val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.5.18"

  val scalaMock = "org.scalamock" %% "scalamock" % "7.4.1"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.19"
}

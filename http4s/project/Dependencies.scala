import sbt.*

object Dependencies {
  val http4s = "org.http4s" %% "http4s-core" % "0.23.15"
  val http4sDsl = "org.http4s" %% "http4s-dsl" % http4s.revision
  val http4sEmberServer = "org.http4s" %% "http4s-ember-server" % http4s.revision

  val scalaMock = "org.scalamock" %% "scalamock" % "7.4.0"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.19"

  val sttp = "com.softwaremill.sttp.client3" %% "core" % "3.11.0"
  val sttpClient = "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats" % sttp.revision
}

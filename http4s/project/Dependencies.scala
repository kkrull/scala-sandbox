import sbt.*

object Dependencies {
  lazy val http4s = "org.http4s" %% "http4s-core" % "0.23.30"
  lazy val http4sDsl = "org.http4s" %% "http4s-dsl" % http4s.revision
  lazy val http4sEmberServer = "org.http4s" %% "http4s-ember-server" % http4s.revision

  lazy val scalaMock = "org.scalamock" %% "scalamock" % "7.4.1"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.19"

  lazy val sttp = "com.softwaremill.sttp.client3" %% "core" % "3.11.0"
  lazy val sttpClient = "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats" % sttp.revision
}

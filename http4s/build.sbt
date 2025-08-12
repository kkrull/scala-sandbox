import Dependencies._

ThisBuild / organization     := "com.github.kkrull"
ThisBuild / organizationName := "kkrull"
ThisBuild / scalaVersion     := "2.13.16"
ThisBuild / version          := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "http4s",
    libraryDependencies += munit % Test
  )

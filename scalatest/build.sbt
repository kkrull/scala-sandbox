ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.github.kkrull"

lazy val wholeThing = project
  .in(file("."))
  .settings(
    name := "ScalaTest examples",
  )

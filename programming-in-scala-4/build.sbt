ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.github.kkrull"

lazy val wholeThing = project
  .in(file("."))
  .settings(
    name := "Programming in Scala 4th Edition"
  )

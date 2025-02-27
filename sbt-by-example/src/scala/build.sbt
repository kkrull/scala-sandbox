ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.github.kkrull"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello"
  )

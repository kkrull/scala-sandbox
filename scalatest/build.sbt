ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.github.kkrull"

lazy val scalatest = (project in file(""))
  .settings(
    name := "ScalaTest examples"
  )

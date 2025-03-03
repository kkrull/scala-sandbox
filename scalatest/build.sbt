ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.github.kkrull"

lazy val wholeThing = project
  .in(file("."))
  .settings(
    name := "ScalaTest examples",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.19",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test",
    libraryDependencies += "org.scalatest" %% "scalatest-funspec" % "3.2.19" % "test"
  )

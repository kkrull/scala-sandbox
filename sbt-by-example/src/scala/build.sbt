ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.github.kkrull"

lazy val hello = project
  .in(file("."))
  .settings(
    name := "Hello",
    libraryDependencies += "org.scala-lang" %% "toolkit-test" % "0.1.7" % Test
  )

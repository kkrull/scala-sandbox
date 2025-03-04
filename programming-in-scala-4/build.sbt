ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.github.kkrull"

// Add ScalaTest compiler plugin for the (sub-)project build: https://www.scalatest.org/install
resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"

lazy val wholeThing = project
  .in(file("."))
  .settings(
    name := "Programming in Scala 4th Edition",

    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.19",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test"
  )

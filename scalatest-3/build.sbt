ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.github.kkrull"

lazy val wholeThing = project
  .in(file("."))
  .settings(
    name := "ScalaTest examples",

    // https://www.scalatest.org/install
    resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.19",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % "test"
  )

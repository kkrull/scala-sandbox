ThisBuild / scalaVersion := "2.13.16"
ThisBuild / organization := "com.github.kkrull"

lazy val catsHello = project
  .in(file("."))
  .settings(
    name := "catshello",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.12.0"
    )
  )

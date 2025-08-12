import org.typelevel.scalacoptions.ScalacOptions

lazy val root = (project in file("."))
  .settings(
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.13.3" cross CrossVersion.full),
    assembly / assemblyMergeStrategy := {
      case "module-info.class" => MergeStrategy.discard
      case x                   =>
        (assembly / assemblyMergeStrategy).value.apply(x)
    },
    fork := true,
    libraryDependencies ++= Seq(
      Dependencies.catsEffectTesting % Test,
      Dependencies.circeGeneric,
      Dependencies.http4sCirce,
      Dependencies.http4sDsl,
      Dependencies.http4sEmberClient,
      Dependencies.http4sEmberServer,
      Dependencies.logbackClassic % Runtime,
      Dependencies.scalaMock % Test,
      Dependencies.scalaTest % Test,
    ),
    name := "http4s-quickstart",
    organization := "com.github.kkrull",
    scalaVersion := "2.13.16",
    Test / tpolecatExcludeOptions += ScalacOptions.warnNonUnitStatement,
    version := "0.0.1-SNAPSHOT",
  )

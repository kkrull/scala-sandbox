import org.typelevel.scalacoptions.ScalacOptions

lazy val root = (project in file("."))
  .settings(
    addCompilerPlugin(CompilerPlugins.betterMonadicFor),
    addCompilerPlugin(CompilerPlugins.kindProjector),
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

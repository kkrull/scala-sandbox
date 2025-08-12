lazy val root = (project in file("."))
  .settings(
    organization := "com.github.kkrull",
    name := "http4s-quickstart",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.16",
    libraryDependencies ++= Seq(
      TemplateDependencies.http4sEmberServer,
      TemplateDependencies.http4sEmberClient,
      TemplateDependencies.http4sCirce,
      TemplateDependencies.http4sDsl,
      TemplateDependencies.circeGeneric,
      TemplateDependencies.mUnit % Test,
      TemplateDependencies.mUnitCatsEffect % Test,
      TemplateDependencies.logbackClassic % Runtime,
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.13.3" cross CrossVersion.full),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    assembly / assemblyMergeStrategy := {
      case "module-info.class" => MergeStrategy.discard
      case x                   => (assembly / assemblyMergeStrategy).value.apply(x)
    },
    fork := true,
  )

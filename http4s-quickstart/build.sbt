lazy val root = (project in file("."))
  .settings(
    assembly / assemblyMergeStrategy := {
      case "module-info.class" => MergeStrategy.discard
      case x                   => (assembly / assemblyMergeStrategy).value.apply(x)
    },
    fork := true,
    name := "http4s-quickstart",
    organization := "com.github.kkrull",
    scalaVersion := "2.13.16",
    version := "0.0.1-SNAPSHOT",
    libraryDependencies ++= Seq(
      Dependencies.circeGeneric,
      Dependencies.http4sCirce,
      Dependencies.http4sDsl,
      Dependencies.http4sEmberClient,
      Dependencies.http4sEmberServer,
      Dependencies.logbackClassic % Runtime,
      Dependencies.mUnit % Test,
      Dependencies.mUnitCatsEffect % Test,
    ),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.13.3" cross CrossVersion.full),
  )

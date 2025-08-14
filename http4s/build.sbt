import Dependencies.*

ThisBuild / organization := "com.github.kkrull"
ThisBuild / organizationName := "kkrull"
ThisBuild / scalaVersion := "2.13.16"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "http4s",

    libraryDependencies ++=
      Seq(
//        Dependencies.catsEffect,
//        Dependencies.catsRetry,
//        Dependencies.csvParser,
//        Dependencies.embeddedKafka % Test,
//        Dependencies.enumeratum,
//        Dependencies.enumeratumPlayJson,
//        Dependencies.fs2Core,
//        Dependencies.fs2S3,
//        Dependencies.fs2Sqs,
//        Dependencies.h2db % Test,
//        Dependencies.healthCheck,
        Dependencies.http4s,
        Dependencies.http4sDsl,
        Dependencies.http4sEmberServer,
//        Dependencies.http4sPlayJson,
//        Dependencies.kafkaUtils,
//        Dependencies.log4cats,
//        Dependencies.logback,
//        Dependencies.logbackLogstashEncoder,
//        Dependencies.mssqlServerJDBC,
//        Dependencies.playJson,
//        Dependencies.pureConfig,
        Dependencies.scalaMock % Test,
        Dependencies.scalaTest % Test,
//        Dependencies.slick,
//        Dependencies.slickHikaricp,
        Dependencies.sttp,
        Dependencies.sttpClient,
      ),
  )

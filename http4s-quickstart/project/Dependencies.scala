import sbt.*

object Dependencies {
  val circeGeneric = "io.circe" %% "circe-generic" % "0.14.14"

  val http4s = "org.http4s" %% "http4s-core" % "0.23.30"
  val http4sCirce = "org.http4s" %% "http4s-circe" % http4s.revision
  val http4sDsl = "org.http4s" %% "http4s-dsl" % http4s.revision
  val http4sEmberClient = "org.http4s" %% "http4s-ember-client" % http4s.revision
  val http4sEmberServer = "org.http4s" %% "http4s-ember-server" % http4s.revision

  val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.5.18"
  val mUnit = "org.scalameta" %% "munit" % "1.1.1"
  val mUnitCatsEffect = "org.typelevel" %% "munit-cats-effect" % "2.1.0"

  val scalaMock = "org.scalamock" %% "scalamock" % "7.4.1"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.19"
}

object ReferenceDependencies {
  val catsEffect = "org.typelevel" %% "cats-effect" % "3.6.3"
  val catsRetry = "com.github.cb372" %% "cats-retry" % "3.1.3"

  val csvParser = "com.opencsv" % "opencsv" % "5.12.0"
  val embeddedKafka = "io.github.embeddedkafka" %% "embedded-kafka" % "4.0.1.1"

  val enumeratum = "com.beachape" %% "enumeratum" % "1.7.5"
  val enumeratumPlayJson = "com.beachape" %% "enumeratum-play-json" % "1.8.2"

  val fs2Core = "co.fs2" %% "fs2-core" % "3.11.0"
  val fs2S3 = "io.laserdisc" %% "fs2-aws-s3" % "6.2.0"
  val fs2Sqs = "io.laserdisc" %% "fs2-aws-sqs" % fs2S3.revision

  val h2db = "com.h2database" % "h2" % "2.3.232"
  val healthCheck = "com.rewardsnetwork" %% "healthcheck" % "2.0.57"

  val http4s = "org.http4s" %% "http4s-core" % "0.23.15"
  val http4sDsl = "org.http4s" %% "http4s-dsl" % http4s.revision
  val http4sEmberServer = "org.http4s" %% "http4s-ember-server" % http4s.revision
  val http4sPlayJson = "org.http4s" %% "http4s-play-json" % http4s.revision

  val kafkaUtils = "com.rewardsnetwork" %% "kafka-utils" % "2.1.10"

  val log4cats = "org.typelevel" %% "log4cats-slf4j" % "2.7.0"
  val logback = "ch.qos.logback" % "logback-classic" % "1.5.18"
  val logbackLogstashEncoder = "net.logstash.logback" % "logstash-logback-encoder" % "8.1"

  val mssqlServerJDBC = "com.microsoft.sqlserver" % "mssql-jdbc" % "12.10.1.jre11"
  val playJson = "org.playframework" %% "play-json" % "3.0.4"
  val pureConfig = "com.github.pureconfig" %% "pureconfig" % "0.17.8"

  val scalaMock = "org.scalamock" %% "scalamock" % "7.4.0"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.19"

  val slick = "com.typesafe.slick" %% "slick" % "3.6.0"
  val slickHikaricp = "com.typesafe.slick" %% "slick-hikaricp" % slick.revision

  val sttp = "com.softwaremill.sttp.client3" %% "core" % "3.11.0"
  val sttpClient = "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats" % sttp.revision
}

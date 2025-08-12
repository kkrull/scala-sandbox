package com.github.kkrull.http4s

import cats.effect.{IO, IOApp}

object Main extends IOApp.Simple {
  val run = Http4sQuickstartServer.run[IO]
}

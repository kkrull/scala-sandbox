package com.github.kkrull.http4s

import cats.effect.Async
import cats.syntax.all._
import com.comcast.ip4s._
import com.github.kkrull.http4s.greet.{HelloRoutes, HelloWorldService}
import com.github.kkrull.http4s.joke.{JokeRoutes, Jokes}
import fs2.io.net.Network
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import org.http4s.server.middleware.Logger

class Http4sQuickstartServer[F[_]: Async: Network] {
  private val helloWorldService = HelloWorldService.impl[F]

  def run: F[Nothing] = {
    for {
      client <- EmberClientBuilder.default[F].build
      jokeAlg = Jokes.impl[F](client)

      routerAsHttpApp = (
        HelloRoutes.makeT[F](helloWorldService)
          <+> JokeRoutes.make[F](jokeAlg)
      ).orNotFound

      httpAppWithMiddleware = Logger.httpApp(true, true)(routerAsHttpApp)

      _ <-
        EmberServerBuilder
          .default[F]
          .withHost(ipv4"0.0.0.0")
          .withPort(port"8080")
          .withHttpApp(httpAppWithMiddleware)
          .build
    } yield ()
  }.useForever

}

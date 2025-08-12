package com.github.kkrull.http4s

import cats.effect.Async
import cats.syntax.all._
import com.comcast.ip4s._
import fs2.io.net.Network
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import org.http4s.server.middleware.Logger

object Http4sQuickstartServer {
  def run[F[_]: Async: Network]: F[Nothing] = {
    for {
      client <- EmberClientBuilder.default[F].build
      helloWorldAlg = HelloWorld.impl[F]
      jokeAlg = Jokes.impl[F](client)

      // Combine Service Routes into an HttpApp.
      // Can also be done via a Router if you
      // want to extract segments not checked
      // in the underlying routes.
      routerAsHttpApp = (
        Http4sQuickstartRoutes.helloWorldRoutes[F](helloWorldAlg) <+>
          Http4sQuickstartRoutes.jokeRoutes[F](jokeAlg)
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

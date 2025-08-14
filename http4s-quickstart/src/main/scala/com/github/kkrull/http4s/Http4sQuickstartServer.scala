package com.github.kkrull.http4s

import cats.effect.Async
import cats.effect.kernel.Resource
import cats.syntax.all._
import com.comcast.ip4s._
import com.github.kkrull.http4s.greet.{HelloRoutes, HelloWorldService}
import com.github.kkrull.http4s.joke.{JokeRoutes, Jokes}
import fs2.io.net.Network
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.middleware.Logger
import org.http4s.{HttpApp, HttpRoutes}

class Http4sQuickstartServer[F[_]: Async: Network] {
  def run: F[Nothing] = {
    for {
      jokeService <- jokeServiceResource
      allRoutes = applicationRoutes(jokeService)
      httpAppWithMiddleware = Logger.httpApp(true, true)(allRoutes)
      _ <-
        EmberServerBuilder
          .default[F]
          .withHost(ipv4"0.0.0.0")
          .withPort(port"8080")
          .withHttpApp(httpAppWithMiddleware)
          .build
    } yield ()
  }.useForever

  private def applicationRoutes(jokeService: Jokes[F]): HttpApp[F] =
    (
      helloRoutes <+>
        JokeRoutes.make[F](jokeService)
    ).orNotFound

  private val helloRoutes: HttpRoutes[F] =
    new HelloRoutes[F](helloWorldService).make

  private val helloWorldService = HelloWorldService.impl[F]

  private val jokeServiceResource: Resource[F, Jokes[F]] =
    for {
      client <- EmberClientBuilder.default[F].build
      service = Jokes.impl[F](client)
    } yield service
}

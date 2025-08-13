package com.github.kkrull.http4s.greet

import cats.effect.Sync
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

object HelloRoutes {
  def make[F[_]: Sync](service: HelloWorldService[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}

    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello" / name =>
      Name.fromString(name)
        .map(service.greet)
        .fold(
          error => BadRequest(error),
          greeting => Ok(greeting),
        )
    }
  }
}

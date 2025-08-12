package com.github.kkrull.http4s.greet

import cats.effect.Sync
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

object HelloRoutes {
  def helloWorldRoutes[F[_]: Sync](H: HelloWorld[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}

    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello" / name =>
      for {
        greeting <- H.greet(Name(name))
        resp <- Ok(greeting)
      } yield resp
    }
  }
}

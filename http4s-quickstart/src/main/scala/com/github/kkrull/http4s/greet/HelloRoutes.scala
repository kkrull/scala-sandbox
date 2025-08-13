package com.github.kkrull.http4s.greet

import cats.effect.Sync
import cats.implicits.toFlatMapOps
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

object HelloRoutes {
  def make[F[_]: Sync](service: HelloWorldService[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}

    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello" / nameInput =>
      Name.fromString(nameInput) match {
        case Left(validationError) => BadRequest(validationError)
        case Right(name: Name)     =>
          service.greet(name).flatMap {
            case Left(serviceError: Throwable) =>
              InternalServerError(s"Server error: ${serviceError.getMessage}")
            case Right(greeting: Greeting) =>
              Ok(greeting)
          }
      }
    }
  }
}

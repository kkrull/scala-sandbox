package com.github.kkrull.http4s.greet

import cats.data.EitherT
import cats.effect.Sync
import cats.implicits.toFlatMapOps
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpRoutes, Response}

object HelloRoutes {
  def make[F[_]: Sync](service: HelloWorldService[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}

    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello" / nameInput =>
      val maybeGreeting = for {
        name <- Name.fromString(nameInput) //EitherT[F, Throwable, Name]
        greeting <- service.greet(name) //EitherT[F, Throwable, Greeting]
      } yield Ok(greeting)

      val response: EitherT[F, Throwable, F[Response[F]]] = maybeGreeting.recover {
        case nameError: IllegalArgumentException =>
          BadRequest(nameError.getMessage)
        case serviceError: Throwable =>
          InternalServerError(serviceError.getMessage)
      }

      response.value.flatMap(_.getOrElse(InternalServerError(s"Impossible case")))
    }
  }
}

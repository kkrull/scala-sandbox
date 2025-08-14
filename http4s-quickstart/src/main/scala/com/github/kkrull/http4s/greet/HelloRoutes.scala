package com.github.kkrull.http4s.greet

import cats.data._
import cats.effect.Sync
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpRoutes, Response}

object HelloRoutes {
  def make[F[_]](
    service: HelloWorldService[F],
  )(implicit S: Sync[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello" / nameInput =>
      helloResponse(service, nameInput)
    }
  }

  private def helloResponse[F[_]](
    service: HelloWorldService[F],
    nameInput: String,
  )(implicit S: Sync[F]): F[Response[F]] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._

    val greeting = for {
      name <- EitherT.fromEither(Name.fromString(nameInput))
      greeting <- service.greetT(name)
    } yield greeting

    greeting.foldF(
      {
        case nameError: IllegalArgumentException =>
          BadRequest(nameError.getMessage)
        case serverError: Exception =>
          InternalServerError(s"Server error: ${serverError.getMessage}")
      },
      greeting => Ok(greeting),
    )
  }

  private def handleError[F[_]](response: EitherT[F, Exception, F[Response[F]]]): F[Response[F]] = ???
}

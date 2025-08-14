package com.github.kkrull.http4s.greet

import cats.data._
import cats.effect.Sync
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpRoutes, Response}

class HelloRoutes[F[_]: Sync](service: HelloWorldService[F]) {
  private val dsl = new Http4sDsl[F] {}
  import dsl._

  def make: HttpRoutes[F] =
    HttpRoutes.of[F] { case GET -> Root / "hello" / nameInput =>
      helloResponse(nameInput)
    }

  private def helloResponse(nameInput: String): F[Response[F]] =
    (for {
      name <- EitherT.fromEither(Name.fromString(nameInput))
      greeting <- service.greetT(name)
      response <- EitherT.rightT[F, Exception](Ok(greeting))
    } yield response).foldF(
      handleError,
      identity,
    )

  private def handleError: PartialFunction[Exception, F[Response[F]]] = {
    case nameError: IllegalArgumentException =>
      BadRequest(nameError.getMessage)
    case serverError: Exception =>
      InternalServerError(s"Server error: ${serverError.getMessage}")
  }
}

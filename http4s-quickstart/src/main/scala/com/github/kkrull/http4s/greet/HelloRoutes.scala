package com.github.kkrull.http4s.greet

import cats.ApplicativeError
import cats.data.EitherT
import cats.effect.Sync
import cats.implicits.toFlatMapOps
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpRoutes, Response}

object HelloRoutes {
  def makeAE[F[_]](
    service: HelloWorldService[F],
  )(implicit FAE: ApplicativeError[F, Exception] with Sync[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}

    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello_v2" / nameInput =>
      FAE.redeemWith(makeGreetingAE(nameInput, service))(
        {
          case nameError: IllegalArgumentException =>
            BadRequest(nameError.getMessage)
          case serviceError: Throwable =>
            InternalServerError(serviceError.getMessage)
        },
        (greeting: Greeting) => Ok(greeting),
      )
    }
  }

  def makeT[F[_]: Sync](service: HelloWorldService[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}

    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello" / nameInput =>
      val maybeGreeting = for {
        name <- Name.fromStringT(nameInput)
        greeting <- service.greetT(name)
      } yield Ok(greeting)

      val response: EitherT[F, Exception, F[Response[F]]] = maybeGreeting.recover {
        case nameError: IllegalArgumentException =>
          BadRequest(nameError.getMessage)
        case serviceError: Exception =>
          InternalServerError(serviceError.getMessage)
      }

      response.value.flatMap(_.getOrElse(InternalServerError(s"Impossible case")))
    }
  }

  private def makeGreetingAE[F[_]](
    nameInput: String,
    service: HelloWorldService[F],
  )(implicit FAE: ApplicativeError[F, Exception] with Sync[F]): F[Greeting] =
    Name
      .fromStringAE(nameInput)
      .flatMap(name => service.greetAE(name))
}

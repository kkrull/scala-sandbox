package com.github.kkrull.http4s.greet

import cats.data.EitherT
import cats.implicits._
import cats.{Applicative, ApplicativeError}

trait HelloWorldService[F[_]] {
  def greetAE(n: Name)(implicit ae: ApplicativeError[F, Exception]): F[Greeting]
  def greetT(n: Name): EitherT[F, Exception, Greeting]
}

object HelloWorldService {
  def impl[F[_]: Applicative]: HelloWorldService[F] = new HelloWorldService[F] {
    override def greetAE(name: Name)(implicit
      ae: ApplicativeError[F, Exception],
    ): F[Greeting] =
      ae.pure(Greeting(s"Hello ${name.value}"))

    override def greetT(name: Name) =
      Greeting(s"Hello ${name.value}").asRight[Exception].toEitherT[F]
  }
}

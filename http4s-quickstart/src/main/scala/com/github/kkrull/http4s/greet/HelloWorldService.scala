package com.github.kkrull.http4s.greet

import cats.Applicative
import cats.data.EitherT
import cats.implicits._

trait HelloWorldService[F[_]] {
  def greet(n: Name): EitherT[F, Throwable, Greeting]
}

object HelloWorldService {
  def impl[F[_]: Applicative]: HelloWorldService[F] = new HelloWorldService[F] {
    override def greet(name: Name) =
      Greeting(s"Hello ${name.value}").asRight[Throwable].toEitherT[F]
  }
}

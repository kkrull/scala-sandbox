package com.github.kkrull.http4s.greet

import cats.Applicative
import cats.implicits._

trait HelloWorldService[F[_]] {
  def greet(n: Name): F[Greeting]
}

object HelloWorldService {
  def impl[F[_]: Applicative]: HelloWorldService[F] = new HelloWorldService[F] {
    def greet(n: Name): F[Greeting] =
      Greeting(s"Hello ${n.name}").pure[F]
  }
}

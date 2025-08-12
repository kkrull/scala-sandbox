package com.github.kkrull.http4s.greet

import cats.Applicative
import cats.implicits._

trait HelloWorld[F[_]] {
  def greet(n: Name): F[Greeting]
}

object HelloWorld {
  def impl[F[_]: Applicative]: HelloWorld[F] = new HelloWorld[F] {
    def greet(n: Name): F[Greeting] =
      Greeting("Hello, " + n.name).pure[F]
  }
}

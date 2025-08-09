package catseffect.lectures.part1recap

import cats.{Functor, Semigroup}
import cats.syntax.all._

object CatsTypeClasses {

  def increment[F[_] : Functor](container: F[Int]): F[Int] =
    container.map(_ + 1)

  def main(args: Array[String]): Unit = {
    println(s"increment: ${increment(List(1, 2, 4))}")
  }
}

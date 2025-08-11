package catseffect.lectures.part2effects

import cats.effect.IO

object IOIntroduction {
  val ourFirstIO: IO[Int] = IO.pure(42)
  val aDelayedIO: IO[Int] = IO.delay {
    println(s"Producing an integer")
    42
  }

  val aDelayedIO_v2: IO[Int] = IO {
    println(s"Producing an integer")
    42
  }

  def main(args: Array[String]): Unit = {
    import cats.effect.unsafe.implicits.global
    println(aDelayedIO.unsafeRunSync())
  }
}

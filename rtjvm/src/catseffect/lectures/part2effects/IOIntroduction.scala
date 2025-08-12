package catseffect.lectures.part2effects

import cats.effect.IO

object IOIntroduction {
  def sequenceTakeFirst[A, B](ioa: IO[A], iob: IO[B]): IO[A] =
    ioa.flatMap(_ => ioa)

  def sequenceTakeFirst_v2[A, B](ioa: IO[A], iob: IO[B]): IO[A] =
    ioa <* iob

  def sequenceTakeLast[A, B](ioa: IO[A], iob: IO[B]): IO[B] =
    ioa.flatMap(_ => iob)

  def sequenceTakeLast_v2[A, B](ioa: IO[A], iob: IO[B]): IO[B] = {
    ioa *> iob
  }

  def sequenceTakeLast_v3[A, B](ioa: IO[A], iob: IO[B]): IO[B] = {
    ioa >> iob
  }

  def forever[A](io: IO[A]): IO[A] =
    io.flatMap(_ => forever(io))

  def forever_v2[A](io: IO[A]): IO[A] =
    io >> forever(io)

  // Eager evaluation, which might cause a stack overflow
  def forever_v3[A](io: IO[A]): IO[A] =
    io *> forever(io)

  def convert[A, B](ioa: IO[A], value: B): IO[B] =
    ioa.map(_ => value)

  def convert_v2[A, B](ioa: IO[A], value: B): IO[B] =
    ioa.as(value)

  def asUnit[A](ioa: IO[A]): IO[Unit] =
    ioa.map(_ => ())

  def asUnit_v2[A](ioa: IO[A]): IO[Unit] =
    ioa.as(())

  def asUnit_v3[A](ioa: IO[A]): IO[Unit] =
    ioa.void

  def asUnit_v4[A](ioa: IO[A]): IO[Unit] =
    ioa.as[Unit]()

  def sumIO(n: Int): IO[Int] =
    if (n <= 0) IO(0)
    else for {
      lastNumber <- IO(n)
      prevSum <- sumIO(n - 1)
    } yield prevSum + lastNumber

  def fibonacci(n: Int): IO[BigInt] =
    if (n < 2) IO(1)
    else for {
      last <- IO(fibonacci(n - 1)).flatMap(x => x)
      prev <- IO(fibonacci(n - 2)).flatMap(x => x)
    } yield last + prev

  def fibonacci_v2(n: Int): IO[BigInt] =
    if (n < 2) IO(1)
    else for {
      last <- IO.defer(fibonacci(n - 1))
      prev <- IO.defer(fibonacci(n - 2))
    } yield last + prev

  def main(args: Array[String]): Unit = {
    import cats.effect.unsafe.implicits.global

    println(fibonacci_v2(8).unsafeRunSync())
  }
}

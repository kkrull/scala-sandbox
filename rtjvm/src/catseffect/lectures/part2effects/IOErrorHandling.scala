package catseffect.lectures.part2effects

import cats.effect.IO

import scala.util.{Failure, Success, Try}

object IOErrorHandling {

  // Create failed effects
  val aFailedCompute: IO[Int] = IO.delay(throw new RuntimeException("bang!"))
  val aFailure: IO[Int] = IO.raiseError(new RuntimeException("proper failure"))

  // handle exceptions
  val dealWithIt = aFailure.handleErrorWith {
    case _: RuntimeException => IO.delay(println("I'm still here"))
  }

  // turn it into an Either
  val effectAsEither: IO[Either[Throwable, Int]] = aFailure.attempt
  val resultAsString = aFailure.redeem(ex => s"FAIL: ${ex}", value => s"SUCCESS: ${value}")
  val resultAsEffect = aFailure.redeemWith(
    ex => IO(println(s"FAIL: $ex")),
    value => IO(println(s"SUCCESS: $value"))
  )

  /* Exercises */

  // 1 - construct failed IOs from standard types: Option, Try, Either

  def option2IO[A](option: Option[A])(ifEmpty: Throwable): IO[A] =
    option match {
      case None => IO.raiseError[A](ifEmpty)
      case Some(value) => IO.pure(value)
    }

  def option2IO_v2[A](option: Option[A])(ifEmpty: Throwable): IO[A] =
    IO.fromOption(option)(ifEmpty)

  def try2IO[A](aTry: Try[A]): IO[A] =
    aTry match {
      case Success(value) => IO.pure(value)
      case Failure(exception) => IO.raiseError[A](exception)
    }

  def try2IO_v2[A](aTry: Try[A]): IO[A] =
    IO.fromTry(aTry)

  def either2IO[A](anEither: Either[Throwable, A]): IO[A] =
    anEither match {
      case Left(error) => IO.raiseError[A](error)
      case Right(value) => IO.pure(value)
    }

  def either2IO_v2[A](anEither: Either[Throwable, A]): IO[A] =
    IO.fromEither(anEither)

  // 2 - handleError, with (using APIs we have seen so far)

  def handleIOError[A](io: IO[A])(handler: Throwable => A): IO[A] =
    io.redeem(handler, identity)

  def handleIOErrorWith[A](io: IO[A])(handler: Throwable => IO[A]): IO[A] =
    io.redeemWith(handler, IO.pure)

  def main(args: Array[String]): Unit = {
    import cats.effect.unsafe.implicits.global
    println(resultAsEffect.unsafeRunSync())
  }
}

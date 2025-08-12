package catseffect.lectures.part2effects

import cats.Parallel
import cats.effect.{IO, IOApp}

object IOParallelism extends IOApp.Simple {
  val aniIO = IO(s"[${Thread.currentThread().getName}] Ani")
  val kamranIO = IO(s"[${Thread.currentThread().getName}] Kamran")

  val composedIO = for {
    ani <- aniIO
    kamran <- kamranIO
  } yield s"$ani and $kamran do their thing"

  import utils._
  val meaningOfLife: IO[Int] = IO.delay(42)
  val favLang: IO[String] = IO.delay("Scala")

  // Run sequentially

  import cats.syntax.apply._
  val goalInLife = (meaningOfLife, favLang).mapN((num, string) => s"My goal in life is $num and $string")

  // Define parallel IOs

  val parIO1: IO.Par[Int] = Parallel[IO].parallel(meaningOfLife.debug)
  val parIO2: IO.Par[String] = Parallel[IO].parallel(favLang.debug)
  import cats.effect.implicits._
  val goalInLifePar: IO.Par[String] = (parIO1, parIO2).mapN((num, string) => s"My goal in life is $num and $string")

  // Convert back to sequential so we can run it
  val goalInLife_v2 = Parallel[IO].sequential(goalInLifePar)

  // Do it all in one

  import cats.syntax.parallel._
  val goalInLife_v3: IO[String] = (meaningOfLife.debug, favLang.debug).parMapN((num, string) => s"I says mah goal in life is $num and $string")

  // Make it fail

  val aFailure: IO[String] = IO.raiseError(new RuntimeException("bang!"))
  val parallelWithFailure = (meaningOfLife.debug, aFailure.debug).parMapN(_ + _)

  val anotherFailure = IO.raiseError[String](new RuntimeException("boom!"))
  val twoFailures: IO[String] = (aFailure.debug, anotherFailure.debug).parMapN(_ + _)
  val twoFailuresDelayed: IO[String] = (
    IO(Thread.sleep(1000)) >> aFailure.debug,
    anotherFailure.debug
  ).parMapN(_ + _)

  override def run: IO[Unit] =
    twoFailuresDelayed.debug.void
}

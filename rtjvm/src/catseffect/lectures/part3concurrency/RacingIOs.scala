package catseffect.lectures.part3concurrency
import cats.effect.{IO, IOApp}

import scala.concurrent.duration.{DurationInt, FiniteDuration}

object RacingIOs extends IOApp.Simple {
  import catseffect.utils._

  def runWithSleep[A](value: A, duration: FiniteDuration): IO[A] =
    (IO(s"Starting computation").debug >>
      IO.sleep(duration) >>
      IO(s"Computation done: $value").debug >>
      IO.pure[A](value))
      .onCancel(IO(s"Computation cancelled: $value").debug.void)

  def testRace() = {
    val meaningOfLife = runWithSleep(42, 1.second)
    val favoriteLanguage = runWithSleep("Scala", 2.seconds)
    val first: IO[Either[Int, String]] = IO.race(meaningOfLife, favoriteLanguage)
    first.flatMap {
      case Left(meaning)   => IO(s"Meaning of life: $meaning")
      case Right(language) => IO(s"Favorite language: $language")
    }
  }

//  def timeout[A](io: IO[A], duration: FiniteDuration): IO[A] = {
//    IO.race(io, IO.sleep(duration)).flatMap {
//      case Left()
//    }
//  }

  override def run() = testRace.debug.void
}

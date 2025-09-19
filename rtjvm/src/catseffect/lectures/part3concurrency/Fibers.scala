package catseffect.lectures.part3concurrency
import cats.effect.kernel.Outcome.{Canceled, Errored, Succeeded}
import cats.effect.{Fiber, IO, IOApp}

import scala.concurrent.duration.DurationInt

object Fibers extends IOApp.Simple {
  val meaningOfLife = IO.pure(42)
  val favLang = IO.pure("Scala")

  import catseffect.utils._
  def sameThreadIOs = for {
    _ <- meaningOfLife.debug
    _ <- favLang.debug
  } yield ()

  val aFiber: IO[Fiber[IO, Throwable, Int]] = meaningOfLife.debug.start

  def differentThreadIOs = for {
    _ <- aFiber
    _ <- favLang.debug
  } yield ()

  // join a fiber
  def runOnSomeOtherThread[A](io: IO[A]) = for {
    theFiber <- io.start
    result <- theFiber.join
  } yield result

  val someIOOnAnotherThread = runOnSomeOtherThread(meaningOfLife)
  val someResultFromAnotherThread = someIOOnAnotherThread.flatMap {
    case Canceled()     => IO(0)
    case Errored(error) => IO(0)
    case Succeeded(fa)  => fa
  }

  def throwOnSomeOtherThread() = for {
    theFiber <- IO.raiseError[Int](new RuntimeException("it was programmed to fail")).start
    result <- theFiber.join
  } yield result

  def testCancel() = {
    val task = IO("starting").debug >> IO.sleep(1.second) >> IO("done").debug
    val taskWithCancellationHandler = task.onCancel(IO("this fiber was cancelled").debug.void)

    for {
      theFiber <- taskWithCancellationHandler.start
      _ <- IO.sleep(500.millis) >> IO("cancelling").debug
      _ <- theFiber.cancel
      result <- theFiber.join
    } yield result
  }

  override def run: IO[Unit] = testCancel.debug.void
}

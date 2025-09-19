package catseffect.lectures.part3concurrency
import cats.effect.{IO, IOApp}

import scala.concurrent.duration.DurationInt

object Resources extends IOApp.Simple {
  import catseffect.utils._

  class Connection(url: String) {
    def open(): IO[String] = IO(s"Opening connection to $url").debug
    def close(): IO[String] = IO(s"Closing connection to $url").debug
  }

  val asyncFetchUrlWithResourceLeak = for {
    theFiber <- (new Connection("rockthejvm.com").open() *> IO.never).start
    _ <- IO.sleep(1.second) *> theFiber.cancel
  } yield ()

  val asyncFetchUrl = for {
    conn <- IO(new Connection("rockthejvm.com"))
    theFiber <- (conn.open() *> IO.never).onCancel(conn.close().void).start
    _ <- IO.sleep(1.second) *> theFiber.cancel
  } yield ()

  // bracket pattern
  
  val bracketFetchUrl = IO(new Connection("rockthejvm.com"))
    .bracket(conn => conn.open() *> IO.never)(conn => conn.close().void)

  val bracketProgram = for {
    theFiber <- bracketFetchUrl.start
    _ <- IO.sleep(1.second) *> theFiber.cancel
  } yield ()

  override def run: IO[Unit] = bracketProgram.void
}

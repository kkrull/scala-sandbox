package catseffect.lectures.part2effects

import java.time.Instant
import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, ExecutionContext, Future}

object Effects {
  case class MyIO[A](unsafeRun: () => A) {
    def awaitResult(timeout: Duration)(implicit ec: ExecutionContext): Unit = {
      val result = Future[A] { unsafeRun() }
      Await.result(result, timeout)
    }

    def map[B](f: A => B): MyIO[B] =
      MyIO(() => f(unsafeRun()))

    def flatMap[B](f: A => MyIO[B]): MyIO[B] =
      MyIO(() => f(unsafeRun()).unsafeRun())
  }

  import scala.concurrent.ExecutionContext.global

  def main(args: Array[String]): Unit = {
    implicit val ec = global
    println(s"Hello world!")
    MyIO(() => Instant.now())
      .map(_.toEpochMilli)
      .map(x => {
        println(s"Current time: ${x}ms")
        x
      })
      .awaitResult(1.seconds)
  }
}

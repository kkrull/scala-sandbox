package catseffect.lectures.part2effects

import cats.Traverse
import cats.effect.{IO, IOApp}
import cats.implicits.toTraverseOps
import utils._

import scala.concurrent.Future
import scala.util.Random

object IOTraversal extends IOApp.Simple {

  import scala.concurrent.ExecutionContext.Implicits.global

  def heavyComputation(string: String): Future[Int] = Future {
    Thread.sleep(Random.nextInt(1000))
    string.split(" ").length
  }

  val workLoad: List[String] = List("rock your socks off", "less talk, more rock", "holy guacamole")

  def clunkyFutures(): Unit = {
    val futures: List[Future[Int]] = workLoad.map(heavyComputation)
    futures.foreach(_.foreach(println))
  }

  import cats.instances.list._
  val listTraverse = Traverse[List]

  def traverseFutures(): Unit = {
    val singleFuture: Future[List[Int]] = listTraverse.traverse(workLoad)(heavyComputation)
    singleFuture.foreach(println)
  }

  def computeAsIO(string: String): IO[Int] = IO {
    Thread.sleep(Random.nextInt(1000))
    string.split(" ").length
  }.debug

  val ios: List[IO[Int]] = workLoad.map(computeAsIO)
  val singleIO: IO[List[Int]] = listTraverse.traverse(workLoad)(computeAsIO)

  import cats.syntax.parallel._
  val parallelSingleIO: IO[List[Int]] = workLoad.parTraverse(computeAsIO)

  /* Exercises */

  def sequence[A](listOfIOs: List[IO[A]]): IO[List[A]] =
    listOfIOs.traverse(identity)

  def sequence_v2[F[_]: Traverse, A](containerOfIOs: F[IO[A]]): IO[F[A]] =
    containerOfIOs.traverse(identity)

  override def run: IO[Unit] =
    parallelSingleIO.map(_.sum).debug.void
}

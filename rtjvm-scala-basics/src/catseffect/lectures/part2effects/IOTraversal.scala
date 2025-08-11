package catseffect.lectures.part2effects

import cats.Traverse
import cats.effect.{IO, IOApp}

import scala.concurrent.Future
import scala.util.Random

object IOTraversal extends IOApp.Simple {

  import scala.concurrent.ExecutionContext.Implicits.global
  val workLoad: List[String] = List("rock your socks off", "less talk, more rock", "holy guacamole")

  def heavyComputation(string: String): Future[Int] = Future {
    Thread.sleep(Random.nextInt(1000))
    string.split(" ").length
  }

  def clunkyFutures(): Unit = {
    val futures: List[Future[Int]] = workLoad.map(heavyComputation)
    futures.foreach(_.foreach(println))
  }

  def traverseFutures(): Unit = {
    import cats.instances.list._
    val listTraverse = Traverse[List]
    val singleFuture: Future[List[Int]] = listTraverse.traverse(workLoad)(heavyComputation)
    singleFuture.foreach(println)
  }



  override def run: IO[Unit] = ???
}

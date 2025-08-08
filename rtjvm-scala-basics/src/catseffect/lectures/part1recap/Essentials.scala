package catseffect.lectures.part1recap

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object Essentials {
  val incrementer: Int => Int = x => x + 1

  implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(8))

  def main(args: Array[String]): Unit = {
    println(s"Hello World!")

    val answer = Future { 42 }
    answer.onComplete {
      case Success(value) => println(s"Received answer: ${value}")
      case Failure(exception) => println(s"Failed with exception: ${exception}")
    }
  }
}

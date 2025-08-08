package catseffect.lectures.part1recap

import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext

object Essentials {
  val incrementer: Int => Int = x => x + 1

  implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(8))

  def main(args: Array[String]): Unit = {
    println(s"Hello World!")
  }
}

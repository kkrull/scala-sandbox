package catseffect.lectures.part2effects

import cats.effect.IO

object IOErrorHandling {

  val aFailedCompute: IO[Int] = IO.delay(throw new RuntimeException("bang!"))

  def main(args: Array[String]): Unit = {
    import cats.effect.unsafe.implicits.global
    aFailedCompute.unsafeRunSync()
  }
}

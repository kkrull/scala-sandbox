package com.github.kkrull.cats

import cats.implicits.catsSyntaxOptionId

object CatsMain extends App {
  println(s"Hello world!")

  val answer = 42
  val scalaOption = Some(answer)
  println(s"scalaOption: ${scalaOption}")

  val catsOption = answer.some
  println(s"catsOption: ${catsOption}")
}

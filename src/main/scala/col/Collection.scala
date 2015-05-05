package com.github.kkrull.scala.col

object Collection {
  //def old_indexes(input: String): Map[Char, Set[Int]] = {
  //  val characterIndexes = input.zipWithIndex
  //  val init: Map[Char, Set[Int]] = Map()
  //  characterIndexes.foldLeft(init)((acc: Map[Char, Set[Int]], x: (Char, Int)) => {
  //    val ch = x._1
  //    val index = x._2
  //    val indexSet = acc.getOrElseUpdate(ch, Set[Int]())
  //    indexSet += index

  //    acc
  //  })
  //  //Map('a' -> Set(0, 1))
  //}

  def indexes(input: String): Map[Char, Set[Int]] = {
    val characterIndexes = input.zipWithIndex
    val init: Map[Char, Set[Int]] = Map()
    characterIndexes.foldLeft(init)((acc: Map[Char, Set[Int]], x: (Char, Int)) => {
      val indexSet = acc.getOrElse(x._1, Set[Int]())
      acc ++ Map(x._1 -> (indexSet ++ Set(x._2)))
    })
  }
}

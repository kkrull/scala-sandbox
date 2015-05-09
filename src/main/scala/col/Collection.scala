package com.github.kkrull.scala.col

object MutableCollection {
  import scala.collection.mutable._

  def indexes(input: String): Map[Char, Set[Int]] = {
    val characterIndexes = input.zipWithIndex
    val init: Map[Char, Set[Int]] = Map()
    characterIndexes.foldLeft(init)((acc: Map[Char, Set[Int]], x: (Char, Int)) => {
      val ch = x._1
      val index = x._2
      val indexSet = acc.getOrElseUpdate(ch, Set[Int]())
      indexSet += index

      acc
    })
  }
}

object ImmutableCollection {
  def indexes(input: String): Map[Char, Set[Int]] = {
    input.zipWithIndex.foldLeft(Map[Char, Set[Int]]()) ((acc: Map[Char, Set[Int]], x: (Char, Int)) => {
      val char = x._1
      val indices = acc.getOrElse(char, Set[Int]()) + x._2
      acc ++ Map(char -> indices)
    })
  }

  def removeZeros(input: List[Int]) = input.foldRight(List[Int]())((x, acc) => if(x == 0) acc else x :: acc)

  def indexWords(words: Array[String], index: Map[String, Int]): Array[Int] = {
    def buildIndex(remaining: Array[String], output: Array[Int]): Array[Int] = {
      val indexed = if(remaining.isEmpty) None else index.get(remaining(0))
      if(remaining.isEmpty)
        output
      else if(!indexed.isDefined)
        buildIndex(remaining.tail, output)
      else
        buildIndex(remaining.tail, output ++ Array(indexed.get))
    }

    buildIndex(words, Array())
  }
}

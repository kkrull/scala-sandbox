package com.github.kkrull.scala.col

object MutableCollection {
  import scala.collection.mutable._

  def indexes(input: String): Map[Char, Set[Int]] = {
    val mapping: Map[Char, Set[Int]] = Map()
    input.zipWithIndex.foreach(x => mapping.getOrElseUpdate(x._1, Set[Int]()) += x._2)
    mapping 
  }
}

object ImmutableCollection {
  def indexes(input: String): Map[Char, Set[Int]] = {
    input.zipWithIndex.foldLeft(Map[Char, Set[Int]]()) ((acc, x) => {
      val char = x._1
      val indices = acc.getOrElse(char, Set[Int]()) + x._2
      acc ++ Map(char -> indices)
    })
  }

  def removeZeros(input: List[Int]) = input.foldRight(List[Int]())((x, acc) => if(x == 0) acc else x :: acc)

  def indexWords(words: Array[String], index: Map[String, Int]): Array[Int] = {
    words.foldLeft(Array[Int]())((acc, word) => {
      val indexed = index.get(word)
      if(indexed.isDefined) acc ++ Array(indexed.get) else acc
    })
  }
  
  def indexWordsRecursive(words: Array[String], index: Map[String, Int]): Array[Int] = {
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

package com.github.kkrull.scala.hof

/** Higher-order functions */
object Hof {
  def values(f: (Int) => Int, from: Int, to: Int): Seq[(Int, Int)] = {
    val input = from.to(to)
    val output = input.map(f)
    input.zip(output)
  }

  def old_values(f: (Int) => Int, from: Int, to: Int): Seq[(Int, Int)] = {
    if(from > to)
      throw new InvalidRangeException(from, to)

    val input = from.to(to)
    input.zip(input.map(f))
  }

  def largestValue(arr: Array[Int]): Int = arr.reduceLeft(Math.max)

  def fact(n: Int) = {
    if(n < 0) None
    else if(n == 0) Some(1)
    else Some((1 to n).reduceLeft(_ * _))
  }

  def factFold(n: Int): Int = {
    (1 to n).foldLeft(1)( _ * _ )
  }

  def largest(f: (Int) => Int, inputs: Seq[Int]): Option[Int] = {
    if(inputs.isEmpty) None
    else
      Some(largestValue(inputs.toArray.map(f)))
  }

  def largestAt(f: (Int) => Int, inputs: Seq[Int]) = {
    def maxTuple = (acc: (Int, Int), x: (Int, Int)) => if(x._1 > acc._1) x else acc

    val outputs = inputs.map(f)
    val greatestTuple = outputs.zipWithIndex.reduceLeft(maxTuple)
    inputs(greatestTuple._2)
  }

  class InvalidRangeException(from: Int, to: Int)
    extends RuntimeException("from value %d is greater than to value %d".format(from, to))
    { /* empty */ }
}

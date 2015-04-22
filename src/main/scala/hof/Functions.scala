package com.github.kkrull.scala.hof

/** Higher-order functions */
object Hof {
  def values(f: (Int) => Int, from: Int, to: Int): Seq[(Int, Int)] = {
    if(from > to)
      throw new InvalidRangeException(from, to)

    val input = from.to(to)
    input.zip(input.map(f))
  }

  def largestValue(arr: Array[Int]): Int = arr.reduceLeft((acc: Int, x: Int) => Math.max(acc, x))

  def fact(n: Int): Int = {
    if(n == 0) 
      1
    else
      (1 to n).reduceLeft((acc: Int, x: Int) => acc * x)
  }

  def factFold(n: Int): Int = {
    (1 to n).foldLeft(1) { (acc, x) => acc * x }
  }

  def largest(f: (Int) => Int, inputs: Seq[Int]): Option[Int] = {
    if(inputs.isEmpty)
      None
    else 
      Some(inputs.map(f).reduceLeft(Math.max))
  }

  class InvalidRangeException(from: Int, to: Int) 
    extends RuntimeException("from value %d is greater than to value %d".format(from, to)) 
    { /* empty */ }
}

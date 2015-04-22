package com.github.kkrull.scala.hof

/** Higher-order functions */
object Hof {
  def values(f: (Int) => Int, from: Int, to: Int): Seq[(Int, Int)] = {
    if(from > to)
      throw new InvalidRangeException(from, to)

    val input = from.to(to)
    input.zip(input.map(f))
  }

  def largest(arr: Array[Int]): Int = arr.reduceLeft((acc: Int, x: Int) => Math.max(acc, x))

  class InvalidRangeException(from: Int, to: Int) 
    extends RuntimeException("from value %d is greater than to value %d".format(from, to)) 
    { /* empty */ }
}

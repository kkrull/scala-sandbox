package com.github.kkrull.scala.pm

//Chapter 14
object PatternMatching {
  def swapTuple[A, B](pair: (A, B)): (B, A) = pair match { case (a, b) => (b, a) }

  def swapArray(array: Array[Int]) = array match { 
    case Array(a: Int, b: Int, rest @ _*) => Array(b, a) ++ rest 
  }
}


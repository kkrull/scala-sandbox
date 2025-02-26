package com.github.kkrull.scala.pm

//Chapter 14
object PatternMatching {
  def swapTuple(pair: (Int, Int)): (Int, Int) = {
    pair match { case (a, b) => (b, a) }
  }

  def swapArray(array: Array[Int]) = array match {
    case Array(a: Int, b: Int, rest @ _*) => Array(b, a) ++ rest
  }
}

abstract class Item {
  def price: Double
}

case class Product(description: String, price: Double) extends Item
case class Multiple(count: Int, item: Item) extends Item {
  def price = count * item.price
}

abstract class BinaryTree {
  def sum: Int
}

case class Leaf(value: Int) extends BinaryTree {
  def sum = value
}

case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree {
  def sum = left.sum + right.sum
}


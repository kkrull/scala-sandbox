package com.github.kkrull.scala.pm

import scala.collection
import org.scalatest._

//Chapter 14
class PatternMatchingSpec extends FunSpec with Matchers {
  describe(".swapTuple") {
    it("swaps the position of the given values") {
      PatternMatching.swapTuple((1, 2)) should equal((2, 1))
    }
  }

  describe(".swapArray") {
    describe("given null") {
      it("raises MatchError") {
        intercept[MatchError] { PatternMatching.swapArray(null) }
      }
    }

    describe("given an array with fewer than 2 elements") {
      it("raises MatchError") {
        intercept[MatchError] { PatternMatching.swapArray(Array(1)) }
      }
    }

    describe("given an array with 2 or more elements") {
      it("swaps the first two elements") {
        PatternMatching.swapArray(Array(1, 2, 3)) should equal(Array(2, 1, 3))
      }
    }
  }

  describe("Multiple") {
    it("is a valid scala case class") {
      Multiple(2, Product("Toaster", 29.95))
    }

    describe(".price") {
      it("multitplies the count by the unit price") {
        val items = Multiple(2, Product("Toaster", 20))
        items.price should equal(40)
      }
    }
  }

  describe("BinaryTree") {
    it("has leaves") {
      val leaf = Leaf(1)
    }

    it("has nodes with 2 children") {
      val node = Node(Leaf(1), Leaf(2))
    }

    describe(".sum") {
      describe("given a Leaf") {
        it("returns that leaf's value") {
          val leaf = Leaf(42)
          leaf.sum should equal(42)
        }
      }

      describe("given a node") {
        it("returns the sum of the left and right subtrees") {
          val node = Node(
            Node(Leaf(1), Leaf(2)),
            Node(Leaf(3), Leaf(4)))
          node.sum should equal(10)
        }
      }
    }
  }
}


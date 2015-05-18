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
}


package com.github.kkrull.scala.hof
import org.scalatest._

//Chapter 12
class FunctionSpec extends FunSpec with Matchers {
  //Problem 1
  describe(".values") {
    describe("given a from > to") {
      it("raises an error") {
        the [Hof.InvalidRangeException] thrownBy { Hof.values(x => x, 2, 1) } should 
          have message("from value 2 is greater than to value 1")
      }
    }

    describe("given from <= to") {
      it("returns a sequence containing of the given function applied to the specified range of input values") {
        Hof.values(x => x * x, 1, 2).toList should equal(List(
          (1, 1),
          (2, 4)
        ))
      }
    }
  }

  //Problem 2
  describe(".largestValue") {
    it("returns the largest value in the given array") {
      Hof.largestValue(Array(3, 1, 4)) should equal(4)
    }
  }

  //Problem 3
  describe(".fact") {
    describe("given 0") {
      it("returns 1") { Hof.fact(0) should equal(1) }
    }

    describe("given n > 0") { 
      it("returns the result of multiplying the sequence of values 1..n") { Hof.fact(3) should equal(6) } 
    }
  }

  //Problem 4
  describe(".factFold") {
    describe("given 0") {
      it("returns 1") { Hof.factFold(0) should equal(1) }
    }

    describe("given n > 0") { 
      it("returns the result of multiplying the sequence of values 1..n") { Hof.factFold(3) should equal(6) } 
    }
  }

  //Problem 5
  describe(".largest") {
    describe("given an empty sequence") {
      it("returns None") {
        Hof.largest((x: Int) => x, 1 to 0) should equal(None)
      }
    }

    describe("given a non-empty sequence") {
      it("returns the largest result of the given function when applied to the given inputs") {
        Hof.largest((x: Int) => 10 * x - x * x, 1 to 10) should equal(Some(25))
      }
    }
  }

  //Problem 6
  describe(".largestAt") {
    describe("given an empty sequence") {
      it("returns None") {
        Hof.largestAt((x: Int) => x*x, List(1, 2, 3)) should equal(None)
      }
    }

    describe("given a sequence of all the same output value") {
      it("returns the index of the first such value") {
        Hof.largestAt((x: Int) => 42, List(1, 2, 3)) should equal(Some(0))
      }
    }

    describe("given a sequence of different output values") {
      it("returns the first index of the largest output value") {
        pending
      }
    }
  }
}

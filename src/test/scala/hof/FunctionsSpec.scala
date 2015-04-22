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
  describe(".largest") {
    it("returns the largest value in the given array") {
      Hof.largest(Array(3, 1, 4)) should equal(4)
    }
  }

  //Problem 3
  describe(".factorial") {
    it("returns the result of multiplying the sequence of values 1..n") {
      pending
    }
  }
}

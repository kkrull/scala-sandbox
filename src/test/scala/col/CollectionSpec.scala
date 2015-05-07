package com.github.kkrull.scala.col
import org.scalatest._

//Chapter 13
class MutableCollectionSpec extends FunSpec with Matchers {
  describe(".indexes") {
    describe("given a string") {
      it("returns a mapping of characters in the string to the indices at which they appear") {
        MutableCollection.indexes("abca") should equal(Map(
          'a' -> Set(0, 3), 
          'b' -> Set(1), 
          'c' -> Set(2)
        ))
      }
    }
  }
}

class ImmutableCollectionSpec extends FunSpec with Matchers {
  describe(".indexes") {
    describe("given an empty string") {
      it("returns an empty map") {
        ImmutableCollection.indexes("") should equal(Map())
      }
    }

    describe("given a string") {
      it("returns a mapping of characters in the string to the indices at which they appear") {
        ImmutableCollection.indexes("aba") should equal(Map(
          'a' -> Set(0, 2),
          'b' -> Set(1)
        ))
      }
    }
  }
}

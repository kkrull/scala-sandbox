package com.github.kkrull.scala.col
import org.scalatest._

//Chapter 13
class MutableCollectionSpec extends FunSpec with Matchers {
  describe(".indexes") {
    describe("given a string") {
      it("returns a collection index(es) for each character that appears in the string") {
        val index = Map('a' -> Set(0, 3), 'b' -> Set(1), 'c' -> Set(2))
        MutableCollection.indexes("abca") should equal(index)
      }
    }
  }
}

trait GreeterBehaviors { this: FunSpec =>
  def aGreeter(fn: (String) => String) {
    it("exists") {
      fn("bob") should equal("Hello, bob")
    }
  }
}

class ImmutableCollectionSpec extends FunSpec with Matchers {
  describe("indexes") {
    it("exists") {
      ImmutableCollection.indexes
    }
  }
}

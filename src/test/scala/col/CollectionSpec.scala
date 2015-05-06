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

class ImmutableCollectionSpec extends FunSpec with GreeterBehaviors with Matchers {
  it should behave like aGreeter(() => "Hello, world")
}

trait GreeterBehaviors { this: FunSpec with Matchers =>
  def aGreeter(fn: () => String) {
    it("exists") {
      fn() should equal("Hello, world")
    }
  }
}


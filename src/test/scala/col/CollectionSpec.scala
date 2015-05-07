package com.github.kkrull.scala.col
import org.scalatest._

//Chapter 13
class MutableCollectionSpec extends FunSpec with IndexerBehavior with Matchers {
  describe(".indexes") {
    it should behave like anIndexer(MutableCollection.indexes)
    describe("given a string") {
      it("returns a collection index(es) for each character that appears in the string") {
        val index = Map('a' -> Set(0, 3), 'b' -> Set(1), 'c' -> Set(2))
        MutableCollection.indexes("abca") should equal(index)
      }
    }
  }
}

class ImmutableCollectionSpec extends FunSpec with IndexerBehavior with Matchers {
  //it should behave like anIndexer()
}

trait IndexerBehavior { this: FunSpec with Matchers =>
  def anIndexer(fn: (String) => Map[Char, Set[Int]]) {
    describe("given a string") {
      it("returns a collection index(es) for each character that appears in the string") {
        val index = Map('a' -> Set(0, 3), 'b' -> Set(1), 'c' -> Set(2))
        MutableCollection.indexes("abca") should equal(index)
      }
    }
  }
}

trait GreeterBehaviors { this: FunSpec with Matchers =>
  def aGreeter(greetingForName: (String) => String) {
    it("starts with 1 or more words of greeting") {
      greetingForName("George") should fullyMatch regex """([^\s]+\s)+George"""
    }
    it("end with the given name") {
      greetingForName("World") should endWith("World")
    }
  }
}


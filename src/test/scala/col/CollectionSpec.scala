package com.github.kkrull.scala.col

import scala.collection
import org.scalatest._

//Chapter 13
class MutableCollectionSpec extends FunSpec with IndexerBehaviors with Matchers {
  describe(".indexes") {
    it should behave like anIndexer(MutableCollection.indexes)
  }
}

class ImmutableCollectionSpec extends FunSpec with IndexerBehaviors with Matchers {
  describe(".indexes") {
    it should behave like anIndexer(ImmutableCollection.indexes)
  }
}

trait IndexerBehaviors { this: FunSpec with Matchers =>
  def anIndexer(doIndex: (String) => collection.Map[Char, collection.Set[Int]]) = {
    it("can be invoked") { doIndex("wark!") }

    describe("given an empty string") {
      it("returns an empty map") {
        doIndex("") should equal(Map())
      }
    }

    describe("given a string") {
      it("returns a mapping of characters in the string to the indices at which they appear") {
        doIndex("abca") should equal(Map(
          'a' -> Set(0, 3), 
          'b' -> Set(1), 
          'c' -> Set(2)
        ))
      }
    }
  }
}


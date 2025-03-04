package collection

import scala.collection.mutable
import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

class SetSpec extends AnyFunSpec with Matchers {
  describe("Set") {
    it("refers to the immutable variety, by default") {
      val one = Set(1, 2)
      val other = one + 3
      other shouldEqual(Set(1, 2, 3))
      one shouldEqual(Set(1, 2))
    }
  }

  describe("mutable.Set") {
    it("is a mutable variety of the Set trait") {
      val set = mutable.Set(1, 2)
      set += 3
      set shouldEqual(Set(1, 2, 3))
    }
  }
}

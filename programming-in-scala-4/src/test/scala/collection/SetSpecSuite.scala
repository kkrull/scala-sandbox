package collection

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
}

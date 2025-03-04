package collection

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

class ListSpec extends AnyFunSpec with Matchers {
  describe("List") {
    it(":: (cons) is right-associative") {
      val result = 1 :: List(2)
      result shouldEqual(List(1, 2))
    }
  }
}

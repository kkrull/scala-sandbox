package roman

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

object RomanNumeral {
  def convert(number: Int): String = {
    "bogus"
  }
}

class RomanNumeralSpecSuite extends AnyFunSpec with Matchers {
  describe("RomanNumeral") {
    describe("convert") {
      it("should exist") {
        "RomanNumeral.convert(1)" should compile
      }
    }
  }
}

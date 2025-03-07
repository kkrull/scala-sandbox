package roman

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

class RomanNumeralSpecSuite extends AnyFunSpec with Matchers {
  describe("RomanNumeral") {
    describe("convert") {
      it("should convert 1 to I") {
        RomanNumeral.convert(1) shouldEqual "I"
      }

      it("should convert 5 to V") {
        RomanNumeral.convert(5) shouldEqual "V"
      }

      it("should increment I by appending I") {
        RomanNumeral.convert(2) shouldEqual "II"
      }

      it("should increment V by appending I") {
        RomanNumeral.convert(6) shouldEqual "VI"
      }
    }
  }
}

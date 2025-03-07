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

      it("should convert 10 to X") {
        RomanNumeral.convert(10) shouldEqual "X"
      }

      it("should convert 50 to L") {
        RomanNumeral.convert(50) shouldEqual "L"
      }

      it("should increment 1 by appending one or more I's to I") {
        RomanNumeral.convert(2) shouldEqual "II"
        RomanNumeral.convert(3) shouldEqual "III"
      }

      it("should decrement 5 by prepending up to one I to V") {
        RomanNumeral.convert(4) shouldEqual "IV"
      }

      it("should increment 5 by appending one or more I's to V") {
        RomanNumeral.convert(6) shouldEqual "VI"
      }

      it("should decrement 10 by prepending up to one I to X") {
        RomanNumeral.convert(9) shouldEqual "IX"
      }

      it("should increment 10 by appending one or more I's to X") {
        RomanNumeral.convert(11) shouldEqual "XI"
      }

      it("should increase 10 by 5 or more by appending V") {
        RomanNumeral.convert(15) shouldEqual "XV"
        RomanNumeral.convert(16) shouldEqual "XVI"
      }

      ignore("should decrease 50 by 5 by prepending V") {
        RomanNumeral.convert(45) shouldEqual "VL"
      }

      ignore("should decrease 50 by 10 by prepending X") {
        RomanNumeral.convert(40) shouldEqual "XL"
      }
    }
  }
}

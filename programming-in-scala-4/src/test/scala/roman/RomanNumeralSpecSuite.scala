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

      it("should increment 1 by appending one or more I's to I") {
        RomanNumeral.convert(2) shouldEqual "II"
        RomanNumeral.convert(3) shouldEqual "III"
      }

      it("should increment 5 by appending one or more I's to V") {
        RomanNumeral.convert(6) shouldEqual "VI"
      }

      it("should increment 10 by appending one or more I's to X") {
        RomanNumeral.convert(11) shouldEqual "XI"
      }
    }
  }
}

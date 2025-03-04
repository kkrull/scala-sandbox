package roman

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

class RomanNumeralSpecSuite extends AnyFunSpec with Matchers {
  describe("::romanNumeral") {
    it("should convert numbers less than 4 to that many I's") {
      RomanNumeral.convert(1) shouldEqual("I")
      RomanNumeral.convert(2) shouldEqual("II")
      RomanNumeral.convert(3) shouldEqual("III")
    }

    it("should convert 5 to V") {
      RomanNumeral.convert(5) shouldEqual("V")
    }

    it("should append I letters when number is over 5") {
      RomanNumeral.convert(6) shouldEqual("VI")
    }
  }
}

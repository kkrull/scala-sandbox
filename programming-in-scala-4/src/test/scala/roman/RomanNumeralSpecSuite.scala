package roman

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

class RomanNumeralSpecSuite extends AnyFunSpec with Matchers {
  describe("::romanNumeral") {
    it("should return I to represent 1") {
      RomanNumeral.convert(1) shouldEqual("I")
    }

    it("should return V to represent 5") {
      RomanNumeral.convert(5) shouldEqual("V")
    }

    it("should return X to represent 10") {
      RomanNumeral.convert(10) shouldEqual("X")
    }

    it("should return L to represent 50") {
      RomanNumeral.convert(50) shouldEqual("L")
    }

    it("should repeat a letter to get multiples of its value") {
      RomanNumeral.convert(2) shouldEqual("II")
      RomanNumeral.convert(3) shouldEqual("III")
      RomanNumeral.convert(20) shouldEqual("XX")
    }

    it("should append I to add 1 to a letter's value") {
      RomanNumeral.convert(6) shouldEqual("VI")
      RomanNumeral.convert(12) shouldEqual("XII")
    }

    it("should prepend I to subtract 1 from a letter's value") {
      RomanNumeral.convert(4) shouldEqual("IV")
      RomanNumeral.convert(9) shouldEqual("IX")
    }
  }
}

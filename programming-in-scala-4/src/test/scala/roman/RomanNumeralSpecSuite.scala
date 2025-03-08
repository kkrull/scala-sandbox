package roman

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

class RomanNumeralSpecSuite extends AnyFunSpec with Matchers {
  describe("RomanNumeral") {
    describe("convert") {
      it("should convert 1 to I") { RomanNumeral.convert(1) shouldEqual "I" }
      it("should convert 5 to V") { RomanNumeral.convert(5) shouldEqual "V" }
      it("should convert 10 to X") { RomanNumeral.convert(10) shouldEqual "X" }
      it("should convert 50 to L") { RomanNumeral.convert(50) shouldEqual "L" }
      it("should convert 100 to C") { RomanNumeral.convert(100) shouldEqual "C" }
      it("should convert 500 to D") { RomanNumeral.convert(500) shouldEqual "D" }
      it("should convert 1000 to M") { RomanNumeral.convert(1000) shouldEqual "M" }

      it("should increment 1 by appending one or more I's to I") {
        RomanNumeral.convert(2) shouldEqual "II"
        RomanNumeral.convert(3) shouldEqual "III"
      }

      it("should decrease 5 by prepending up to one I to V") {
        RomanNumeral.convert(4) shouldEqual "IV"
      }

      it("should increase 5 by appending one or more I's to V") {
        RomanNumeral.convert(6) shouldEqual "VI"
      }

      it("should decrease 10 by prepending up to one letter of lesser value") {
        RomanNumeral.convert(9) shouldEqual "IX"
      }

      it("should increase 10 by appending one letters of lesser value") {
        RomanNumeral.convert(11) shouldEqual "XI"
        RomanNumeral.convert(15) shouldEqual "XV"
        RomanNumeral.convert(16) shouldEqual "XVI"
      }

      it("should decrease 50 by prepending up to one letter of lesser value") {
        RomanNumeral.convert(45) shouldEqual "VL"
        RomanNumeral.convert(40) shouldEqual "XL"
      }

      it("should decrease 100 by prepending up to one letter of lesser value") {
        RomanNumeral.convert(95) shouldEqual "VC"
        RomanNumeral.convert(90) shouldEqual "XC"
      }

      it("should decrease 500 by prepending up to one letter of lesser value") {
        RomanNumeral.convert(495) shouldEqual "VD"
        RomanNumeral.convert(490) shouldEqual "XD"
        RomanNumeral.convert(450) shouldEqual "LD"
        RomanNumeral.convert(400) shouldEqual "CD"
      }

      it("should decrease 1000 by prepending up to one letter of lesser value") {
        RomanNumeral.convert(995) shouldEqual "VM"
        RomanNumeral.convert(990) shouldEqual "XM"
        RomanNumeral.convert(950) shouldEqual "LM"
        RomanNumeral.convert(900) shouldEqual "CM"
      }

      ignore("should make a suffix out of another pair of letters with a prefix") {}
      ignore("should handle a 4 digit year like you see in movie credits") {
        RomanNumeral.convert(1984) shouldEqual "MCMLXXXIV"
      }
    }
  }
}

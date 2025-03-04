package roman

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

class RomanNumeralSpecSuite extends AnyFunSpec with Matchers {
  describe("::romanNumeral") {
    it("exists") {
      RomanNumeral.convert(1)
    }
  }
}

package com.github.kkrull.scala.ops
import org.scalatest._

class FractionSpec extends FunSpec with Matchers {
  describe("unapply") {
    it("unpacks the parts of the fraction") {
      val Fraction(a, b) = Fraction(1, 2)
      a should equal(1)
      b should equal(2)
    }
  }

  describe("*") {
    val subject = Fraction(2, 7)

    it("multiplies the fractions") {
      val product = subject * Fraction(2, 3)
      product.numerator should equal(4)
      product.denominator should equal(21)
    }
    it("it normalizes sign onto the numerator") {
      val subject = Fraction(2, -3)
      pending
      subject.numerator should equal(-2)
      subject.denominator should equal(3)
    }
    it("it gcds") { pending }
  }
}

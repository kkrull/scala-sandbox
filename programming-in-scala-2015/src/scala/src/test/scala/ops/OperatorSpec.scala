package com.github.kkrull.scala.ops
import org.scalatest._

class FractionSpec extends FunSpec with Matchers {
  describe("::apply") {
    it("it normalizes the sign onto the numerator") {
      shouldReduceTo(Fraction(2, 3), 2, 3)
      shouldReduceTo(Fraction(-2, 3), -2, 3)
      shouldReduceTo(Fraction(2, -3), -2, 3)
      shouldReduceTo(Fraction(-2, -3), 2, 3)
//      shouldReduceTo(Fraction(-4, -2), 2, 1)
    }
    it("it reduces using the greatest common denominator") { 
      shouldReduceTo(Fraction(1, 1), 1, 1)
      shouldReduceTo(Fraction(2, 2), 1, 1)
      shouldReduceTo(Fraction(2, 4), 1, 2)
    }

    def shouldReduceTo(frac: Fraction, n: Int, d: Int): Unit = {
      (frac.numerator, frac.denominator) should equal((n, d))
    }
  }

  describe("::unapply") {
    it("unpacks the parts of the fraction") {
      val Fraction(a, b) = Fraction(1, 2)
      a should equal(1)
      b should equal(2)
    }
  }

  describe(".toString") {
    it("shows the parts of the Fraction") {
      val subject = Fraction(1, 2)
      subject.toString should equal("Fraction(1, 2)")
    }
  }

  describe(".*") {
    it("multiplies the fractions") {
      val Fraction(4, 21) = Fraction(2, 7) * Fraction(2, 3)
    }
  }
}

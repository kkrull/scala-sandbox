package com.github.kkrull.scala.ops
import org.scalatest._

class FractionSpec extends FunSpec with Matchers {
  describe("::apply") {
    //TODO KDK: Is there a way to move this behavior into the constructor?
    it("it normalizes the sign onto the numerator") {
      val Fraction(2, 3) = Fraction(2, 3)
      val Fraction(-2, 3) = Fraction(-2, 3)
      val Fraction(-2, 3) = Fraction(2, -3)
      val Fraction(2, 3) = Fraction(-2, -3)
    }
    it("it gcds") { pending }
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

package com.github.kkrull.scala.ops

object Fraction {
  def apply(numerator: Int, denominator: Int) = {
    val flipSign = if(denominator < 0) -1 else 1
    new Fraction(flipSign * numerator, flipSign * denominator)
  }

  def unapply(x: Fraction): Option[(Int, Int)] = {
    Some((x.numerator, x.denominator))
  }
}

class Fraction(val numerator: Int, val denominator: Int) {
  private def n = numerator
  private def d = denominator

  def *(other: Fraction) = Fraction(this.n * other.n, this.d * other.d)
  override def toString = "Fraction(%d, %d)".format(numerator, denominator)
}

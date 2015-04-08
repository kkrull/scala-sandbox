package com.github.kkrull.scala.ops

object Fraction {
  def apply(numerator: Int, denominator: Int) = new Fraction(numerator, denominator)
  def unapply(x: Fraction): Option[(Int, Int)] = {
    Some((x.numerator, x.denominator))
  }
}

class Fraction(val numerator: Int, val denominator: Int) {
  private def n = numerator
  private def d = denominator

  //TODO KDK: How to have some behavior in the primary constructor, to normalize sign?
  //That logic could be moved to Fraction.apply, but others could call the primary
  //constructor directly.  I'd rather there be an invariant that signs are normalized.
  def *(other: Fraction) = Fraction(this.n * other.n, this.d * other.d)
}

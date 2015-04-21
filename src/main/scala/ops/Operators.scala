package com.github.kkrull.scala.ops

object Fraction {
  def apply(numerator: Int, denominator: Int): Fraction = {
    def gcd(n: Int, d: Int): Int = {
      var greatest = 1
      (1 to d).foreach(i => {
        if(n % i == 0 && d % i == 0) {
          greatest = i
        }
      })

      greatest
    }

    def normalize(n: Int, d: Int) = if(d < 0) new Fraction(-n, -d) else new Fraction(n, d)

    val g = gcd(numerator, denominator)
    normalize(numerator / g, denominator / g)
  }

  def unapply(x: Fraction): Option[(Int, Int)] = {
    if(x.denominator == 0)
      None
    else
      Some((x.numerator, x.denominator))
  }
}

class Fraction(val numerator: Int, val denominator: Int) {
  private def n = numerator
  private def d = denominator

  def *(other: Fraction) = Fraction(this.n * other.n, this.d * other.d)
  override def toString = "Fraction(%d, %d)".format(numerator, denominator)
}

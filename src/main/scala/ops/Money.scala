package com.github.kkrull.scala.ops

object Money {
  private val centsInADollar = 100

  def main2(args: Array[String]): Unit = {
    val a = Money(1, 101)
    printf("Should be $2.01: %s\n", a)

    val b = Money(2, 20)
    val c = Money(4, 40)
    val subtracted = b - c
    printf("Should be -$2.20: %s\n", subtracted)

    val multiplied = Money(1, 10) * 10
    printf("Should be $11.00: %s\n", multiplied)

    val divided = multiplied / 10
    printf("Should be $1.10: %s\n", divided)
  }

  def apply(d: Int, c: Int): Money = {
    val totalCents = d * centsInADollar + c
    new Money(totalCents / centsInADollar, Math.abs(totalCents % centsInADollar))
  }
}

class Money(val dollars: Int, val cents: Int) {
  def +(other: Money): Money = Money(this.dollars + other.dollars, this.cents + other.cents)
  def -(other: Money): Money = Money(this.dollars - other.dollars, this.cents - other.cents)
  def *(multiplicity: Int): Money = Money(this.dollars * multiplicity, this.cents * multiplicity)
  def /(divisor: Int): Money = {
    val totalCents = this.dollars * 100 + this.cents
    Money(0, totalCents / divisor)
  }

  override def toString: String = {
    if(this.dollars < 0)
      "-$%d.%02d".format(Math.abs(this.dollars), this.cents)
    else
      "$%d.%02d".format(this.dollars, this.cents)
  }
}

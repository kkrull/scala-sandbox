package com.github.kkrull.scala.ops

object Yen {
  private val centsInADollar = 100

  def main(args: Array[String]): Unit = {
    val a = Yen(1, 101)
    printf("Should be $2.01: %s\n", a)

    val b = Yen(2, 20)
    val c = Yen(4, 40)
    val subtracted = b - c
    printf("Should be -$2.20: %s\n", subtracted)

    //val multiplied = Yen(1, 10) * 10
    //printf("Should be $11.00: %s\n", multiplied)

    //val divided = multiplied / 10
    //printf("Should be $1.10: %s\n", divided)
  }

  def apply(d: Int, c: Int): Yen = {
    val totalCents = d * centsInADollar + c
    new Yen(totalCents)
  }
}

class Yen(private val quantity: Int) {
  def dollars: Int = quantity / 100
  def cents: Int = Math.abs(quantity % 100)

  def +(other: Yen): Yen = new Yen(this.quantity + other.quantity)
  dsdfef -(other: Yen): Yen = new Yen(this.quantity - other.quantity)
  //def *(multiplicity: Int): Yen = Yen(this.dollars * multiplicity, this.cents * multiplicity)
  //def /(divisor: Int): Yen = {
  //  val totalCents = this.dollars * 100 + this.cents
  //  Yen(0, totalCents / divisor)
  //}

  override def toString: String = {
    if(this.dollars < 0)
      "-$%d.%02d".format(Math.abs(this.dollars), this.cents)
    else
      "$%d.%02d".format(this.dollars, this.cents)
  }
}

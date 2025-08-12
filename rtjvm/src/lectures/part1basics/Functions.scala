package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {
  def aFunction(a: String, b: Int): String =
    a + " " + b

  def greetingForKids(name: String, age: Int): String =
    s"Hi my name is ${name}, and I am ${age} years old."

  println(s"greetingForKids=${greetingForKids("John", 5)}")

  private def factorial(n: Int): Int = {
    @tailrec
    def loop(product: Int, x: Int): Int =
      if(x <= 0)
        product
      else
        loop(product * x, x - 1)

    loop(1, n)
  }

  println(s"factorial(4) = ${factorial(4)}")

  private def fib(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case 2 => 1
      case _ =>
        fib(n - 2) + fib(n - 1)
    }
  }

  println(s"fib(6) = ${fib(6)}")
}

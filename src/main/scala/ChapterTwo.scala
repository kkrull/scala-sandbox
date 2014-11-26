import System.out.println
import java.util

object ChapterTwo {
  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(4))
    println(formatResult("Fibonacci", 6, fib))

    val arr = Array(1, 6, 3, 4, 5, 2)
    val findAnInteger = () => {
      val query = 5
      val index = firstIndex(arr, (x: Int) => x == query)
      val findMsg = "First index of %d in %s is %d"
      println(findMsg.format(query, util.Arrays.toString(arr), index))
    }
    findAnInteger()

    val findAnEvenNumber = () => {
      val index = firstIndex(arr, (x: Int) => x % 2 == 0)
      val findMsg = "First index of an even number in %s is %d"
      println(findMsg.format(util.Arrays.toString(arr), index))
    }
    findAnEvenNumber()

    println("Powers of 10: %f, %f, %f".format(powerOf10(1), powerOf10(2), powerOf10(3)))
  }

  /* Formatting */

  def formatAbs(x: Int): String = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def formatFactorial(x: Int): String = {
    val msg = "The factorial of %d is %d"
    msg.format(x, factorial(x))
  }

  def formatResult(name: String, x: Int, f: Int => Int): String = {
    "The %s of %d is %d".format(name, x, f(x))
  }

  /* Math */

  def abs(x: Int) = {
    if (x < 0) -x
    else x
  }

  def factorial(ofNumber: Int): Int = {
    @annotation.tailrec
    def loop(num: Int, product: Int): Int =
      if (num <= 0) product
      else loop(num - 1, num * product)

    loop(ofNumber, 1)
  }

  def fib(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  //https://mitpress.mit.edu/sicp/chapter1/node13.html
  def fibIter(n: Int): Int = {
    @annotation.tailrec
    def loop(a: Int, b: Int, count: Int): Int =
      if (count == 0) b
      else loop(a + b, a, count - 1)

    loop(1, 0, n)
  }

  /* Polymorphic functions */

  def firstIndex[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n == as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)

    loop(0)
  }

  def powerOf10(x: Double): Double = {
    val func = partial(Math.pow, 10d)
    func(x)
  }

  def partial[A, B, C](f: (A, B) => C, firstArg: A): B => C = {
    (secondArg: B) => f(firstArg, secondArg)
  }
}
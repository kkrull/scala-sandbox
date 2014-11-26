import System.out.println

object ChapterTwo {
  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(4))

    val n = 5
    println("fib(%d): %d".format(n, fib(n)))
    println("fibIter(%d): %d".format(n, fibIter(n)))
  }

  def formatAbs(x: Int): String = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def formatFactorial(x: Int): String = {
    val msg = "The factorial of %d is %d"
    msg.format(x, factorial(x))
  }

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

  def fibIter(n: Int): Int = {
    @annotation.tailrec
    def loop(a: Int, b: Int, count: Int): Int = {
      if (count == 0) b
      else loop(a + b, a, count - 1)
    }

    loop(1, 0, n)
  }
}
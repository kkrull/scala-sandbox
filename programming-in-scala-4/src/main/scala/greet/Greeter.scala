package greet

object Greeter {
  def main(args: Array[String]): Unit = {
    val greeter = new Greeter()
    println(greeter.makeGreeting())
  }

  def apply(): Greeter = new Greeter()
}

class Greeter {
  def makeGreeting(): String = {
    "Hello World!"
  }
}

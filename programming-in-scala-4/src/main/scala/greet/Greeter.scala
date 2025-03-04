package greet

object Greeter {
  def main(args: Array[String]): Unit = {
    val greeter = new Greeter()
    println(greeter.makeGreeting())
  }
}

class Greeter {
  def makeGreeting(): String = {
    "Hello World!"
  }
}

package greeter

class Greeter {
  def makeGreeting(target: String = "World"): String = {
    s"Hello $target!"
  }
}

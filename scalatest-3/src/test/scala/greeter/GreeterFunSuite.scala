package greeter

import org.scalatest._
import funsuite._

class GreeterFunSuite extends AnyFunSuite {
  test("greeting should address the whole world") {
    val subject = new Greeter()
    val result = subject.makeGreeting()
    assert(result == "Hello World!")
  }
}

import greeter.Greeter
import org.scalatest._
import funsuite._

class HelloSuite extends AnyFunSuite {
  test("greeting should address the whole world") {
    val subject = new Greeter()
    val result = subject.makeGreeting()
    assert(result == "Hello World!")
  }
}

import org.scalatest._
import funsuite._

class HelloSuite extends AnyFunSuite {
  def greeting(): String = {
    "Hello World!"
  }

  test("greeting should address the whole world") {
    val result = greeting()
    assert(result == "Hello World!")
  }
}

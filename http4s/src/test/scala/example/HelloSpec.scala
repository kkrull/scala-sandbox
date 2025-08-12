package example

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class HelloSpec extends AnyFreeSpec with Matchers {
  "Hello" - {
    "says hello" in {
      Hello.greeting shouldEqual "hello"
    }
  }
}

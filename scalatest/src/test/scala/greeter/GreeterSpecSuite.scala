import org.scalatest._
import funspec._

import greeter.Greeter

class GreeterSpec extends AnyFunSpec {
  describe("Greeter") {
    val subject = new Greeter()

    describe("#makeGreeting") {
      it("should greet the world, given no name") {
        val result = subject.makeGreeting()
        assert(result == "Hello World!")
      }

      it("should greet a person by name, given a name") {
        val result = subject.makeGreeting("George")
        assert(result == "Hello George!")
      }
    }
  }
}

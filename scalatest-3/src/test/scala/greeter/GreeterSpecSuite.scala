package greeter

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

class GreeterSpec extends AnyFunSpec with Matchers {
  describe("Greeter") {
    val subject = new Greeter()

    describe("#makeGreeting") {
      it("should greet the world, given no name") {
        subject.makeGreeting() shouldEqual("Hello World!")
      }

      it("should greet a person by name, given a name") {
        subject.makeGreeting("George") shouldEqual("Hello George!")
      }
    }
  }
}

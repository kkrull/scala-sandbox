package com.github.kkrull.scala.funspec
import org.scalatest._

class OneGreeterSpec extends FunSpec with GreeterBehaviors with Matchers {
  it should behave like aGreeter("Hello %s".format(_))
}

class AnotherGreeterSpec extends FunSpec with GreeterBehaviors with Matchers {
  def japaneseTelephoneGreetingFor(name: String) = "もし もし %s".format(name)

  it should behave like aGreeter(japaneseTelephoneGreetingFor)
}

trait GreeterBehaviors { this: FunSpec with Matchers =>
  def aGreeter(greetingForName: (String) => String) {
    it("starts with 1 or more words of greeting") {
      greetingForName("George") should fullyMatch regex """([^\s]+\s)+George"""
    }
    it("end with the given name") {
      greetingForName("World") should endWith("World")
    }
  }
}


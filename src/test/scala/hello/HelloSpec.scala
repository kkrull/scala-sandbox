package com.github.kkrull.scala.hello

import org.scalatest._

class HelloSpec extends FunSpec with Matchers {
  describe(".greeting") {
    it("returns a greeting") {
      assertResult("Hello") { Hello.greeting }
    }
  }
}

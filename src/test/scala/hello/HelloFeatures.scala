package com.github.kkrull.scala.hello

import org.scalatest._

class HelloFeatures extends FeatureSpec with GivenWhenThen {
  info("As a programmer")
  info("In order to get warm fuzzies")
  info("I want to be greeted by the new library that I'm using")

  scenario("Programmatic greeting") {
    When("I ask for a greeting")
    val greeting = Hello.greeting

    Then("I get one, by golly")
    assertResult("Hello") { greeting }
  }
}

package com.github.kkrull.http4s.greet

import cats.effect._
import cats.effect.testing.scalatest.AsyncIOSpec
import org.http4s._
import org.http4s.implicits._
import org.scalatest.freespec.AsyncFreeSpec
import org.scalatest.matchers.should.Matchers

class HelloWorldSpec extends AsyncFreeSpec with AsyncIOSpec with Matchers {
  def retHelloWorld(name: String = "world"): IO[Response[IO]] = {
    val getHello = Request[IO](Method.GET, uri"/hello".addSegment(name))
    val helloWorld = HelloWorldService.impl[IO]
    HelloRoutes
      .helloWorldRoutes(helloWorld)
      .orNotFound(getHello)
  }

  "HelloWorld" - {
    "GET /hello/:name" - {
      "responds 200 OK" in {
        retHelloWorld()
          .map(_.status)
          .asserting(_ shouldBe Status.Ok)
      }

      "responds with a greeting object for the given name" in {
        retHelloWorld(name = "world")
          .flatMap(_.as[String])
          .asserting(_ shouldEqual "{\"message\":\"Hello world\"}")
      }
    }
  }
}

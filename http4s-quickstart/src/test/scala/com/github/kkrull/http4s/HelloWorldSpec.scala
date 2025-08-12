package com.github.kkrull.http4s

import cats.effect._
import cats.effect.testing.scalatest.AsyncIOSpec
import org.http4s._
import org.http4s.implicits._
import org.scalatest.freespec.AsyncFreeSpec
import org.scalatest.matchers.should.Matchers

class HelloWorldSpec extends AsyncFreeSpec with AsyncIOSpec with Matchers {
  val retHelloWorld: IO[Response[IO]] = {
    val getHello = Request[IO](Method.GET, uri"/hello/world")
    val helloWorld = HelloWorld.impl[IO]
    Http4sQuickstartRoutes
      .helloWorldRoutes(helloWorld)
      .orNotFound(getHello)
  }

  "HelloWorld" - {
    "returns status code 200" - {
      retHelloWorld.map(_.status).asserting(_ shouldBe Status.Ok)
    }

    "returns a greeting" - {
      retHelloWorld.flatMap(_.as[String]).asserting(_ shouldEqual "{\"message\":\"Hello, world\"}")
    }
  }
}

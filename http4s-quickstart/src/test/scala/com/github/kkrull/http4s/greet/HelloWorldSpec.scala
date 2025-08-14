package com.github.kkrull.http4s.greet

import cats.effect._
import cats.effect.testing.scalatest.AsyncIOSpec
import io.circe.Json
import org.http4s._
import org.http4s.circe._
import org.http4s.implicits._
import org.scalatest.freespec.AsyncFreeSpec
import org.scalatest.matchers.should.Matchers

class HelloWorldSpec extends AsyncFreeSpec with AsyncIOSpec with Matchers {
  "HelloWorld" - {
    val subject: HttpApp[IO] = new HelloRoutes[IO]()
      .make(HelloWorldService.impl[IO])
      .orNotFound

    "GET /hello/:name" - {
      "responds 200 OK" in
        doRequest(helloRequest())
          .map(_.status)
          .asserting(_ shouldBe Status.Ok)

      "responds with a greeting for the given name" in
        doRequest(helloRequest(name = "world"))
          .flatMap(_.as[Json])
          .map(_ \\ "message")
          .map(_.head)
          .map(_.asString)
          .asserting {
            case Some(first) =>
              first shouldEqual "Hello world"
            case x @ _ =>
              fail(s"invalid match: $x")
          }
    }

    def doRequest(request: Request[IO]): IO[Response[IO]] =
      subject(request)

    def helloRequest(name: String = "world"): Request[IO] = Request[IO](
      Method.GET,
      uri"/hello".addSegment(name),
    )
  }
}

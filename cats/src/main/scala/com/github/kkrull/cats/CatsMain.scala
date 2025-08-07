package com.github.kkrull.cats

import cats.syntax.all._

import scala.concurrent.Future

case class User(id: Int, name: String)

class UserService {
  def findUser(name: String): Future[Option[User]] = {
    name match {
      case "fails" => Future.failed(new RuntimeException(s"failed to look up user: ${name}"))
      case "notfound" => Future.successful(None)
      case "reachable" => Future.successful(Some(User(1, "reachable")))
    }
  }
}

object CatsMain extends App {
  val service = new UserService()

  val fails = service.findUser("fails")
  println(s"fails: ${fails}")

  val notFound = service.findUser("notfound")
  println(s"notFound: ${notFound}")

  val reachable = service.findUser("reachable")
  println(s"reachable: ${reachable}")
}

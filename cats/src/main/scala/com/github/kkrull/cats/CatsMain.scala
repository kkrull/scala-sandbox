package com.github.kkrull.cats

import cats.syntax.all._

import scala.concurrent.Future

case class User(id: Int, name: String)

object CatsMain extends App {
  def findUser(name: String): Future[Option[User]] = {
    name match {
      case "fails" => Future.failed(new RuntimeException(s"failed to look up user: ${name}"))
      case "notfound" => Future.successful(None)
      case "reachable" => Future.successful(Some(User(1, "reachable")))
    }
  }

  val fails = findUser("fails")
  println(s"fails: ${fails}")

  val notFound = findUser("notfound")
  println(s"notFound: ${notFound}")

  val reachable = findUser("reachable")
  println(s"reachable: ${reachable}")
}

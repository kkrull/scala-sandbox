package com.github.kkrull.cats

import cats.syntax.all._

import scala.concurrent.{ExecutionContext, Future}

case class User(id: Int, name: String)

object CatsMain extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global

  def findUser(name: String)(implicit ec: ExecutionContext): Future[Option[User]] = {
    Future({
      println(s"[findUser] lookup '${name}''")
      name match {
        case "fails" =>
          throw new RuntimeException(s"failed to look up user: ${name}")
        case "notfound" => Option.empty[User]
        case "reachable" => Some(User(1, "reachable"))
        case _ => Option.empty[User]
      }
    })
  }


  val fails = findUser("fails")
  println(s"result of fails: ${fails}")

  val notFound = findUser("notfound")
  println(s"result of notFound: ${notFound}")

  val reachable = findUser("reachable")
  println(s"result of reachable: ${reachable}")
}

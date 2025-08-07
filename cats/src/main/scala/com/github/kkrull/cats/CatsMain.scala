package com.github.kkrull.cats

import cats.syntax.all._

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

case class User(id: Int, name: String)

object CatsMain extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global
  val timeout: Duration = Duration.create(1, TimeUnit.SECONDS)

  def findUser(name: String)(implicit ec: ExecutionContext): Future[Option[User]] = {
    Future({
      println(s"[findUser] lookup '${name}'")
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
  println(s"result of fails: ${Await.result(fails, timeout)}")

  val notFound = findUser("notfound")
  println(s"result of notFound: ${Await.result(notFound, timeout)}")

  val reachable = findUser("reachable")
  println(s"result of reachable: ${Await.result(reachable, timeout)}")
}

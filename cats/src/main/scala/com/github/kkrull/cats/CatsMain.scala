package com.github.kkrull.cats

import cats.implicits.{catsSyntaxOptionId, none}

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

case class User(id: Int, name: String)

object CatsMain extends App {
  implicit val ec: ExecutionContext = ExecutionContext.global
  val timeout: Duration = Duration.create(1, TimeUnit.SECONDS)

  def paddedBitmask(mask: Int, numChars: Int): String =
    mask.toBinaryString
      .reverse
      .padTo(numChars, "0")
      .reverse
      .mkString

  def findUser(name: String)(implicit ec: ExecutionContext): Future[Option[User]] = {
    Future({
      println(s"[findUser] lookup '${name}'")
      name match {
        case "fails" =>
          throw new RuntimeException(s"failed to look up user: ${name}")
        case "notfound" => none[User]
        case "reachable" => User(1, "reachable").some
        case _ => none[User]
      }
    })
  }

  def processUser(user: Option[User]): Int = {
    println(s"Processing user: ${user}")
    user.map(_.id).getOrElse(0)
  }

  val idBitmask: Future[Int] = for {
    notFoundResult <- findUser("notfound")
  } yield processUser(notFoundResult)

  val result = Await.result(idBitmask, timeout)
  println(s"Processed users bitmask: ${paddedBitmask(result, 3)}")
}

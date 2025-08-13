package com.github.kkrull.http4s.greet

import cats.Applicative
import cats.data.EitherT
import io.circe.{Encoder, Json}
import org.http4s.EntityEncoder
import org.http4s.circe._

object Name {
  def fromString[F[_]: Applicative](nameData: String): EitherT[F, Exception, Name] =
    if (nameData.isEmpty)
      EitherT.leftT(new IllegalArgumentException(s"Invalid name: $nameData"))
    else
      EitherT.rightT(Name(nameData))
}

final case class Name private (value: String) extends AnyVal

final case class Greeting(message: String) extends AnyVal

object Greeting {
  implicit val greetingEncoder: Encoder[Greeting] = new Encoder[Greeting] {
    final def apply(a: Greeting): Json = Json.obj(
      ("message", Json.fromString(a.message)),
    )
  }

  implicit def greetingEntityEncoder[F[_]]: EntityEncoder[F, Greeting] =
    jsonEncoderOf[F, Greeting]
}

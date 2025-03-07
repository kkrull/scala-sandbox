package roman

import scala.collection.immutable.ListMap

object RomanNumeral {
  val NumberToLetter = ListMap[Int, String](
    10 -> "X",
    5 -> "V",
    1 -> "I"
  )

  def convert(number: Int): String = {
    NumberToLetter get(number) match {
      case Some(letter) =>
        letter
      case None =>
        letterFollowedByRemainder(number)
    }
  }

  private def letterFollowedByRemainder(number: Int): String = {
    val smallerPair = NumberToLetter.find(pair => pair._1 < number)
    smallerPair match {
      case Some((smallerNumber, letter)) =>
        letter + convert(number - smallerNumber)
      case None =>
        "letterFollowedByRemainder"
    }
  }
}

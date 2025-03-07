package roman

import scala.collection.immutable.ListMap

object RomanNumeral {
  val NumberToLetter = ListMap[Int, String](
    50 -> "L",
    10 -> "X",
    5 -> "V",
    1 -> "I"
  )

  def convert(number: Int): String = {
    (NumberToLetter get(number), NumberToLetter get(number + 1)) match {
      case (Some(letterWithExactValue), _) =>
        letterWithExactValue
      case (_, Some(letterWithHigherValue)) =>
        convert(1) + letterWithHigherValue
      case (None, None) =>
        letterFollowedByRemainder(number)
    }
  }

  private def letterFollowedByRemainder(number: Int): String = {
    NumberToLetter.find(pair => pair._1 < number) match {
      case Some((smallerNumber, letter)) =>
        letter + convert(number - smallerNumber)
      case None =>
        "letterFollowedByRemainder"
    }
  }
}

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
    NumberToLetter.get(number) match {
      case Some(letterWithExactValue) =>
        letterWithExactValue
      case None =>
        thenTryLetterWithPrefix(number)
    }
  }

  private def thenTryLetterWithPrefix(number: Int): String = {
    NumberToLetter.get(number + 1) match {
      case Some(letterWithHigherValue) =>
        convert(1) + letterWithHigherValue
      case None =>
        elseLetterWithSuffix(number)
    }
  }

  private def elseLetterWithSuffix(number: Int): String = {
    NumberToLetter.find(pair => pair._1 < number) match {
      case Some((smallerNumber, letter)) =>
        letter + convert(number - smallerNumber)
      case None =>
        "letterFollowedByRemainder"
    }
  }
}

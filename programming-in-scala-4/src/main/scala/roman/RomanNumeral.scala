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
        numberAsMultipleLetters(number)
    }
  }

  private def numberAsMultipleLetters(number: Int): String = {
    lettersThatSubtract(number) match {
      case Some((prefixToSubtract, nominalLetter)) =>
        prefixToSubtract + nominalLetter
      case None =>
        lettersThatAdd(number)
    }
  }

  private def lettersThatSubtract(number: Int): Option[(String, String)] = {
    for {
      highPair <- NumberToLetter
      lowPair <- NumberToLetter.filter(pair => pair._1 < highPair._1)
      if number == (-lowPair._1 + highPair._1)
    } {
      return Some((lowPair._2, highPair._2))
    }

    return None
  }

  private def lettersThatAdd(number: Int): String = {
    NumberToLetter.find(pair => pair._1 < number) match {
      case Some((smallerNumber, letter)) =>
        letter + convert(number - smallerNumber)
      case None =>
        "letterFollowedByRemainder"
    }
  }
}

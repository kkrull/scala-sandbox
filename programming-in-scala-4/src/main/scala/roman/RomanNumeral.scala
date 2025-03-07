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
    NumberToLetter.getOrElse(
      number,
      numberAsMultipleLetters(number)
    )
  }

  private def numberAsMultipleLetters(number: Int): String = {
    letterWithSubtractingPrefix(number)
      .headOption
      .getOrElse(letterWithAddedSuffix(number))
  }

  private def letterWithSubtractingPrefix(number: Int): Iterable[String] = {
    NumberToLetter.flatMap(highPair =>
      NumberToLetter
        .filter(lowPair => lowPair._1 < highPair._1)
        .filter(lowPair => number == (-lowPair._1 + highPair._1))
        .map(lowPair => s"${lowPair._2}${highPair._2}")
    )
  }

  private def letterWithAddedSuffix(number: Int): String = {
    NumberToLetter.find(pair => pair._1 < number) match {
      case Some((smallerNumber, letter)) =>
        letter + convert(number - smallerNumber)
      case None =>
        "letterWithAddedSuffix"
    }
  }
}

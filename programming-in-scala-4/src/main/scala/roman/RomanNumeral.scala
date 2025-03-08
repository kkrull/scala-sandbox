package roman

import scala.collection.immutable.ListMap

object RomanNumeral {
  val NumberToLetter = ListMap[Int, String](
    100 -> "C",
    50 -> "L",
    10 -> "X",
    5 -> "V",
    1 -> "I"
  )

  def convert(number: Int): String = {
    NumberToLetter.get(number)
      .orElse(letterWithSubtractingPrefix(number))
      .orElse(letterWithAddedSuffix(number))
      .get
  }

  private def letterWithSubtractingPrefix(number: Int): Option[String] = {
    NumberToLetter.flatMap(highPair =>
      NumberToLetter
        .filter(lowPair => lowPair._1 < highPair._1)
        .filter(lowPair => number == (-lowPair._1 + highPair._1))
        .map(lowPair => s"${lowPair._2}${highPair._2}")
    ).headOption
  }

  private def letterWithAddedSuffix(number: Int): Option[String] = {
    NumberToLetter.find(pair => pair._1 < number)
      .map((pair) => pair._2 + convert(number - pair._1))
      .headOption
  }
}

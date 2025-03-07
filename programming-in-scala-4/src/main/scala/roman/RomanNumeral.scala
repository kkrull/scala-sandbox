package roman

object RomanNumeral {
  val NumberToLetter = Map(
    (10 -> "X"),
    (5 -> "V"),
    (1 -> "I")
  )

  def convert(number: Int): String = {
    NumberToLetter get(number) match {
      case Some(letter) =>
        letter
      case None =>
        smallValueMadeBigger(number)
    }
  }

  private def smallValueMadeBigger(number: Int): String = {
    NumberToLetter get(number - 1) match {
      case Some(letter) =>
        letter + convert(1)
      case None =>
        "smallValueMadeBigger"
    }
  }
}

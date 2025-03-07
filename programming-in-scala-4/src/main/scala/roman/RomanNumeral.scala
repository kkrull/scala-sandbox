package roman

object RomanNumeral {
  val NumberToLetter = Map(
    (5 -> "V"),
    (1 -> "I")
  )

  def convert(number: Int): String = {
    NumberToLetter get(number) match {
      case Some(letter) => letter
      case None =>
        if(number == (5+1))
          convert(number - 1) + convert(1)
        else if(number == (1+1))
          convert(number - 1) + convert(1)
        else
          "bogus"
    }
  }
}

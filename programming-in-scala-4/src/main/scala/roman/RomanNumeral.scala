package roman

object RomanNumeral {
  def convert(number: Int): String = {
    val letterValues = List(
      ("L", 50),
      ("X", 10),
      ("V", 5),
      ("I", 1)
    )

    for((letter, value) <- letterValues) {
      if(number > value)
        return letter + convert(number - value)
      else if(number == value)
        return letter

      for((smallLetter, smallValue) <- letterValues) {
        if(value / smallValue > 2 && number == (value - smallValue))
          return smallLetter + letter
      }
    }

    "bogus"
  }
}

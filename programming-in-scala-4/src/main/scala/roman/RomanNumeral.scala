package roman

object RomanNumeral {
  def convert(number: Int): String = {
    val letterValues = List(
      ("X", 10),
      ("V", 5),
      ("I", 1)
    )

    for((letter, value) <- letterValues) {
      if(number > value)
        return letter + convert(number - value)
      else if(number == value)
        return letter
      else if(number == (value - 1))
        return convert(1) + convert(value)
    }

    "bogus"
  }
}

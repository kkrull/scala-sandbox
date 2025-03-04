package roman

object RomanNumeral {
  def convert(number: Int): String = {
    val letterValues = List(
      ("L", 50),
      ("X", 10),
      ("V", 5),
      ("I", 1)
    )

    letterValues.find(pair => pair._2 == number) match {
      case Some((letter, _exactValue)) =>
        return letter
      case None =>
        for((largeLetter, largeValue) <- letterValues.filter(pair => pair._2 > number)) {
          for((smallLetter, smallValue) <- letterValues.filter(pair => pair._2 < largeValue)) {
            if(number == (largeValue - smallValue))
              return smallLetter + largeLetter
          }
        }

        letterValues.find(pair => pair._2 < number) match {
          case Some((letter, value)) =>
            letter + convert(number - value)
          case None =>
            "bogus"
        }
    }
  }
}

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
      case Some((letter, _)) =>
        return letter
      case None =>
        for((baselineLetter, baselineValue) <- letterValues) {
          if(number > baselineValue)
            return baselineLetter + convert(number - baselineValue)
          else if(number == baselineValue)
            return baselineLetter

          for((smallerLetter, smallerValue) <- letterValues) {
            val prependingIsShorterThanAppending = baselineValue / smallerValue > 2
            val prependingIsPossible = number == (baselineValue - smallerValue)
            if(prependingIsPossible && prependingIsShorterThanAppending)
              return smallerLetter + baselineLetter
          }
        }

        return "bogus"
    }
  }
}

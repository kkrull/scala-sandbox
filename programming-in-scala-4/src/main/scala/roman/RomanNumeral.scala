package roman

object RomanNumeral {
  def convert(number: Int): String = {
    val letterValues = List(
      ("L", 50),
      ("X", 10),
      ("V", 5),
      ("I", 1)
    )

    for((baselineLetter, baselineValue) <- letterValues) {
      if(number > baselineValue)
        return baselineLetter + convert(number - baselineValue)
      else if(number == baselineValue)
        return baselineLetter

      for((smallerLetter, smallerValue) <- letterValues) {
        val prependingMakesSense = baselineValue / smallerValue > 2
        val prependingPossible = number == (baselineValue - smallerValue)
        if(prependingPossible && prependingMakesSense)
          return smallerLetter + baselineLetter
      }
    }

    "bogus"
  }
}

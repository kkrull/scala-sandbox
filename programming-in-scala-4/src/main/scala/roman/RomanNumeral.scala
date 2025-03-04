package roman

object RomanNumeral {
  def convert(number: Int): String = {
    if(number >= 5 && number < 10)
      "V" + convert(number - 5)
    else if(number == (5-1))
      "IV"
    else if(number <= 3)
      "I".repeat(number)
    else
      "X"
  }
}

package roman

object RomanNumeral {
  def convert(number: Int): String = {
    if(number <= 3)
      "I".repeat(number)
    else if(number == 4)
      "IV"
    else if(number < 10)
      "V" + convert(number - 5)
    else
      "X"
  }
}

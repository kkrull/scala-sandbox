package roman

object RomanNumeral {
  def convert(number: Int): String = {
    if(number <= 3)
      "I".repeat(number)
    else
      "V" + convert(number - 5)
  }
}

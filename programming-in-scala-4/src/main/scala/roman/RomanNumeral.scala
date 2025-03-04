package roman

object RomanNumeral {
  def convert(number: Int): String = {
    if(number > 10)
      convert(10) + convert(number - 10)
    else if(number == 10)
      "X"
    else if(number == (10-1))
      convert(1) + convert(10)
    else if(number > 5)
      "V" + convert(number - 5)
    else if(number == 5)
      "V"
    else if(number == (5-1))
      convert(1) + convert(5)
    else
      "I".repeat(number)
  }
}

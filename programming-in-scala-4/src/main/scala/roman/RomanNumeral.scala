package roman

object RomanNumeral {
  def convert(number: Int): String = {
    if(number == 1)
      "I"
    else
      "bogus"
  }
}

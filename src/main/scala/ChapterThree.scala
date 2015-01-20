import System.out.{printf, println}

object ChapterThree {
  def main(args: Array[String]): Unit = {
    println("Chapter 3")

    println("\nOption")
    val something = Some(42)
    printf("- %s\n", None)
    printf("- %s\n", something)
//    printf("- Answer: %d\n", something.answer())
  }

  sealed trait Opt[+A] {
    def answer(): Int
  }
  case class Some[+A](get: A) extends Opt[A] {
    override def answer(): Int = get()
  }
  case object None extends Opt[Nothing] {
    override def answer(): Int = None
  }
}
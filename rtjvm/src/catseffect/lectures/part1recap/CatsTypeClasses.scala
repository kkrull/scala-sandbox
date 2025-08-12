package catseffect.lectures.part1recap

object CatsTypeClasses {

  /* Functor: Maps data from one type to another */

  trait MyFunctor[F[_]] {
    def map[A, B](initialValue: F[A])(f: A => B): F[B]
  }

  import cats.Functor
  import cats.instances.list._

  def increment[F[_]](container: F[Int])(implicit functor: Functor[F]): F[Int] =
    functor.map(container)(_ + 1)

  import cats.syntax.functor._
  def increment_v2[F[_] : Functor](container: F[Int]): F[Int] =
    container.map(_ + 1)

  /* Applicative: Lifts a type to a wrapped type (e.g. a constructor) */

  trait MyApplicative[F[_]] extends MyFunctor[F] {
    def pure[A](a: A): F[A]
  }

  import cats.Applicative

  // Summon the type class using the companion object's apply method
  val applicativeList = Applicative[List]
  val intLiftedToList: List[Int] = applicativeList.pure(42)

  import cats.syntax.applicative._
  val intLiftedToList_v2 = 42.pure[List]

  /* FlatMap: Chains 2 or more computations */

  trait MyFlatMap[F[_]] extends MyFunctor[F] {
    def flatMap[A, B](container: F[A])(f: A => F[B]): F[B]
  }

  import cats.FlatMap
  val flatMapList = FlatMap[List]

  import cats.syntax.flatMap._
  def crossProduct[F[_]: FlatMap, A, B](fa: F[A], fb: F[B]): F[(A, B)] =
    fa.flatMap(a => fb.map(b => (a, b)))

  /* Monad: Combines Applicative and FlatMap */

  trait MyMonad[F[_]] extends MyApplicative[F] with MyFlatMap[F] {
    override def map[A, B](initialValue: F[A])(f: A => B): F[B] =
      flatMap(initialValue)(a => pure(f(a)))
  }

  import cats.Monad
  val monadList = Monad[List]

  // Import not needed, because covered by extended type classes
//  import cats.syntax.monad._

  def crossProduct_v2[F[_]: Monad, A, B](fa: F[A], fb: F[B]): F[(A, B)] = {
    for {
      a <- fa
      b <- fb
    } yield (a, b)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    println(s"increment: ${increment(list)}")
    println(s"increment_v2: ${increment_v2(list)}")
  }
}

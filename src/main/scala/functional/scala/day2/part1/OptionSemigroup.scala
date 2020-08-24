package functional.scala.day2.part1

object OptionSemigroup {


  trait Semigroup[A] {
    def |+|(left: A, right: A): A
  }


  object Semigroup {
    def apply[A](implicit ev: Semigroup[A]): Semigroup[A] = ev

    implicit val semigroupInt = new Semigroup[Int] {


      override def |+|(left: Int, right: Int): Int = left + right
    }

    implicit def optionSemigroup[A: Semigroup] = new Semigroup[Option[A]] {


      override def |+|(left: Option[A], right: Option[A]): Option[A] = (left, right) match {
        case (None, None) => None
        case (None, d@Some(r)) => d
        case (d@Some(l), None) => d
        case (Some(l), Some(r)) => Some(Semigroup[A].|+|(l, r))
      }
    }

    implicit def tupleSemigroup[A: Semigroup, B: Semigroup] = new Semigroup[(A, B)] {
      override def |+|(left: (A, B), right: (A, B)): (A, B) = (left._1, right._2)
    }

  }

  trait Monoid[A] extends Semigroup[A] {
    def zero: A
  }

  object Monoid {

    def apply[A](implicit ev: Monoid[A]): Monoid[A] = ev


    implicit val intMonoid = new Monoid[Int] {
      override def zero: Int = 0

      override def |+|(left: Int, right: Int): Int = left + right
    }
  }

}

package learning.cats.functors

object Functors {

  sealed trait Tree[+A]

  final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  final case class Leaf[A](value: A) extends Tree[A]

  trait Functor[F[_]] {
    def map[A, B](functor: F[A])(f: A => B): F[B]
  }


  object Functor {
    def apply[F[_]]()(implicit ev: Functor[F]): Functor[F] = ev

    implicit val listFunctor = new Functor[List] {
      override def map[A, B](functor: List[A])(f: A => B): List[B] = functor.map(f)
    }

    implicit val treeFunctor = new Functor[Tree] {
      override def map[A, B](functor: Tree[A])(f: A => B): Tree[B] =
        functor match {
          case Leaf(value) => Leaf(f(value))
          case Branch(left, right) => Branch(map(left)(f), map(right)(f))
        }
    }

  }

  trait MakeItMine[A] {
    def makeItMine(v: A): String
  }

  object MakeItMine {
    def apply[A](v: A)(implicit ev: MakeItMine[A]): String = ev.makeItMine(v)

    implicit val makeItMineString = new MakeItMine[String] {
      override def makeItMine(v: String): String = v + " arshad"
    }

    implicit val makeItMineInt = new MakeItMine[Int] {
      override def makeItMine(v: Int): String = v + " arshad"
    }
  }


}

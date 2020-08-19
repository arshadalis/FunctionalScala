package functional.scala.day2.part1.part2.functor.exercises

import functional.scala.day2.part1.part2.functor.Functor
import learning.cats.monads.IdentityMonad.Identity

object BTreeExample {

  sealed trait BTree[+A]

  final case class Leaf[A](a: A) extends BTree[A]

  final case class Fork[A](left: BTree[A], right: BTree[A]) extends BTree[A]

  implicit val btreeFunctor = new Functor[BTree] {
    override def map[A, B](fa: BTree[A])(func: A => B): BTree[B] = fa match {
      case Leaf(a) => Leaf(func(a))
      case Fork(left, right) => Fork(map(left)(func), map(right)(func))
    }
  }

  object Identity {
    def apply[A](a: A): A = a
  }

  btreeFunctor.map(Leaf(12))(Identity(_))


}

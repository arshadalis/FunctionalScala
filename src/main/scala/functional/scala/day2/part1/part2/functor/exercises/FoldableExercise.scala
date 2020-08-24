package functional.scala.day2.part1.part2.functor.exercises

import functional.scala.day2.part1.part2.functor.exercises.BTreeExample.{BTree, Fork, Leaf}
import scalaz.{Foldable, Monoid}

object FoldableExercise {

  /*val listFoldable = new Foldable[List] {
    override def foldMap[A, B](fa: List[A])(f: A => B)(implicit F: Monoid[B]): B = fa.foldLeft(F.zero)((item, acc) => F.append(item, f(acc)))

    override def foldRight[A, B](fa: List[A], z: => B)(f: (A, B) => B): B = fa.foldRight(z)((item, acc) => f(item, acc))
  }*/

  /*val btreeFoldable = new Foldable[BTree] {
    override def foldMap[A, B](fa: BTree[A])(f: A => B)(implicit F: Monoid[B]): B = fa match {
      case Leaf(a) => f(a)
      case Fork(left, right) => F.append(foldMap(left)(f), foldMap(right)(f))
    }

    override def foldRight[A, B](fa: BTree[A], z: => B)(f: (A, B) => B): B = ???
  }*/

}

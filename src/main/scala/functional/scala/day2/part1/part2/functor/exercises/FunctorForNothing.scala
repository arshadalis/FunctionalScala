package functional.scala.day2.part1.part2.functor.exercises

import functional.scala.day2.part1.part2.functor.Functor

object FunctorForNothing {

  implicit val nothingFunctor = new Functor[Nothing] {
    override def map[A, B](fa: Nothing)(func: A => B): Nothing = ???
  }

}

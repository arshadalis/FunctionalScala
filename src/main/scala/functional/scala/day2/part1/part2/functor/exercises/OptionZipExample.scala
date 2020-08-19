package functional.scala.day2.part1.part2.functor.exercises

import functional.scala.day2.part1.part2.functor.ApplyFunctor

object OptionZipExample {

  type and[A, B] = Tuple2[A, B]
  type λ[A,B]  = Function1[A,B]

  object Zip {

    val zipOption = new ApplyFunctor[Option] {
      override def zip[A, B](fa: Option[A], fb: Option[B]): Option[A and B] = for {
        a <- fa
        b <- fb
      } yield a -> b

      override def map[A, B](fa: Option[A])(func: A λ B): Option[B] = fa match {
        case None => None
        case Some(a) => Some(func(a))
      }
    }

    val zipList = new ApplyFunctor[List] {
      override def zip[A, B](fa: List[A], fb: List[B]): List[(A and B)] = for {
        a <- fa
        b <- fb
      } yield a -> b

      override def map[A, B](fa: List[A])(func: A => B): List[B] = fa.map(func)
    }
  }

}

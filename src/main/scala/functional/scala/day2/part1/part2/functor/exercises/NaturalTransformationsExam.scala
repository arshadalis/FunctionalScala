package functional.scala.day2.part1.part2.functor.exercises

import functional.scala.day2.part1.part2.functor.{NaturalTransformation, ~>}

object NaturalTransformationsExam {

  def listToOption: ~>[List, Option] = new NaturalTransformation[List, Option] {
    override def apply[A](fa: List[A]): Option[A] = fa.headOption
  }

  type EitherStringA[A] = Either[String, A]

  def eitherToOption: ~>[EitherStringA, Option] = new ~>[EitherStringA, Option] {
    override def apply[A](fa: EitherStringA[A]): Option[A] = fa.toOption
  }


}

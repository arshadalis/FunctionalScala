package functional.scala.day2.part1.part2.functor.exercises

import functional.scala.day2.part1.part2.functor.Functor

object ParserExample {


  case class Parser[E, A](parserFun: String => Either[E, (String, A)])

  def parserFunc[E] = new Functor[Parser[E,?]] {
    override def map[A, B](fa: Parser[E, A])(func: A => B): Parser[E, B] = ???
  }

}

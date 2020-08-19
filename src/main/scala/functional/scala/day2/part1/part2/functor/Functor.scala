package functional.scala.day2.part1.part2.functor

trait Functor[F[_]] {

  def map[A, B](fa: F[A])(func: A => B): F[B]

}
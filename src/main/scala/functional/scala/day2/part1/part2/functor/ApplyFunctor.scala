package functional.scala.day2.part1.part2.functor

trait ApplyFunctor[F[_]] extends Functor[F] {
  def zip[A, B](fa: F[A], fb: F[B]): F[(A, B)]
}

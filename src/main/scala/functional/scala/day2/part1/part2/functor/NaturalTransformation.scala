package functional.scala.day2.part1.part2.functor

trait NaturalTransformation[F[_], G[_]] {
  def apply[A](fa: F[A]): G[A]
}


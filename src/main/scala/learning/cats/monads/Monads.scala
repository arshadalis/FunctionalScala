package learning.cats.monads
import scala.language.higherKinds

object Monads {


  case class Person(id: Int, address: String)

  case class Tabut[A](thing: A)

  trait Monad[F[_]] {

    def pure[A](value: A): F[A] // also called point

    def flatMap[A, B](context: F[A])(func: A => F[B]): F[B] // also called bind

    def map[A, B](context: F[A])(func: A => B): F[B] =
      flatMap(context)(a => pure(func(a)))
  }


  object Monad {
    def apply[F[_]]()(implicit ev: Monad[F]): Monad[F] = ev

    implicit val tabutMonad = new Monad[Tabut] {
      override def pure[A](value: A): Tabut[A] = Tabut(value)

      override def flatMap[A, B](context: Tabut[A])(func: A => Tabut[B]): Tabut[B] = func(context.thing)
    }
  }

}
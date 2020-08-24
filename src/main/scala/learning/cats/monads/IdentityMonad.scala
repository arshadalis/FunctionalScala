package learning.cats.monads

import scala.language.higherKinds
import cats.syntax.flatMap._
import cats.syntax.functor._

import cats.Monad

object IdentityMonad {

  type Identity[A] = A

  object Identity {

    /*implicit val intIdentity = new Identity[Int] {
      def pure[A](value: A): Identity[A] = value: Identity[A]

      def map[A, B](identity: Identity[A])(f: A => B): Identity[B]   = f(identity)

      def flatMap[A, B](identity: Identity[A])(f: A => Identity[B]) = f(identity)
    }*/
  }

  def sumOfMonads[F[_] : Monad](f1: F[Int], f2: F[Int]): F[Int] = for {
    x <- f1
    y <- f2
  } yield x + y


}

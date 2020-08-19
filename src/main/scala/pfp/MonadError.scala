package pfp

import cats.{Functor, MonadError}

import scala.util.control.NoStackTrace

object MonadError extends App {
  println("Hello World")

  trait Category

  case object Building extends Category

  case object Bunglow extends Category

  case object Room extends Category


  type EitherT[A] = Either[String, List[A]]

  sealed trait BusinessError extends NoStackTrace
  sealed trait RandomError extends BusinessError

  trait Categories[F[_]] {
    def findAll: F[List[Category]]
  }



}

package learning.cats.monads

object MonadErrors {

  case class User(id: Int, password: String)

  trait Error

  case class UnauthorizedAccessError(user: User) extends Error

  case class LoginError(reason: String, user: User) extends Error

  case object OtherError extends Error

  type ErrorOrUser[A] = Either[Error, A]

}

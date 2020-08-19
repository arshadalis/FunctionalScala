package learning.cats.monads

import cats.MonadError
import cats.instances.either._
import learning.cats.monads.MonadErrors.{Error, ErrorOrUser, OtherError, User}
import org.scalatest.{FunSpec, Matchers}
import cats.Eval

class MonadErrorTest extends FunSpec with Matchers {

  val monadError = MonadError[ErrorOrUser, Error]

  describe("MonadError Test") {
    it("should lift using pure") {
      monadError.pure(User(1, "www")) shouldEqual (Right(User(1, "www")))
    }

    it("should raise an error") {
      Eval.now(12)
    }
  }

}

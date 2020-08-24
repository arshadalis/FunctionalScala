package learning.cats.monads

import org.scalatest.{FunSpec, Matchers}
//import cats.Id

class IdentityMonadTest extends FunSpec with Matchers {

  type Id[A] = A
  describe("Identity Monad") {
    it("should test Id monad") {
      IdentityMonad.sumOfMonads(12: Id[Int], 12: Id[Int]) shouldEqual (24: Id[Int])
    }
  }

}

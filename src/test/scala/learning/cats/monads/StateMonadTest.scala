package learning.cats.monads

import learning.cats.monads.StateMonads.{counter, double, both}
import org.scalatest.{FunSpec, Matchers}

class StateMonadTest extends FunSpec with Matchers {

  describe("State monad test") {
    it("should increment the count") {
      counter.run(10).value shouldEqual(11, "10 was added with 1")

      counter.runS(10).value shouldEqual 11
      counter.runA(10).value shouldEqual "10 was added with 1"
    }
    it("should compose state transformations") {

      both.run(10).value shouldEqual(22, ("10 was added with 1", "11 was multiplied by 2"))


    }
  }

}

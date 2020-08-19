package learning.cats

import org.scalatest.{FunSpec, Matchers}

class PostOrderCalculatorSpec extends FunSpec with Matchers{

  describe("Post order calculator"){
    it("should calculate"){
      PostOrderCalculator.calculate("1 2 + 3 * 11 +").runA(List()).value shouldEqual(20)
    }
  }

}

package custom.monads

import org.scalatest.{FunSpec, Matchers}
import custum.monads.{MLeft, MRight, MyEither}

class MyEitherTest extends FunSpec with Matchers {


  describe("MyEither test") {
    it("should return left type if created type was left") {
      val left: MyEither[Int, String] = MLeft(7)

      left shouldEqual MLeft(7)
    }

    it("should return left as result if called map on left") {
      val left: MyEither[String, Int] = MLeft("error")

      left.map(a => a + 1) shouldEqual MLeft("error")
    }


    it("should return right with result if called map on right") {
      val left: MyEither[String, Int] = MRight(8)

      left.map(a => a + 1) shouldEqual MRight(9)
    }

    it("should return left as result if called flatMap on left") {
      val left: MyEither[String, Int] = MLeft("error")

      left.flatMap(a => MRight(a + 1)) shouldEqual MLeft("error")
    }


    it("should return right with result if called flatMap on right") {
      val left: MyEither[String, Int] = MRight(8)

      left.flatMap(a => MRight(a + 1)) shouldEqual MRight(9)
    }


  }

}

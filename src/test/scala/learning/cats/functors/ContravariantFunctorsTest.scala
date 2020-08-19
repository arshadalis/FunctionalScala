package learning.cats.functors

import learning.cats.functors.ContravariantFunctors.Box
import learning.cats.functors.ContravariantFunctors.Printable.{format, contramap}
import org.scalatest.{FunSpec, Matchers}

class ContravariantFunctorsTest extends FunSpec with Matchers {

  describe("Covariant functors") {
    it("should convert Box to boolean") {

      val boolean = true
      format(boolean) shouldEqual "yes"

      val boxOfBoolean = Box(boolean)
      contramap(boxOfBoolean)(box => box.value) shouldEqual "yes"


    }
  }

}

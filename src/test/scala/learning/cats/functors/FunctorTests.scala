package learning.cats.functors

import learning.cats.functors.Functors._
import org.scalatest.{FunSpec, Matchers}

class FunctorTests extends FunSpec with Matchers {

  describe("Functors Test") {
    it("should map the values of List using List functor") {
      val list = List(1, 2, 3, 4)

      val result = Functor[List].map(list)(a => a * 2)

      result shouldEqual List(2, 4, 6, 8)
    }

    it("should map the Tree of Int") {
      val leaf = Leaf(12)
      val leaf2 = Leaf(14)
      val tree = Branch(leaf, leaf2)

      val leaf1 = Leaf(14)
      val leaf22 = Leaf(16)
      val expectedTree = Branch(leaf1, leaf22)

      Functor[Tree].map(tree)(_ + 2) shouldEqual (expectedTree)

    }

    it("should make it mine for anything"){
      import learning.cats.functors.Functors.MakeItMine.makeItMineString

      MakeItMine("SunnyLeone") shouldEqual("SunnyLeone arshad")
      MakeItMine(12) shouldEqual("12 arshad")
    }
  }

}

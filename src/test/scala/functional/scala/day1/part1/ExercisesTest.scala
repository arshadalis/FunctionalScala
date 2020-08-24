package functional.scala.day1.part1

import functional.scala.day1.part1.Exercises._
import org.scalatest.{FunSpec, Matchers}

class ExercisesTest extends FunSpec with Matchers {

  describe("Sum and Product Types") {
    it("should Prove that A * 1 is equivalent to A ") {
      to1((1, ())) shouldEqual 1
      to1(('A', ())) shouldEqual 'A'
      to1(("Arsh", ())) shouldEqual "Arsh"
      from1(1) shouldEqual(1, ())
      from1('A') shouldEqual('A', ())
      from1("Arsh") shouldEqual("Arsh", ())
    }
    it("Prove that A * 0 is equivalent to 0") {
      PersonNew(12)
    }
  }


  describe("Sized of any container with type F[_]") {
    it("should return size of List") {

      val lisSized = new Sized[List] {
        override def size[A](a: List[A]): Int = a.size
      }

      lisSized.size(List(1, 2, 3, 4)) shouldEqual 4
      lisSized.size(List("a", "b", "c")) shouldEqual 3
    }

    it("should return size of Map[K,V]"){
      type StringKeyMap[V] = Map[String,V]

      val mapSized = new Sized[StringKeyMap] {
        override def size[A](a: StringKeyMap[A]): Int = a.size
      }

      mapSized.size(Map("abc"->12)) shouldEqual 1
      mapSized.size(Map("abc"->"abc")) shouldEqual 1

    }
  }

  describe("Partial Application"){
    it("should return the size of Map created with any Key type"){

      MapSize[String].size(Map("abc"-> 12)) shouldEqual 1

      MapSize[Int].size(Map(12-> 12)) shouldEqual 1



    }
  }

}

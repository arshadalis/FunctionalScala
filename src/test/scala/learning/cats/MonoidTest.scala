package learning.cats

import learning.cats.Monoids.Order
import org.scalatest.{FunSpec, Matchers}
import cats.instances.int._
import cats.instances.option._
import cats.kernel.Monoid
import scala.language.higherKinds

class MonoidTest extends FunSpec with Matchers {

  describe("Add function") {
    it("should combine (add) the elemnts of list using add") {
      Monoids.add(List(1, 2, 3, 4, 5)) shouldEqual (15)
    }


    it("should combine (add) the elemnts of list of options using add") {
      Monoids.add(List(Some(1), Some(2), None, Some(3), Some(4), Some(5))) shouldEqual (Some(15))
    }

    it("should add Orders") {

      implicit val orderMonoid = new Monoid[Order] {
        override def empty: Order = Order(0, 0)

        override def combine(x: Order, y: Order): Order = Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
      }

      val order1 = Order(12.4, 12)
      val order2 = Order(12.4, 12)

      Monoids.add(List(order1, order2)) shouldEqual (Order(24.8, 24))

      Monoids.func(123) shouldEqual ("248.0!")


      val f: Int => String = i => i.toString

      val f2: String => String = str => str + " sss"


      val result = f andThen f2

    }

  }

}

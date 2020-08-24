package learning.cats

import cats.kernel.Monoid
import cats.syntax.monoid._

object Monoids {


  /*The cutting edge SuperAdder v3.5a-32 is the world’s first choice for adding
  together numbers. The main function in the program has signature def
  add(items: List[Int]): Int. In a tragic accident this code is deleted!
  Rewrite the method and save the day!*/


  case class Order(totalCost: Double, quantity: Double)

  def add[A: Monoid](items: List[A]): A = {

    items.foldLeft(Monoid[A].empty)((acc, no) => acc |+| no)
  }


  val func = ((x: Int) => x.toDouble) andThen (_ + 1) andThen (_ * 2) andThen (_ + "!")


}
